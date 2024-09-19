package az.developia.springjava16.controller;

import az.developia.springjava16.dto.GeneralResponse;
import az.developia.springjava16.dto.request.BookUpdateRequestDTO;
import az.developia.springjava16.dto.request.UserAddRequestDTO;
import az.developia.springjava16.dto.request.UserUpdateRequestDTO;
import az.developia.springjava16.dto.response.LoginResponseDTO;
import az.developia.springjava16.dto.response.UsersListResponseDTO;
import az.developia.springjava16.repository.AuthorityRepository;
import az.developia.springjava16.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentRestController {

	private final UserService service;
	private final AuthorityRepository authorityRepository;


	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_STUDENT')")
	public GeneralResponse update(@Valid @RequestBody UserUpdateRequestDTO studentUpdateRequest) {
         GeneralResponse gr=new GeneralResponse();
          service.updateUser(studentUpdateRequest,"student");
		  gr.setMessage("Success");

		 return gr;
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public GeneralResponse<UsersListResponseDTO> getStudents() {
		GeneralResponse gr=new GeneralResponse();
		gr.setData(service.getStudents());
		gr.setMessage("Success");

		return gr;
	}



	@DeleteMapping(path = "/{email}")
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_STUDENT')")
	@ResponseStatus(code = HttpStatus.OK)
	public GeneralResponse deleteByEmail(@PathVariable String email) {
         GeneralResponse gr= new GeneralResponse();
		service.deleteByEmail(email);
		gr.setMessage("Success");
		return gr;
	}





}
