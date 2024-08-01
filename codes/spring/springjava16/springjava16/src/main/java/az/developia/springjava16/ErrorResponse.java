package az.developia.springjava16;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	private String message;
	private LocalDateTime timestamp;
	private int status;
	private String internalMessage;
	private List<MyFE> fieldErrors;

}
