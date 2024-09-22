package az.developia.springjava16.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_books_view")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Immutable
public class UserBooksViewEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userBookId;
	private String email;
	private Long book_id;

	private String name;

	private Double price;

	private Integer pageCount;

	private String author;

	private String creator;

	private LocalDateTime registerDate;
	private String imgName;

	private String type;

	private String filePath;
}
