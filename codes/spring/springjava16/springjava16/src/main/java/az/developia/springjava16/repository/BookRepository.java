package az.developia.springjava16.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava16.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
