package com.developia.balance.dto.response;

import com.developia.balance.entity.ExpenseCategory;
import com.developia.balance.entity.IncomeCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class IncomeResponseDto {

    private Long id;


    private IncomeCategory incomeCategory;



    private ExpenseCategory expenseCategory;

    private double amount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

}
