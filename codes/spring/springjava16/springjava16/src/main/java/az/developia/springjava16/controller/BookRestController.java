package az.developia.springjava16.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava16.OurException;
import az.developia.springjava16.request.BookAddRequestDTO;
import az.developia.springjava16.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {

	private final BookService service;

	@PostMapping
	public void add(@Valid @RequestBody BookAddRequestDTO req, BindingResult br) {
		req.setAuthor(req.getAuthor().trim());
		if (br.hasErrors()) {
			throw new OurException("melumatlarin tamligi pozulub", "", br);
		}

		service.add(req);
	}

}
