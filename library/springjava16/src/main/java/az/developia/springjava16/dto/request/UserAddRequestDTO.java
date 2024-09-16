package az.developia.springjava16.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAddRequestDTO {
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String address;
	private String password;


}
