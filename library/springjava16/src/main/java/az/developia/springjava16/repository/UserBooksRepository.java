package az.developia.springjava16.repository;

import az.developia.springjava16.entity.BookEntity;
import az.developia.springjava16.entity.UserBooksEntity;
import az.developia.springjava16.entity.UserBooksViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserBooksRepository extends JpaRepository<UserBooksEntity, Long> {

    @Query("SELECT u FROM UserBooksViewEntity u where  u.email=?1")
    List<UserBooksViewEntity> findUserBooks(String email);

}
