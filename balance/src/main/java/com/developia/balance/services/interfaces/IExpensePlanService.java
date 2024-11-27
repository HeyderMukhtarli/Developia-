package com.developia.balance.services.interfaces;


import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.ExpensePlanRequestDto;
import com.developia.balance.dto.response.ExpensePlanResponseDto;

import java.util.List;

public interface IExpensePlanService {

    GeneralResponse<String> createExpensePlan(ExpensePlanRequestDto expensePlanRequestDto);

    GeneralResponse<List<ExpensePlanResponseDto>> getExpensePlans();

    GeneralResponse<String> updateExpensePlan(Long id, ExpensePlanRequestDto expensePlanRequestDto);

    GeneralResponse<String> deleteExpensePlan(Long id);

    GeneralResponse<String> getReport(Long planId);
}
