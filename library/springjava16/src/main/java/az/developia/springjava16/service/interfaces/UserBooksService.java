package az.developia.springjava16.service.interfaces;

import az.developia.springjava16.dto.response.AuthoritiesResponseDTO;
import az.developia.springjava16.dto.response.UserBooksResponseDTO;

import java.util.List;

public interface UserBooksService {
	public String addUserBooks(String username,Long id);


	String deleteUserBooks(Long id);

	List<UserBooksResponseDTO> getUserBooks(String email);
}
