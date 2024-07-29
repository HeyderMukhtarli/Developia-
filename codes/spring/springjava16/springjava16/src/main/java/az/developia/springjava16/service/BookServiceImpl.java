package az.developia.springjava16.service;

import org.springframework.stereotype.Service;

import az.developia.springjava16.entity.BookEntity;
import az.developia.springjava16.repository.BookRepository;
import az.developia.springjava16.request.BookAddRequestDTO;
import az.developia.springjava16.response.BookListResponseDTO;
import az.developia.springjava16.response.BookResponseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

	private final BookRepository repository;

	@Override
	public void add(BookAddRequestDTO req) {
		BookEntity entity = new BookEntity();
		entity.setName(req.getName());
		entity.setPrice(req.getPrice());
		entity.setPageCount(req.getPageCount());
		entity.setAuthor(req.getAuthor());
		repository.save(entity);

	}

	@Override
	public BookListResponseDTO findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookResponseDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
