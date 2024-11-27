package com.developia.balance.repositories;

import com.developia.balance.entity.ExpenseCategory;
import com.developia.balance.entity.OtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCategoryRepository  extends JpaRepository<ExpenseCategory, Long> {
}
