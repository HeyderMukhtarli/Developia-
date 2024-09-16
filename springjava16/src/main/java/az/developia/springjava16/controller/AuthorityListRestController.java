package az.developia.springjava16.controller;

import az.developia.springjava16.dto.GeneralResponse;
import az.developia.springjava16.dto.request.AddRoleRequestDTO;
import az.developia.springjava16.dto.response.AuthoritiesListResponseDTO;
import az.developia.springjava16.dto.response.AuthoritiesResponseDTO;
import az.developia.springjava16.service.interfaces.AuthorityListService;
import az.developia.springjava16.service.interfaces.AuthorityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authority-list")
@RequiredArgsConstructor
public class AuthorityListRestController {
 @Autowired
 private final AuthorityListService service;


	@GetMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize(value = "hasAuthority('ROLE_GET_AUTHORITY_LIST')")
	public List<AuthoritiesListResponseDTO> getAuthorityList() {


		return  service.getAuthoritiesList();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_AUTHORITY')")
	public GeneralResponse<String> getAddRole(@Valid  @RequestBody AddRoleRequestDTO addRole) {
     GeneralResponse<String> gr=new GeneralResponse();
	 gr.setData(service.addRole(addRole));

		return  gr;
	}



}
