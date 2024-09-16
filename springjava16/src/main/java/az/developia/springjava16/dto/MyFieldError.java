package az.developia.springjava16.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MyFieldError {
    String defaultMessage;
    String field;
}
