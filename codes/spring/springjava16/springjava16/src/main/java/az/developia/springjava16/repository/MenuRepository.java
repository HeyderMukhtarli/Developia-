package az.developia.springjava16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava16.entity.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

	List<MenuEntity> findAllByLang(String lang);
}
