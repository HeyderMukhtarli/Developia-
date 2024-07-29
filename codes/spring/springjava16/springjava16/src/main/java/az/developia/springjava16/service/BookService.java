package az.developia.springjava16.service;

import az.developia.springjava16.request.BookAddRequestDTO;
import az.developia.springjava16.response.BookListResponseDTO;
import az.developia.springjava16.response.BookResponseDTO;

public interface BookService {

	void add(BookAddRequestDTO req);

	BookListResponseDTO findAll();

	BookResponseDTO findById(Long id);

	void deleteById(Long id);

}
