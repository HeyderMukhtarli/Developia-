package az.developia.springjava16.controller;

import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import az.developia.springjava16.dto.request.BookAddRequestDTO;
import az.developia.springjava16.dto.request.BookUpdateNameRequestDTO;
import az.developia.springjava16.dto.request.BookUpdateRequestDTO;
import az.developia.springjava16.dto.response.BookListResponseDTO;
import az.developia.springjava16.dto.response.BookResponseDTO;
import az.developia.springjava16.service.BookServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {
// field setter const
	private final BookServiceImpl service;


	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_BOOK')")
	public String add(@Valid @RequestParam BookAddRequestDTO req, @RequestParam MultipartFile file)  {

		return  service.add(req,file);
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
//	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_BOOK')")
	public void update(@Valid @RequestBody BookUpdateRequestDTO req, BindingResult br) {

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
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK_LIST')")
	public BookListResponseDTO findAll() {

		return service.findAll();
	}

	@GetMapping(path = "/begin/{begin}/length/{length}")
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK_LIST')")
	public BookListResponseDTO findAllByCreatorPagination(@PathVariable Integer begin, @PathVariable Integer length) {

		return service.findAllPagination(begin, length);
	}

	@PatchMapping

	public void updateName(@Valid @RequestBody BookUpdateNameRequestDTO req, BindingResult br) {



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
