package com.developia.balance.repositories;


import com.developia.balance.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {


	List<AuthorityEntity> findAllByEmail(String email);



	@Query(value = "INSERT INTO authorities (authority, email) " +
			"SELECT ?1, u.email " +
			"FROM users u " +
			"JOIN authority_list al ON " +
			"    (u.profession = 'admin' AND al.admin = 1) OR " +
			"    (u.profession = 'user' AND al.user = 1) OR " +
			"WHERE al.authority = ?1", nativeQuery = true)
	@Modifying
	void addAuthority(String authority);
}
