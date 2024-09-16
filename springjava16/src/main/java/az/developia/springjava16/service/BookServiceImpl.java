package az.developia.springjava16.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import az.developia.springjava16.exceptionHandler.OurException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.developia.springjava16.entity.BookEntity;
import az.developia.springjava16.repository.BookRepository;
import az.developia.springjava16.dto.request.BookAddRequestDTO;
import az.developia.springjava16.dto.request.BookUpdateNameRequestDTO;
import az.developia.springjava16.dto.request.BookUpdateRequestDTO;
import az.developia.springjava16.dto.response.BookListResponseDTO;
import az.developia.springjava16.dto.response.BookResponseDTO;
import az.developia.springjava16.dto.response.BookResponseDTOEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookServiceImpl {

	private final BookRepository repository;

	private final ModelMapper mapper;

	public void add(BookAddRequestDTO req) {
		BookEntity entity = new BookEntity();
		mapper.map(req, entity);
		entity.setRegisterDate(LocalDateTime.now());
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		entity.setCreator(username);
		repository.save(entity);

	}

	public BookListResponseDTO findAll() {
		List<BookEntity> entities = repository.findAll();
		return entitiesToDtos(entities);
	}

	public BookListResponseDTO findAllPagination(Integer begin, Integer length) {
		String creator = SecurityContextHolder.getContext().getAuthentication().getName();

		List<BookEntity> entities = repository.findAllByCreatorPagination(creator, begin, length);

		return entitiesToDtos(entities);
	}

	public BookResponseDTO findById(Long id) {
		BookEntity entity = repository.findById(id).orElseThrow(() -> new OurException("kitab tapilmadi", null,""));

		String creator = SecurityContextHolder.getContext().getAuthentication().getName();

		if (entity.getCreator().equals(creator)) {

			BookResponseDTO dto = new BookResponseDTO();
			mapper.map(entity, dto);
			return dto;
		} else {
			throw new OurException("kitab tapilmadi", null,"");
		}

	}

	public void deleteById(Long id) {
		BookEntity entity = repository.findById(id).orElseThrow(() -> new OurException("kitab tapilmadi", null,""));

		String creator = SecurityContextHolder.getContext().getAuthentication().getName();

		if (entity.getCreator().equals(creator)) {
			repository.deleteById(id);
		} else {
			throw new OurException("kitab tapilmadi", null,"");

		}

	}

	public void update(BookUpdateRequestDTO req) {
		Long id = req.getId();
		BookEntity entity = repository.findById(id).orElseThrow(() -> new OurException("kitab tapilmadi", null,""));
		String creator = SecurityContextHolder.getContext().getAuthentication().getName();

		if (entity.getCreator().equals(creator)) {
			mapper.map(req, entity);
			repository.save(entity);
		} else {
			throw new OurException("kitab tapilmadi", null,"");

		}

	}

	public void updateName(BookUpdateNameRequestDTO req) {
		Long id = req.getId();
		BookEntity entity = repository.findById(id).orElseThrow(() -> new OurException("kitab tapilmadi", null,""));

		String creator = SecurityContextHolder.getContext().getAuthentication().getName();

		if (entity.getCreator().equals(creator)) {

			mapper.map(req, entity);
			repository.save(entity);
		} else {
			throw new OurException("kitab tapilmadi", null,"");

		}
	}

	public BookListResponseDTO findAllPagination2(Integer begin, Integer length) {
		List<BookEntity> entities = repository.findAllPagination(begin, length);
		return entitiesToDtos(entities);
	}

	public BookListResponseDTO findByName(String name) {
		List<BookEntity> entities = repository.findAllSearch(name);
		return entitiesToDtos(entities);
	}

	private BookListResponseDTO entitiesToDtos(List<BookEntity> entities) {
		BookListResponseDTO dto = new BookListResponseDTO();
		List<BookResponseDTOEntity> dtoEntities = new ArrayList<BookResponseDTOEntity>();
		for (BookEntity en : entities) {
			BookResponseDTOEntity dt = new BookResponseDTOEntity();
			mapper.map(en, dt);
			dtoEntities.add(dt);
		}
		dto.setBooks(dtoEntities);

		return dto;
	}

}
