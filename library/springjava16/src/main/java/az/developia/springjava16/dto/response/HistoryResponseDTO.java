package az.developia.springjava16.dto.response;

import az.developia.springjava16.enums.LibraryActivity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryResponseDTO {
	private Long id;
	private String email;
	private Long bookId;

	@Enumerated(EnumType.STRING)
	private LibraryActivity activity;
	private String note;
	private String actionDate;
}
