package com.developia.balance.dto.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseCategoryResponseDto {

    private Long id;

    private String name;

    private LocalDate createDate;
}
