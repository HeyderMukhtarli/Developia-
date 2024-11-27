package com.developia.balance.dto.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeCategoryResponseDto {

    private Long id;

    private String name;

    private LocalDate createDate;
}
