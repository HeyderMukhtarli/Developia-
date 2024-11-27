package com.developia.balance.services.interfaces;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.IncomeRequestDto;
import com.developia.balance.dto.response.IncomeResponseDto;
import com.developia.balance.entity.IncomeEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface IIncomeService {
    GeneralResponse<List<IncomeResponseDto>> getCategories();
    GeneralResponse<String> saveIncome(IncomeRequestDto incomeRequestDto);
    GeneralResponse<String> deleteIncome(Long id);
    GeneralResponse<String> updateIncome(Long id,IncomeRequestDto incomeRequestDto);
    List<IncomeEntity> getIncomesBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
    List<IncomeEntity> getExpensesBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
    List<IncomeEntity> getBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

    List<IncomeEntity> getBetweenDatesByCategory(Long incomeCategory, Long expenseCategory, LocalDateTime startDate, LocalDateTime endDate);

    IncomeEntity getLastBalanceBeforeDate(LocalDateTime endDate);
}
