package az.developia.springjava16.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava16.request.BookAddRequestDTO;
import az.developia.springjava16.service.BookService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {

	private final BookService service;

	@PostMapping
	public void add(@RequestBody BookAddRequestDTO req) {

		service.add(req);
	}

}
