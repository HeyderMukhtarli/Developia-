package az.developia.springjava16.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava16.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
