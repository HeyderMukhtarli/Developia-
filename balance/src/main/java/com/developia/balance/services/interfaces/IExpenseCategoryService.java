package com.developia.balance.services.interfaces;

import com.developia.balance.dto.request.ExpenseCategoryRequestDto;
import com.developia.balance.dto.response.ExpenseCategoryResponseDto;
import com.developia.balance.dto.GeneralResponse;

import java.util.List;

public interface IExpenseCategoryService {
    GeneralResponse<List<ExpenseCategoryResponseDto>> getCategories();
    GeneralResponse<String> saveExpenseCategory(ExpenseCategoryRequestDto expenseCategoryRequestDto);
    GeneralResponse<String> deleteExpenseCategory(Long id);
    GeneralResponse<String> updateExpenseCategory(Long id,ExpenseCategoryRequestDto expenseCategoryRequestDto);
}
