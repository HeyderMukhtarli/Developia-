package com.developia.balance.repositories;

import com.developia.balance.entity.ExpenseCategory;
import com.developia.balance.entity.IncomeCategory;
import com.developia.balance.entity.IncomeEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {

    // Find by user email
    List<IncomeEntity> findByUser_Email(String username);

    // Find by date range and income category is not null
    List<IncomeEntity> findByDateBetweenAndIncomeCategoryIsNotNullAndUser_Email(LocalDateTime startDate, LocalDateTime endDate, String username);

    // Find by date range, income category, and user email
    List<IncomeEntity> findByDateBetweenAndIncomeCategoryAndUser_Email(LocalDateTime startDate, LocalDateTime endDate, IncomeCategory incomeCategory, String username);

    // Find by date range, expense category, and user email
    List<IncomeEntity> findByDateBetweenAndExpenseCategoryAndUser_Email(LocalDateTime startDate, LocalDateTime endDate, ExpenseCategory expenseCategory, String username);

    // Find by date range and expense category is not null
    List<IncomeEntity> findByDateBetweenAndExpenseCategoryIsNotNullAndUser_Email(LocalDateTime startDate, LocalDateTime endDate, String username);

    // Find by date range and user email (no category filters)
    List<IncomeEntity> findByDateBetweenAndUser_Email(LocalDateTime startDate, LocalDateTime endDate, String username);

    @Query("SELECT i FROM IncomeEntity i WHERE i.date <= :endDate and i.user.email=:username ORDER BY i.date DESC")
    Page<IncomeEntity> findLastBalanceBeforeDateAndUser_Email(@Param("endDate") LocalDateTime endDate, Pageable pageable,String username);
}
