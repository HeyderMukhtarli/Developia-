package com.developia.balance.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "incomes")
public class IncomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "income_category_id") // Foreign key column name in the database
    private IncomeCategory incomeCategory;


    @ManyToOne
    @JoinColumn(name = "expense_category_id") // Foreign key column name in the database
    private ExpenseCategory expenseCategory;

    private double amount;
    private LocalDateTime date;
    @Column(name = "balance")
    private Double balance;


    @ManyToOne
    @JoinColumn(name = "user_id")  // Foreign key to User
    private UserEntity user;



}
