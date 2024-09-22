package az.developia.springjava16.service;

import az.developia.springjava16.dto.response.AuthoritiesListResponseDTO;
import az.developia.springjava16.dto.response.AuthoritiesResponseDTO;
import az.developia.springjava16.dto.response.BookResponseDTO;
import az.developia.springjava16.dto.response.UserBooksResponseDTO;
import az.developia.springjava16.entity.*;
import az.developia.springjava16.exceptionHandler.OurException;
import az.developia.springjava16.repository.AuthorityRepository;
import az.developia.springjava16.repository.UserBooksRepository;
import az.developia.springjava16.repository.UserBooksViewRepository;
import az.developia.springjava16.service.interfaces.AuthorityService;
import az.developia.springjava16.service.interfaces.UserBooksService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserBooksServiceImpl implements UserBooksService {

  private  final UserBooksRepository repo;
  private  final UserBooksViewRepository userBooksViewRepository;
  private  final ModelMapper mapper;
    @Override
    public String addUserBooks(String email,Long id) {
       repo.save(UserBooksEntity.builder().email(email).bookId(id).build());
       return "Success";
    }

    @Override
    public String deleteUserBooks(Long id) {
        UserBooksEntity entity = repo.findById(id).orElseThrow(() -> new OurException("kitab tapilmadi", null,""));
        repo.deleteById(id);
        return "Success";
    }

    @Override
    public List<UserBooksResponseDTO> getUserBooks(String email) {
        List<UserBooksViewEntity> entity=repo.findUserBooks(email);;
        System.out.println(entity);
        return  entitiesToDtos(entity);
    }

    private List<UserBooksResponseDTO> entitiesToDtos(List<UserBooksViewEntity> entities) {
        List<UserBooksResponseDTO> dtoEntities = new ArrayList<>();
        for (UserBooksViewEntity en : entities) {
            UserBooksResponseDTO dt = new  UserBooksResponseDTO();
            mapper.map(en, dt);
            try {
                String filePath = en.getFilePath();
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
              dt.setImage(images);
               dtoEntities.add(dt);

            } catch (IOException ex) {
                throw new OurException("IO exception while processing image", null, null);
            }

        }


        return dtoEntities;
    }

    private String getFileExtension(String filePath) {
        String fileName = new File(filePath).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

}
