package az.developia.springjava16.dto.response;

import jakarta.persistence.Lob;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserBooksResponseDTO {

	private Long userBookId;
	private String email;
	private Long book_id;

	private String name;

	private Double price;

	private Integer pageCount;

	private String author;

	private String creator;

	private String registerDate;
	@Lob
	private byte[] image;
}
