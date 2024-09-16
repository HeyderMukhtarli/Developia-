package az.developia.springjava16.controller;

import az.developia.springjava16.dto.GeneralResponse;
import az.developia.springjava16.dto.request.UserAddRequestDTO;
import az.developia.springjava16.dto.response.LoginResponseDTO;
import az.developia.springjava16.repository.AuthorityRepository;
import az.developia.springjava16.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

	@PostMapping(path = "/add-student")
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_STUDENT')")
	@ResponseStatus(code = HttpStatus.CREATED)

	public void add(@Valid @RequestBody UserAddRequestDTO req, BindingResult br) {


		service.addStudent(req);
	}



	@GetMapping(path = "/login")
	public GeneralResponse<LoginResponseDTO> login() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		GeneralResponse<LoginResponseDTO> gr=new GeneralResponse<>();
		gr.setData(service.findByUsername(username));
             return  gr;
//		return authorityRepository.findAllByUsername(username);

	}

}
