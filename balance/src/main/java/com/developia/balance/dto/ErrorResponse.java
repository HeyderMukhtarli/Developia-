package com.developia.balance.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {
    private String message;
    private String internalMessage;
    private List<MyFieldError> fieldErrors;

}
