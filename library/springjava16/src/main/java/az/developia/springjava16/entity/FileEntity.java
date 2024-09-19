package az.developia.springjava16.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "authorities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String type;

	private String filePath;

}
