package az.developia.springjava16.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import az.developia.springjava16.dto.GeneralResponse;
import az.developia.springjava16.exceptionHandler.OurException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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


	private final ModelMapper mapper;
	private final String FOLDER_PATH="C:\\Users\\HP\\Desktop\\Desktop\\";

	public String  add(BookAddRequestDTO req, MultipartFile file)  {
		LocalDateTime publishDate = req.getPublishDate().toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();
		String filePath=FOLDER_PATH+file.getOriginalFilename();
		BookEntity bookEntity=repository.save(BookEntity.builder().name(req.getName())
				.filePath(filePath).
				imgName(file.getOriginalFilename())
				.type(file.getContentType())
				.price(req.getPrice())
				.author(req.getAuthor())
				.creator(SecurityContextHolder.getContext().getAuthentication().getName())
				.pageCount(req.getPageCount())
				.registerDate(publishDate).build());
		try {
			file.transferTo(new File(filePath));
		}catch (IOException ex){
			throw new OurException("IO exception",null,null);
		}
		return "book uploaded successfully:" + filePath;


	}



	public List<BookResponseDTO> findAll(Integer begin, Integer length,String search) {
		List<BookEntity> entities = repository.findAllPagination(begin, length,search);
		List<BookResponseDTO> books = new ArrayList<>();

		entities.forEach(data -> {
			try {
				String filePath = data.getFilePath();
				File imageFile = new File(filePath);
				BufferedImage originalImage = ImageIO.read(imageFile);

				if (originalImage == null) {
					throw new OurException("Invalid image file: " + filePath, null, null);
				}

				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				// Determine the file extension (jpg or png)
				String extension = getFileExtension(filePath).toLowerCase();

				if (extension.equals("jpg") || extension.equals("jpeg")) {
					// Compress the image for JPG format
					ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
					ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
					writer.setOutput(ios);
					ImageWriteParam param = writer.getDefaultWriteParam();
					param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
					param.setCompressionQuality(0.5f); // Adjust the quality (0.0 to 1.0)

					writer.write(null, new javax.imageio.IIOImage(originalImage, null, null), param);
					writer.dispose();
				} else if (extension.equals("png")) {
					// For PNG, just write without compression
					ImageIO.write(originalImage, "png", baos);
				} else {
					throw new OurException("Unsupported image format: " + extension, null, null);
				}

				byte[] images = baos.toByteArray();

				// Build the response DTO
				BookResponseDTO bookResponseDTO = BookResponseDTO.builder()
						.image(images)
						.registerDate(data.getRegisterDate().toString())
						.author(data.getAuthor())
						.pageCount(data.getPageCount())
						.price(data.getPrice())
						.id(data.getId())
						.name(data.getName()).build();

				books.add(bookResponseDTO);

			} catch (IOException ex) {
				throw new OurException("IO exception while processing image", null, null);
			}
		});

		return books;
	}

	private String getFileExtension(String filePath) {
		String fileName = new File(filePath).getName();
		int dotIndex = fileName.lastIndexOf('.');
		return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
	}
	public void deleteById(Long id) {
		BookEntity entity = repository.findById(id).orElseThrow(() -> new OurException("kitab tapilmadi", null,""));

		String creator = SecurityContextHolder.getContext().getAuthentication().getName();


			repository.deleteById(id);


	}



	public BookResponseDTO findById(Long id) {
		Optional<BookEntity> entity = repository.findById(id);

	if(entity.isPresent()) {
		try {
			String filePath = entity.get().getFilePath();
			File imageFile = new File(filePath);
			BufferedImage originalImage = ImageIO.read(imageFile);

			if (originalImage == null) {
				throw new OurException("Invalid image file: " + filePath, null, null);
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			// Determine the file extension (jpg or png)
			String extension = getFileExtension(filePath).toLowerCase();

			if (extension.equals("jpg") || extension.equals("jpeg")) {
				// Compress the image for JPG format
				ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
				ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
				writer.setOutput(ios);
				ImageWriteParam param = writer.getDefaultWriteParam();
				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				param.setCompressionQuality(0.5f); // Adjust the quality (0.0 to 1.0)

				writer.write(null, new javax.imageio.IIOImage(originalImage, null, null), param);
				writer.dispose();
			} else if (extension.equals("png")) {
				// For PNG, just write without compression
				ImageIO.write(originalImage, "png", baos);
			} else {
				throw new OurException("Unsupported image format: " + extension, null, null);
			}

			byte[] images = baos.toByteArray();

			// Build the response DTO
			BookResponseDTO bookResponseDTO = BookResponseDTO.builder()
					.image(images)
					.registerDate(entity.get().getRegisterDate().toString())
					.author(entity.get().getAuthor())
					.pageCount(entity.get().getPageCount())
					.price(entity.get().getPrice())
					.id(entity.get().getId())
					.name(entity.get().getName()).build();
			return bookResponseDTO;

		} catch (IOException ex) {
			throw new OurException("IO exception while processing image", null, null);
		}
	}else {
		throw new OurException("Book not exists", null, null);
	}



	}

	public String updateBook(Long id, BookAddRequestDTO req,MultipartFile file) {
		String filePath=FOLDER_PATH+file.getOriginalFilename();
		BookEntity entity = repository.findById(id).orElseThrow(() -> new OurException("kitab tapilmadi", null,""));
                entity.setName(req.getName());
				entity.setFilePath(filePath);
				entity.setImgName(file.getOriginalFilename());
				entity.setType(file.getContentType());
				entity.setPrice(req.getPrice());
				entity.setAuthor(req.getAuthor());
				entity.setCreator(SecurityContextHolder.getContext().getAuthentication().getName());
				entity.setPageCount(req.getPageCount());
				repository.save(entity);

		try {
			file.transferTo(new File(filePath));
		}catch (IOException ex){
			throw new OurException("IO exception",null,null);
		}
		return "Book updated successfully";
	}




}
