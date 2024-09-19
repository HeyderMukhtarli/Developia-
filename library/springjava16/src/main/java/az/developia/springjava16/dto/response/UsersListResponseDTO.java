package az.developia.springjava16.dto.response;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UsersListResponseDTO {

	private String email;

	private String name;
	private String surname;
	private String phone;
	private String address;
	private String password;
	private Integer enabled;
	private String profession;
}
