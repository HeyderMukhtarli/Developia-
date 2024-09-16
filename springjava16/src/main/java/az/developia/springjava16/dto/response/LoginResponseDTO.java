package az.developia.springjava16.dto.response;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoginResponseDTO {

	private String email;

	private String name;
	private String surname;
	private String phone;
	private String address;

	private String profession;

}
