package az.developia.springjava16.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookAddRequestDTO {
	@NotNull(message = "ad mutleqdir")
	@NotBlank(message = "adi bos qoymaq olmaz")
	@Size(min = 2, max = 30, message = "kitab adi min 2 max 30 olar")
	private String name;

	private Double price;

	@Min(value = 0, message = "sehife sayi min 0 ola biler")
	@NotNull(message = "ad mutleqdir")
	private Integer pageCount;

	@NotBlank(message = "muellifi bos qoymaq olmaz")
	private String author;

//	@Past(message = "kecmis tarix yazin ")
//

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
	private OffsetDateTime publishDate;

}
