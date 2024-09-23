package az.developia.springjava16.repository;

import az.developia.springjava16.entity.AuthorityListEntity;
import az.developia.springjava16.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {


    List<HistoryEntity> findAllByEmail(String email);
}
