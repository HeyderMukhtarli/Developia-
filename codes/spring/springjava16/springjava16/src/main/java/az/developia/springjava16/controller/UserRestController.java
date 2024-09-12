package az.developia.springjava16.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava16.entity.AuthorityEntity;
import az.developia.springjava16.exception.OurException;
import az.developia.springjava16.repository.AuthorityRepository;
import az.developia.springjava16.request.UserAddRequestDTO;
import az.developia.springjava16.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

	private final UserService service;
	private final AuthorityRepository authorityRepository;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)

	public void add(@Valid @RequestBody UserAddRequestDTO req, BindingResult br) {

		if (br.hasErrors()) {
			throw new OurException("melumatlarin tamligi pozulub", "", br);
		}

		service.add(req);
	}

	@GetMapping(path = "/login")
	public List<AuthorityEntity> login() {
		// login apisini ise salan userin username ne
		// select * from authorities where username=?1
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		return authorityRepository.findAllByUsername(username);

	}

}
