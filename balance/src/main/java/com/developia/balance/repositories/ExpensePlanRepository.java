package com.developia.balance.repositories;


import com.developia.balance.entity.ExpensePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensePlanRepository extends JpaRepository<ExpensePlan, Long> {
}
