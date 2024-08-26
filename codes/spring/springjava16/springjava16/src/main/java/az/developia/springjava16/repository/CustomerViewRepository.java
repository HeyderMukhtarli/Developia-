package az.developia.springjava16.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava16.entity.CustomerViewEntity;

public interface CustomerViewRepository extends JpaRepository<CustomerViewEntity, Long> {

}
