package az.developia.springjava16.repository;

import az.developia.springjava16.entity.AuthorityEntity;
import az.developia.springjava16.entity.AuthorityListEntity;
import az.developia.springjava16.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorityListRepository extends JpaRepository<AuthorityListEntity, Long> {


    Optional<AuthorityListEntity> findByAuthority(String authority);
}
