package az.developia.springjava16.dto.response;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class BookResponseDTO {
	private Long id;

	private String name;

	private Double price;


	private Integer pageCount;

	private String author;

	private String registerDate;
	private String  imageName;

	private String  mediumFilePath ;
	private String   thumbnailFilePath ;
	private String  originalFilePath ;

}
