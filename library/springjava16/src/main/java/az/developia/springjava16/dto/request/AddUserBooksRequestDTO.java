package az.developia.springjava16.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddUserBooksRequestDTO {
private String email;
private  Long bookId;
}
