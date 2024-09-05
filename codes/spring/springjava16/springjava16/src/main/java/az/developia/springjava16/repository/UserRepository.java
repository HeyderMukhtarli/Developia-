package az.developia.springjava16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.springjava16.entity.UserEntity;
import jakarta.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Query(value = "INSERT INTO authorities (username,authority) select ?1,authority from authority_list where librarian=1 ", nativeQuery = true)
	@Modifying
	void addUserAuthorities(String username);
}
