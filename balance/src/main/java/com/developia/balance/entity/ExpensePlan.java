package com.developia.balance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expense_plan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpensePlan{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private BigDecimal estimatedAmount;

	private LocalDate endDate;

	private LocalDate startDate;
	@ManyToOne
	@JoinColumn(name = "user_id")  // Foreign key to User
	private UserEntity user;

}
