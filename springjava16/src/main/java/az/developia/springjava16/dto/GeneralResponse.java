package az.developia.springjava16.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeneralResponse<T> {
    T data;

    ErrorResponse exceptions;
    String message;
    public GeneralResponse(ErrorResponse exceptions) {
        this.exceptions=exceptions;
    }
}
