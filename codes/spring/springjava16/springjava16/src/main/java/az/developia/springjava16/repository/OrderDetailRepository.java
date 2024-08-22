package az.developia.springjava16.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava16.entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {

}
