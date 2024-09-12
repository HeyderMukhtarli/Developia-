package az.developia.springjava16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava16.entity.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {

	List<AuthorityEntity> findAllByUsername(String username);
}
