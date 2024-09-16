package az.developia.springjava16.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class BookListResponseDTO {
	private List<BookResponseDTOEntity> books;
}
