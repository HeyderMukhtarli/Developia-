package az.developia.springjava16.controller;

import az.developia.springjava16.dto.request.BookAddRequestDTO;
import az.developia.springjava16.dto.request.BookUpdateNameRequestDTO;
import az.developia.springjava16.dto.request.BookUpdateRequestDTO;
import az.developia.springjava16.dto.response.AuthoritiesResponseDTO;
import az.developia.springjava16.dto.response.BookListResponseDTO;
import az.developia.springjava16.dto.response.BookResponseDTO;
import az.developia.springjava16.service.BookServiceImpl;
import az.developia.springjava16.service.interfaces.AuthorityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorities")
@RequiredArgsConstructor
public class AuthorityRestController {
 @Autowired
 private final AuthorityService service;


	@GetMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize(value = "hasAuthority('ROLE_GET_AUTHORITIES')")
	public List<AuthoritiesResponseDTO> getAuthorities() {


		return  service.getAuthorities();
	}



}
