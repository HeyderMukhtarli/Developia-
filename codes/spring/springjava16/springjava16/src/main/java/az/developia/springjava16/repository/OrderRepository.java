package az.developia.springjava16.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava16.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
