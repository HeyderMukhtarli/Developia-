package az.developia.springjava16.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava16.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
