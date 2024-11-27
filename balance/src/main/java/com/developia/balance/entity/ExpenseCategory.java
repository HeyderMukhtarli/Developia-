package com.developia.balance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "expense_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ExpenseCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private LocalDate createDate;

}
