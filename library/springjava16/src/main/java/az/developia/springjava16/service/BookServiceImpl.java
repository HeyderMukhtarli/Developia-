package az.developia.springjava16.service;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import az.developia.springjava16.dto.GeneralResponse;
import az.developia.springjava16.entity.BookSearch;
import az.developia.springjava16.exceptionHandler.OurException;
import az.developia.springjava16.repository.RedisSearchRepository;
import az.developia.springjava16.utils.ImageResizeUtils;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Value;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.developia.springjava16.entity.BookEntity;
import az.developia.springjava16.repository.BookRepository;
import az.developia.springjava16.dto.request.BookAddRequestDTO;
import az.developia.springjava16.dto.request.BookUpdateNameRequestDTO;
import az.developia.springjava16.dto.request.BookUpdateRequestDTO;
import az.developia.springjava16.dto.response.BookResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

@RequiredArgsConstructor
@Service
public class BookServiceImpl {

    private final BookRepository repository;
    private final RedisSearchRepository redisSearchRepository;

    private final ModelMapper mapper;

    private final MinioClient minioClient;

    @Value("${minio.bucket-name}")
    private String bucketName;

    private final String FOLDER_PATH = "C:\\Users\\HP\\Desktop\\Desktop\\";

    public String add(BookAddRequestDTO req, MultipartFile file) {
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                // Create the bucket if it doesn't exist

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
            fileName = file.getOriginalFilename();
            String objectName = "original" + "/" + fileName;
            String thumbnailObjectName = "thumbnail" + "/" + fileName;
            String mediumObjectName = "medium" + "/" + fileName;
            thumbnailBytes = ImageResizeUtils.resizeImage(originalBytes, 150, 150);
            mediumBytes = ImageResizeUtils.resizeImage(originalBytes, 500, 500);
            originalFilePath =bucketName+"/" +uploadToMinio(originalBytes, objectName, file.getContentType());  // Store file path
            thumbnailFilePath =bucketName+"/" + uploadToMinio(thumbnailBytes, thumbnailObjectName, file.getContentType());  // Store thumbnail path
            mediumFilePath =bucketName+"/" + uploadToMinio(mediumBytes, mediumObjectName, file.getContentType());
        } catch (Exception e) {
            throw new OurException("io exception", null, null);
        }


        //////////////////
        LocalDateTime publishDate = req.getPublishDate().toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();

        BookEntity bookEntity = repository.save(BookEntity.builder().name(req.getName())
                .originalFilePath(originalFilePath)
                .mediumFilePath(mediumFilePath)
                .thumbnailFilePath(thumbnailFilePath).
                imgName(file.getOriginalFilename())
                .type(file.getContentType())
                .price(req.getPrice())
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

        // Return the full object path (folder + file name)
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
            fileName = file.getOriginalFilename();
            String objectName = "original" + "/" + fileName;
            String thumbnailObjectName = "thumbnail" + "/" + fileName;
            String mediumObjectName = "medium" + "/" + fileName;
            thumbnailBytes = ImageResizeUtils.resizeImage(originalBytes, 150, 150);
            mediumBytes = ImageResizeUtils.resizeImage(originalBytes, 500, 500);
            originalFilePath =bucketName+"/" +uploadToMinio(originalBytes, objectName, file.getContentType());  // Store file path
            thumbnailFilePath =bucketName+"/" + uploadToMinio(thumbnailBytes, thumbnailObjectName, file.getContentType());  // Store thumbnail path
            mediumFilePath =bucketName+"/" + uploadToMinio(mediumBytes, mediumObjectName, file.getContentType());
        } catch (Exception e) {
            throw new OurException("io exception", null, null);
        }

        ///////////////////
        String filePath = FOLDER_PATH + file.getOriginalFilename();

       entity.setMediumFilePath(mediumFilePath);
       entity.setOriginalFilePath(originalFilePath);
       entity.setThumbnailFilePath(thumbnailFilePath);
        entity.setName(req.getName());
        entity.setOriginalFilePath(filePath);
        entity.setImgName(file.getOriginalFilename());
        entity.setType(file.getContentType());
        entity.setPrice(req.getPrice());
        entity.setAuthor(req.getAuthor());
        entity.setCreator(SecurityContextHolder.getContext().getAuthentication().getName());
        entity.setPageCount(req.getPageCount());
        repository.save(entity);


        return "Book updated successfully";
    }

    @Cacheable(key = "'latest_searches'", value = "BookSearch")
    public List<BookSearch> getLastSearches() {
        List<BookSearch> objects = redisSearchRepository.getLatestSearches();
        System.out.println(objects);
        return objects;
    }
}
