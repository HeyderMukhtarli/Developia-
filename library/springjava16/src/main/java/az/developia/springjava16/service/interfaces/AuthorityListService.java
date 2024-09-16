package az.developia.springjava16.service.interfaces;

import az.developia.springjava16.dto.request.AddRoleRequestDTO;
import az.developia.springjava16.dto.response.AuthoritiesListResponseDTO;
import az.developia.springjava16.dto.response.AuthoritiesResponseDTO;

import java.util.List;

public interface AuthorityListService {
	public List<AuthoritiesListResponseDTO> getAuthoritiesList();
	String addRole(AddRoleRequestDTO addRoleRequestDTO);

}
