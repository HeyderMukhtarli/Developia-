package com.developia.balance.dto.request;

import com.developia.balance.entity.ExpenseCategory;
import com.developia.balance.entity.IncomeCategory;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class IncomeRequestDto {

    private Long incomeCategory;
    private Long expenseCategory;

    private Double amount;
}
