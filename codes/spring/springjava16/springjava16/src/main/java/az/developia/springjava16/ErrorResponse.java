package az.developia.springjava16;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ErrorResponse {
    private String message;
    private LocalDateTime timestamp;
    private int status;
    private String internalMessage;

}
