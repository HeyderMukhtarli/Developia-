package az.developia.springjava16.dto.response;

import lombok.Data;

@Data
public class AuthoritiesListResponseDTO {
	private Long id;

	private String authority;

	private Integer librarian;
	private Integer student;
	private Integer admin;
}
