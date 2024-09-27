package az.developia.springjava16.controller;

import az.developia.springjava16.dto.GeneralResponse;
import az.developia.springjava16.entity.BookSearch;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import az.developia.springjava16.dto.request.BookAddRequestDTO;
import az.developia.springjava16.dto.request.BookUpdateNameRequestDTO;
import az.developia.springjava16.dto.request.BookUpdateRequestDTO;
import az.developia.springjava16.dto.response.BookResponseDTO;
import az.developia.springjava16.service.BookServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {
// field setter const
	private final BookServiceImpl service;


	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_BOOKS')")
	public String add(@Valid @ModelAttribute BookAddRequestDTO req, @RequestParam MultipartFile file)  {

		return  service.add(req,file);
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOKS')")
	public GeneralResponse<List<BookResponseDTO>> getBooks(@RequestParam Integer begin, @RequestParam Integer length,@RequestParam(required = false) String search) {
           GeneralResponse<List<BookResponseDTO>> gr=new GeneralResponse();


		   gr.setData(service.findAll(begin,length,search));
		   return gr;


	}

	@DeleteMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_BOOK')")
	@ResponseStatus(code = HttpStatus.OK)
	public GeneralResponse delete(@PathVariable Long id) {
GeneralResponse gr=new		GeneralResponse();
		service.deleteById(id);
		gr.setMessage("Success");
		return gr;

	}

	@GetMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK')")
	public GeneralResponse<BookResponseDTO> findById(@PathVariable Long id) {
           GeneralResponse gr=new GeneralResponse();
		   gr.setData(service.findById(id));
		return gr;
	}

	@PutMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_BOOK')")
	public GeneralResponse<String> updateBook(@PathVariable Long id,@Valid @ModelAttribute BookAddRequestDTO req, @RequestParam MultipartFile file) {
		GeneralResponse<String> gr=new GeneralResponse();
		gr.setData(service.updateBook(id,req,file));
		return gr;
	}
 @GetMapping("/lastSearches")
	public GeneralResponse<List<BookSearch>> getLastSearches(){
	 GeneralResponse<List<BookSearch>> gr=new GeneralResponse();
	 gr.setData(service.getLastSearches());
	 return gr;
 }



}
