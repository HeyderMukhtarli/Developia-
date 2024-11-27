package com.developia.balance.services;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.ExpenseCategoryRequestDto;
import com.developia.balance.dto.response.ExpenseCategoryResponseDto;
import com.developia.balance.entity.ExpenseCategory;
import com.developia.balance.exceptionHandler.OurException;
import com.developia.balance.repositories.ExpenseCategoryRepository;
import com.developia.balance.services.interfaces.IExpenseCategoryService;
import com.developia.balance.utils.EntityToDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ExpenseCategoryService implements IExpenseCategoryService {
    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ModelMapper mapper;
    @Override
    public GeneralResponse<List<ExpenseCategoryResponseDto>> getCategories() {
        GeneralResponse<List<ExpenseCategoryResponseDto>> response = new GeneralResponse<>();
        List<ExpenseCategoryResponseDto> responseData=new ArrayList<>();
        List<ExpenseCategory> entities=expenseCategoryRepository.findAll();
        entities.forEach(entity->{
            responseData.add(mapper.map(entity,ExpenseCategoryResponseDto.class));
        });
        response.setData(responseData);
        return response;
    }

    @Override
    public GeneralResponse<String> saveExpenseCategory(ExpenseCategoryRequestDto expenseCategoryRequestDto) {
      ExpenseCategory expenseCategory=new ExpenseCategory();
      mapper.map(expenseCategoryRequestDto,expenseCategory);
        LocalDate date=LocalDate.now();
        expenseCategory.setCreateDate(date);
        expenseCategoryRepository.save(expenseCategory);
        GeneralResponse<String> response=new GeneralResponse<>();

        response.setData("Expense Category saved successfully");

        return response;

    }

    @Override
    public GeneralResponse<String> deleteExpenseCategory(Long id) {
        expenseCategoryRepository.findById(id).orElseThrow(()->new OurException("Expense Category not found"));
        expenseCategoryRepository.deleteById(id);
        GeneralResponse<String> response=new GeneralResponse<>();
        response.setData("Expense Category deleted successfully");
        return response;
    }

    @Override
    public GeneralResponse<String> updateExpenseCategory(Long id,ExpenseCategoryRequestDto expenseCategoryRequestDto) {
    ExpenseCategory expenseCategory= expenseCategoryRepository.findById(id).orElseThrow(()->new RuntimeException("Expense Category not found"));
    mapper.map(expenseCategoryRequestDto,expenseCategory);
    expenseCategoryRepository.save(expenseCategory);
    GeneralResponse<String> response=new GeneralResponse<>();
    response.setData("Expense Category updated successfully");
        return response;
    }
}
