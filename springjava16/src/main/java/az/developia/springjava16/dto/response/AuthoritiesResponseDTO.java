package az.developia.springjava16.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class AuthoritiesResponseDTO {
	private Long id;

	private String username;

	private String authority;
}
