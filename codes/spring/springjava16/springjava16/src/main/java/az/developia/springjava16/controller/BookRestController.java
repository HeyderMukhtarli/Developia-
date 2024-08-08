package az.developia.springjava16.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava16.exception.OurException;
import az.developia.springjava16.request.BookAddRequestDTO;
import az.developia.springjava16.request.BookUpdateNameRequestDTO;
import az.developia.springjava16.request.BookUpdateRequestDTO;
import az.developia.springjava16.response.BookListResponseDTO;
import az.developia.springjava16.response.BookResponseDTO;
import az.developia.springjava16.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {

	private final BookService service;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@Valid @RequestBody BookAddRequestDTO req, BindingResult br) {

		if (br.hasErrors()) {
			throw new OurException("melumatlarin tamligi pozulub", "", br);
		}

		service.add(req);
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@Valid @RequestBody BookUpdateRequestDTO req, BindingResult br) {

		if (br.hasErrors()) {
			throw new OurException("melumatlarin tamligi pozulub", "", br);
		}

		service.update(req);
	}

	@DeleteMapping(path = "/{id}")
	// /books/20
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {

		service.deleteById(id);
	}

	@GetMapping(path = "/{id}")
	// /books/20
	public BookResponseDTO findById(@PathVariable Long id) {

		return service.findById(id);
	}

	@GetMapping

	public BookListResponseDTO findAll() {

		return service.findAll();
	}

	@PatchMapping

	public void updateName(@Valid @RequestBody BookUpdateNameRequestDTO req, BindingResult br) {

		if (br.hasErrors()) {
			throw new OurException("melumatlarin tamligi pozulub", "", br);
		}

		service.updateName(req);
	}

}
