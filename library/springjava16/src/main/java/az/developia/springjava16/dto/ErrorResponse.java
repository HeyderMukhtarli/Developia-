package az.developia.springjava16.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {
    private String message;
    private String internalMessage;
    private List<MyFieldError> fieldErrors;

}
