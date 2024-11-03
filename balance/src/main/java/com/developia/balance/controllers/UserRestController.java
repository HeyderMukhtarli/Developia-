package com.developia.balance.controllers;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.UserAddRequestDTO;
import com.developia.balance.dto.response.LoginResponseDTO;
import com.developia.balance.repositories.AuthorityRepository;
import com.developia.balance.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

	private final UserService service;
	private final AuthorityRepository authorityRepository;


	@PostMapping(path = "/register-user")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addUser(@Valid @RequestBody UserAddRequestDTO req, BindingResult br) {


		service.addUser(req);
	}

	@GetMapping(path = "/login")
	public GeneralResponse<LoginResponseDTO> login() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		GeneralResponse<LoginResponseDTO> gr=new GeneralResponse<>();
		gr.setData(service.findByUsername(username));
             return  gr;
//		return authorityRepository.findAllByUsername(username);

	}

	@GetMapping(path = "/send-otp")
	public GeneralResponse<String> sendOtp(@RequestParam String email){
		GeneralResponse<String> gr=new GeneralResponse<>();
		gr.setData(service.initiatePasswordReset(email));
		return gr;
	}

	@PostMapping(path = "/verify-otp")
	@ResponseStatus(code = HttpStatus.OK)
	public GeneralResponse<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
		GeneralResponse<String> gr = new GeneralResponse<>();
		gr.setData(service.verifyOtp(email, otp));
		return gr;
	}

	@PostMapping(path = "/reset-password")
	@ResponseStatus(code = HttpStatus.OK)
	public GeneralResponse<String> resetPassword(@RequestParam String email, @RequestParam String password) {
		GeneralResponse<String> gr = new GeneralResponse<>();
		gr.setData(service.resetPassword(email, password));
		return gr;
	}

}
