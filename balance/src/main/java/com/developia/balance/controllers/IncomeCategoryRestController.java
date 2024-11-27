package com.developia.balance.controllers;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.ExpenseCategoryRequestDto;
import com.developia.balance.dto.request.IncomeCategoryRequestDto;
import com.developia.balance.dto.response.ExpenseCategoryResponseDto;
import com.developia.balance.dto.response.IncomeCategoryResponseDto;
import com.developia.balance.services.interfaces.IExpenseCategoryService;
import com.developia.balance.services.interfaces.IIncomeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/income-categories")
public class IncomeCategoryRestController {
    private final IIncomeCategoryService incomeCategoryService;
    @GetMapping
    public GeneralResponse<List<IncomeCategoryResponseDto>> getIncomeCategories() {
        return incomeCategoryService.getCategories();
    }

    @PostMapping
    public GeneralResponse<String> addIncomeCategory(@RequestBody IncomeCategoryRequestDto incomeCategoryRequestDto) {
        return incomeCategoryService.saveIncomeCategory(incomeCategoryRequestDto);
    }

    @PutMapping("/{id}")
    public GeneralResponse<String> updateIncomeCategory(@PathVariable Long id,@RequestBody  IncomeCategoryRequestDto incomeCategoryRequestDto) {
        System.out.println(id);
        return incomeCategoryService.updateIncomeCategory(id,incomeCategoryRequestDto);
    }

    @DeleteMapping("/{id}")
    public GeneralResponse<String> deleteIncomeCategory(@PathVariable Long id) {
        return incomeCategoryService.deleteIncomeCategory(id);
    }
}
