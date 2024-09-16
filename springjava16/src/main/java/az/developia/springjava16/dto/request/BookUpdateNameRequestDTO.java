package az.developia.springjava16.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookUpdateNameRequestDTO {

	@NotNull
	@Min(value = 1, message = "id minimum 1 ola biler")
	private Long id;

	@NotNull(message = "ad mutleqdir")
	@NotBlank(message = "adi bos qoymaq olmaz")
	@Size(min = 2, max = 30, message = "kitab adi min 2 max 30 olar")
	private String name;

}
