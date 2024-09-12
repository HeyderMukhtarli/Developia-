package az.developia.springjava16.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

import az.developia.springjava16.MessageSender;
import az.developia.springjava16.exception.OurException;
import az.developia.springjava16.request.BookAddRequestDTO;
import az.developia.springjava16.request.BookUpdateNameRequestDTO;
import az.developia.springjava16.request.BookUpdateRequestDTO;
import az.developia.springjava16.response.BookListResponseDTO;
import az.developia.springjava16.response.BookResponseDTO;
import az.developia.springjava16.service.BookServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {
// field setter const
	private final BookServiceImpl service;
	private final MessageSender sender;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_BOOK')")
	public void add(@Valid @RequestBody BookAddRequestDTO req, BindingResult br) {

		if (br.hasErrors()) {
			throw new OurException("melumatlarin tamligi pozulub", "", br);
		}

		service.add(req);
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_BOOK')")
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
	// books/Anar
	public BookResponseDTO findById(@PathVariable Long id) {

		return service.findById(id);
	}

	@GetMapping
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK_LIST')")
	public BookListResponseDTO findAll() {

		return service.findAll();
	}

	@GetMapping(path = "/begin/{begin}/length/{length}")
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK_LIST')")
	public BookListResponseDTO findAllByCreatorPagination(@PathVariable Integer begin, @PathVariable Integer length) {

		return service.findAllPagination(begin, length);
	}

	@PatchMapping

	public void updateName(@Valid @RequestBody BookUpdateNameRequestDTO req, BindingResult br) {

		if (br.hasErrors()) {
			throw new OurException("melumatlarin tamligi pozulub", "", br);
		}

		service.updateName(req);
	}

	@GetMapping(path = "/pagination/begin/{begin}/length/{length}")
// /books/pagination/begin/90/length/20
	public BookListResponseDTO findAllPagination(@PathVariable Integer begin, @PathVariable Integer length) {

		return service.findAllPagination(begin, length);
	}

	@GetMapping(path = "/name-search/{name}")

	public BookListResponseDTO findByName(@PathVariable String name) {

		return service.findByName(name);
	}

}
