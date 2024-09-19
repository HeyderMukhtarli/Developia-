package az.developia.springjava16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.springjava16.entity.UserEntity;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Query(value = "INSERT INTO authorities (email,authority) select ?1,authority from authority_list where librarian=1 ", nativeQuery = true)
	@Modifying
	void addUserAuthorities(String username);

	@Query(value = "INSERT INTO authorities (email,authority) select ?1,authority from authority_list where student=1 ", nativeQuery = true)
	@Modifying
	void addStudentAuthorities(String username);

	Optional<UserEntity> findByEmail(String email);
	@Query(value = "select * from users where profession=?1",nativeQuery = true)
	List<UserEntity> findStudents(String prefession);

	void deleteByEmail(String email);
}
