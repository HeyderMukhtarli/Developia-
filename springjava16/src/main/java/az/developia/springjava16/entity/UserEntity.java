package az.developia.springjava16.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {

	@Id
	private String email;

	private String name;
	private String surname;
	private String phone;
	private String address;
	private String password;
	private Integer enabled;
	private String profession;

}
