package az.developia.springjava16.utils;

import net.coobird.thumbnailator.Thumbnails;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class ImageResizeUtils {

    public static byte[] resizeImage(byte[] originalImage, int width, int height) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(originalImage);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Resize image to the given width and height
        Thumbnails.of(bais)
                .size(width, height)
                .toOutputStream(baos);

        return baos.toByteArray();
    }
}