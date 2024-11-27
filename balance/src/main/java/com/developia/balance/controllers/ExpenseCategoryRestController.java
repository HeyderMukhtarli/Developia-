package com.developia.balance.controllers;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.ExpenseCategoryRequestDto;
import com.developia.balance.dto.response.ExpenseCategoryResponseDto;
import com.developia.balance.services.interfaces.IExpenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/expense-categories")
public class ExpenseCategoryRestController {
    private final IExpenseCategoryService expenseCategoryService;
    @GetMapping
    public GeneralResponse<List<ExpenseCategoryResponseDto>> getExpenseCategories() {
        return expenseCategoryService.getCategories();
    }

    @PostMapping
    public GeneralResponse<String> addExpenseCategory(@RequestBody  ExpenseCategoryRequestDto expenseCategoryRequestDto) {
        return expenseCategoryService.saveExpenseCategory(expenseCategoryRequestDto);
    }

    @PutMapping("/{id}")
    public GeneralResponse<String> updateExpenseCategory(@PathVariable Long id,@RequestBody  ExpenseCategoryRequestDto expenseCategoryRequestDto) {
        System.out.println(id);
        return expenseCategoryService.updateExpenseCategory(id,expenseCategoryRequestDto);
    }

    @DeleteMapping("/{id}")
    public GeneralResponse<String> deleteExpenseCategory(@PathVariable Long id) {
        return expenseCategoryService.deleteExpenseCategory(id);
    }
}
