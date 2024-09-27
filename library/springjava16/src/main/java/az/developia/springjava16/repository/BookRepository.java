package az.developia.springjava16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.springjava16.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

	@Query(value = "SELECT * FROM books WHERE (LOWER(name) LIKE LOWER(CONCAT('%', ?3, '%')) OR LOWER(author) LIKE LOWER(CONCAT('%', ?3, '%')) ) ORDER BY id OFFSET ?1 LIMIT ?2", nativeQuery = true)
	List<BookEntity> findAllPaginationWithSearch(Integer begin, Integer length, String searchTerm);

	@Query(value = "SELECT * FROM books  ORDER BY id OFFSET ?1 LIMIT ?2", nativeQuery = true)
	List<BookEntity> findAllPagination(Integer begin, Integer length);


	// findAllPagination(3,10)

	@Query(value = "select count(*) from books", nativeQuery = true)
	Integer findAllCount();

	@Query(value = "select * from books where name like %?1%", nativeQuery = true)
	List<BookEntity> findAllSearch(String name);

	@Query(value = "select * from books where creator =  ?1 limit ?2,?3", nativeQuery = true)
	List<BookEntity> findAllByCreatorPagination(String creator, Integer begin, Integer length);

}
