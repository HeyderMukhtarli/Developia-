package az.developia.springjava16.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddRoleRequestDTO {
	@NotNull
	private String authority;
	@NotNull
	private Integer librarian;
	@NotNull
	private Integer student;
	@NotNull
	private Integer admin;
}
