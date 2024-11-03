package com.developia.balance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MyFieldError {
    String defaultMessage;
    String field;
}
