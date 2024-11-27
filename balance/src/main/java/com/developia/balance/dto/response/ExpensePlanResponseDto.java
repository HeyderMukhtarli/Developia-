package com.developia.balance.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpensePlanResponseDto {
        private Long id;
        private String name;
        private BigDecimal estimatedAmount;

        private LocalDate endDate;

        private LocalDate startDate;

}
