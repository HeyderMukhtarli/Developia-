package az.developia.springjava16.repository;

import az.developia.springjava16.entity.AuthorityListEntity;
import az.developia.springjava16.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileEntity, Long> {


}
