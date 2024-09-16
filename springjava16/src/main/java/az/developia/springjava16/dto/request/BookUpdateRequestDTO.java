package az.developia.springjava16.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookUpdateRequestDTO {

	@NotNull
	@Min(value = 1, message = "id minimum 1 ola biler")
	private Long id;

	@NotNull(message = "ad mutleqdir")
	@NotBlank(message = "adi bos qoymaq olmaz")
	@Size(min = 2, max = 30, message = "kitab adi min 2 max 30 olar")
	private String name;

	private Double price;

	@Min(value = 0, message = "sehife sayi min 0 ola biler")
	@NotNull(message = "ad mutleqdir")
	private Integer pageCount;

	@NotBlank(message = "muellifi bos qoymaq olmaz")
	@Pattern(regexp = "[a-z]{3}", message = "muellifin adi mutleq 3 simvol olmalidir")
	private String author;

	@Past(message = "kecmis tarix yazin ")
	private LocalDate publishDate;
}
