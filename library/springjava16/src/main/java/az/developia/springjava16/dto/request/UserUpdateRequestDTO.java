package az.developia.springjava16.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserUpdateRequestDTO {
	private String email;

	private String name;
	private String surname;
	private String phone;
	private String address;
	private String password;

}
