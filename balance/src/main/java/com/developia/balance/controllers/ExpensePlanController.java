package com.developia.balance.controllers;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.ExpensePlanRequestDto;
import com.developia.balance.dto.response.ExpensePlanResponseDto;
import com.developia.balance.services.interfaces.IExpensePlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/expense-plan")
@RequiredArgsConstructor
public class ExpensePlanController {
    private final IExpensePlanService expensePlanService;

    @PostMapping
    public GeneralResponse<String> createExpensePlan(@RequestBody ExpensePlanRequestDto expensePlanRequestDto) {
        return expensePlanService.createExpensePlan(expensePlanRequestDto);
    }
    @GetMapping
    public GeneralResponse<List<ExpensePlanResponseDto>> getAll() {
        return expensePlanService.getExpensePlans();
    }

    @PutMapping("/{id}")
    public GeneralResponse<String> updateExpensePlan(@PathVariable Long id,@RequestBody ExpensePlanRequestDto expensePlanRequestDto) {
        return expensePlanService.updateExpensePlan(id,expensePlanRequestDto);
    }

    @DeleteMapping("/{id}")
    public GeneralResponse<String> deleteExpensePlan(@PathVariable Long id) {
        return expensePlanService.deleteExpensePlan(id);
    }

    @GetMapping("/report")
    public GeneralResponse<String> getReport(@RequestParam Long planId) {
        return expensePlanService.getReport(planId);
    }
}
