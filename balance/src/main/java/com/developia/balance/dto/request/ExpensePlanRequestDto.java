package com.developia.balance.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpensePlanRequestDto {

        private String name;
        private BigDecimal estimatedAmount;

        private LocalDate endDate;

        private LocalDate startDate;

}
