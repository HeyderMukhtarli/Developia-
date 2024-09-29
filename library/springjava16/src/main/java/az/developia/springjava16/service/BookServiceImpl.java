package az.developia.springjava16.service;

import java.io.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import az.developia.springjava16.entity.BookSearch;
import az.developia.springjava16.exceptionHandler.OurException;
import az.developia.springjava16.repository.RedisSearchRepository;
import az.developia.springjava16.utils.ImageResizeUtils;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Value;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import az.developia.springjava16.entity.BookEntity;
import az.developia.springjava16.repository.BookRepository;
import az.developia.springjava16.dto.request.BookAddRequestDTO;
import az.developia.springjava16.dto.response.BookResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@Service
public class BookServiceImpl {

    private final BookRepository repository;
    private final RedisSearchRepository redisSearchRepository;

    private final ModelMapper mapper;

    private final MinioClient minioClient;

    @Value("${minio.bucket-name}")
    private String bucketName;


    public String add(BookAddRequestDTO req, MultipartFile file) {
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {

                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
        } catch (Exception e) {
            throw new OurException(e.getMessage(), null, null);
        }

        // Upload the file
        InputStream inputStream = null;
        PutObjectArgs args = null;
        byte[] originalBytes = null;
        String fileName = null;

        byte[] thumbnailBytes = null;
        byte[] mediumBytes = null;
        String originalFilePath = null;
        String thumbnailFilePath = null;
        String mediumFilePath = null;
        try {
            inputStream = file.getInputStream();
            originalBytes = inputStream.readAllBytes();
            fileName = UUID.randomUUID() + "." + getFileExtension(file.getOriginalFilename());
            String objectName = "original" + "/" + fileName;
            String thumbnailObjectName = "thumbnail" + "/" + fileName;
            String mediumObjectName = "medium" + "/" + fileName;
            thumbnailBytes = ImageResizeUtils.resizeImage(originalBytes, 150, 150);
            mediumBytes = ImageResizeUtils.resizeImage(originalBytes, 500, 500);
            originalFilePath = uploadToMinio(originalBytes, objectName, file.getContentType());  // Store file path
            thumbnailFilePath = uploadToMinio(thumbnailBytes, thumbnailObjectName, file.getContentType());  // Store thumbnail path
            mediumFilePath = uploadToMinio(mediumBytes, mediumObjectName, file.getContentType());
        } catch (Exception e) {
            throw new OurException("io exception", null, null);
        }


        //////////////////
        LocalDateTime publishDate = req.getPublishDate().toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();

        BookEntity bookEntity = repository.save(BookEntity.builder().name(req.getName())
                .bucket(bucketName)
                .originalFilePath(originalFilePath)
                .mediumFilePath(mediumFilePath)
                .thumbnailFilePath(thumbnailFilePath)
                .price(req.getPrice())
                .type(getFileExtension(file.getOriginalFilename()))
                .author(req.getAuthor())
                .creator(SecurityContextHolder.getContext().getAuthentication().getName())
                .pageCount(req.getPageCount())
                .registerDate(publishDate).build());

        return "book uploaded successfully:" + originalFilePath;


    }

    private String uploadToMinio(byte[] imageBytes, String objectName, String contentType) throws Exception {
        InputStream imageStream = new ByteArrayInputStream(imageBytes);

        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(imageStream, imageBytes.length, -1)
                .contentType(contentType)
                .build();

        minioClient.putObject(args);
        return objectName;
    }

    @CacheEvict(key = "'latest_searches'", value = "BookSearch")
    public List<BookResponseDTO> findAll(Integer begin, Integer length, String search) {
        List<BookEntity> entities;

        if (search != null) {
            entities = repository.findAllPaginationWithSearch(begin, length, search);
        } else {
            entities = repository.findAllPagination(begin, length);
        }

        List<BookResponseDTO> books = new ArrayList<>();
        if (search != null) {
            BookSearch bookSearch = new BookSearch(search);
            redisSearchRepository.saveSearch(bookSearch);
        }
        entities.forEach(data -> {

            BookResponseDTO bookResponseDTO = BookResponseDTO.builder()
                    .mediumFilePath(data.getMediumFilePath())
                    .originalFilePath(data.getOriginalFilePath())
                    .thumbnailFilePath(data.getThumbnailFilePath())
                    .registerDate(data.getRegisterDate().toString())
                    .author(data.getAuthor())
                    .pageCount(data.getPageCount())
                    .price(data.getPrice())
                    .bucket(data.getBucket())
                    .id(data.getId())
                    .name(data.getName()).build();

            books.add(bookResponseDTO);

        });


        return books;
    }

    private String getFileExtension(String filePath) {
        String fileName = new File(filePath).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public void deleteById(Long id) {
        BookEntity entity = repository.findById(id).orElseThrow(() -> new OurException("kitab tapilmadi", null, ""));
        deleteImageFromMinio(entity.getOriginalFilePath());
        deleteImageFromMinio(entity.getMediumFilePath());
        deleteImageFromMinio(entity.getThumbnailFilePath());
        String creator = SecurityContextHolder.getContext().getAuthentication().getName();


        repository.deleteById(id);


    }


    public BookResponseDTO findById(Long id) {
        Optional<BookEntity> entity = repository.findById(id);

        if (entity.isPresent()) {

            BookResponseDTO bookResponseDTO = BookResponseDTO.builder()
                    .originalFilePath(entity.get().getOriginalFilePath())
                    .mediumFilePath(entity.get().getMediumFilePath())
                    .thumbnailFilePath(entity.get().getThumbnailFilePath())
                    .registerDate(entity.get().getRegisterDate().toString())
                    .author(entity.get().getAuthor())
                    .pageCount(entity.get().getPageCount())
                    .price(entity.get().getPrice())
                    .id(entity.get().getId())
                    .bucket(entity.get().getBucket())
                    .name(entity.get().getName()).build();

            return bookResponseDTO;


        } else {
            throw new OurException("Book not exists", null, null);
        }

    }

    public String updateBook(Long id, BookAddRequestDTO req, MultipartFile file) {
        BookEntity entity = repository.findById(id).orElseThrow(() -> new OurException("kitab tapilmadi", null, ""));
        InputStream inputStream = null;
        PutObjectArgs args = null;
        byte[] originalBytes = null;
        String fileName = null;

        byte[] thumbnailBytes = null;
        byte[] mediumBytes = null;
        String originalFilePath = null;
        String thumbnailFilePath = null;
        String mediumFilePath = null;
        try {
            inputStream = file.getInputStream();
            originalBytes = inputStream.readAllBytes();
            fileName = UUID.randomUUID() + "." + getFileExtension(file.getOriginalFilename());
            String objectName = "original" + "/" + fileName;
            String thumbnailObjectName = "thumbnail" + "/" + fileName;
            String mediumObjectName = "medium" + "/" + fileName;
            thumbnailBytes = ImageResizeUtils.resizeImage(originalBytes, 150, 150);
            mediumBytes = ImageResizeUtils.resizeImage(originalBytes, 500, 500);
            originalFilePath = uploadToMinio(originalBytes, objectName, file.getContentType());  // Store file path
            thumbnailFilePath = uploadToMinio(thumbnailBytes, thumbnailObjectName, file.getContentType());  // Store thumbnail path
            mediumFilePath = uploadToMinio(mediumBytes, mediumObjectName, file.getContentType());
            deleteImageFromMinio(entity.getOriginalFilePath());
            deleteImageFromMinio(entity.getMediumFilePath());
            deleteImageFromMinio(entity.getThumbnailFilePath());
        } catch (Exception e) {
            throw new OurException("io exception", null, null);
        }

        ///////////////////
        entity.setBucket(bucketName);
        entity.setMediumFilePath(mediumFilePath);
        entity.setOriginalFilePath(originalFilePath);
        entity.setThumbnailFilePath(thumbnailFilePath);
        entity.setName(req.getName());
        entity.setPrice(req.getPrice());
        entity.setAuthor(req.getAuthor());
        entity.setCreator(SecurityContextHolder.getContext().getAuthentication().getName());
        entity.setPageCount(req.getPageCount());
        entity.setType(getFileExtension(file.getOriginalFilename()));
        repository.save(entity);


        return "Book updated successfully";
    }

    @Cacheable(key = "'latest_searches'", value = "BookSearch")
    public List<BookSearch> getLastSearches() {
        List<BookSearch> objects = redisSearchRepository.getLatestSearches();
        System.out.println(objects);
        return objects;
    }


    public void deleteImageFromMinio(String objectName) {
        try {
            // Check if the object exists before attempting to delete

            System.out.println("Object exists, proceeding to delete...");

            RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .build();

            minioClient.removeObject(removeObjectArgs);


        } catch (MinioException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to delete file from MinIO: " + objectName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting file: " + objectName);
        }
    }
}
