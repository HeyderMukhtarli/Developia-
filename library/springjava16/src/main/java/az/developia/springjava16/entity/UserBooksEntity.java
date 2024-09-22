package az.developia.springjava16.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBooksEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String email;


	private long bookId;



}
