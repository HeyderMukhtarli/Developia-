package az.developia.springjava16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava16.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {


	List<AuthorityEntity> findAllByEmail(String email);



	@Query(value = "INSERT INTO authorities (authority, email) " +
			"SELECT ?1, u.email " +
			"FROM users u " +
			"JOIN authority_list al ON " +
			"    (u.profession = 'admin' AND al.admin = 1) OR " +
			"    (u.profession = 'librarian' AND al.librarian = 1) OR " +
			"    (u.profession = 'student' AND al.student = 1) " +
			"WHERE al.authority = ?1", nativeQuery = true)
	@Modifying
	void addAuthority(String authority);
}
