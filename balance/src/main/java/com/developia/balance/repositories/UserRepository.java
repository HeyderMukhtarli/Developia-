package com.developia.balance.repositories;

import com.developia.balance.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {



	@Query(value = "INSERT INTO authorities (email,authority) select ?1,authority from authority_list where type_user=1 ", nativeQuery = true)
	@Modifying
	void addUserAuthorities(String username);

	Optional<UserEntity> findByEmail(String email);
	@Query(value = "select * from users where user_type=?1",nativeQuery = true)
	List<UserEntity> findStudents(String user_type);

	void deleteByEmail(String email);
}
