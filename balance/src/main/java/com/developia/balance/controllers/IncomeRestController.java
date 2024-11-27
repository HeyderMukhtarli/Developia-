package com.developia.balance.controllers;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.IncomeRequestDto;
import com.developia.balance.dto.response.IncomeResponseDto;
import com.developia.balance.entity.IncomeEntity;
import com.developia.balance.services.interfaces.IIncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/incomes")
public class IncomeRestController {
    private final IIncomeService incomeService;
    @GetMapping
    public GeneralResponse<List<IncomeResponseDto>> getIncomeCategories() {
        return incomeService.getCategories();
    }

    @PostMapping
    public GeneralResponse<String> addIncome(@RequestBody IncomeRequestDto incomeRequestDto) {
        return incomeService.saveIncome(incomeRequestDto);
    }

    @PutMapping("/{id}")
    public GeneralResponse<String> updateIncome(@PathVariable Long id,@RequestBody  IncomeRequestDto incomeRequestDto) {
        System.out.println(id);
        return incomeService.updateIncome(id,incomeRequestDto);
    }

    @DeleteMapping("/{id}")
    public GeneralResponse<String> deleteIncome(@PathVariable Long id) {
        return incomeService.deleteIncome(id);
    }
    @GetMapping("/incomes-between-dates")
    public List<IncomeEntity> getIncomesBetweenDates(@RequestParam("start") String start, @RequestParam("end") String end) {
        LocalDateTime startDate = LocalDateTime.parse(start);
        LocalDateTime endDate = LocalDateTime.parse(end);
        return incomeService.getIncomesBetweenDates(startDate, endDate);
    }
    @GetMapping("/expenses-between-dates")
    public List<IncomeEntity> getExpensesBetweenDates(@RequestParam("start") String start, @RequestParam("end") String end) {
        LocalDateTime startDate = LocalDateTime.parse(start);
        LocalDateTime endDate = LocalDateTime.parse(end);
        return incomeService.getExpensesBetweenDates(startDate, endDate);
    }
    @GetMapping("/between-dates")
    public List<IncomeEntity> getBetweenDates(@RequestParam("start") String start, @RequestParam("end") String end) {
        LocalDateTime startDate = LocalDateTime.parse(start);
        LocalDateTime endDate = LocalDateTime.parse(end);
        return incomeService.getBetweenDates(startDate, endDate);
    }
    @GetMapping("/between-dates-category")
    public List<IncomeEntity> getBetweenDatesByCategory(
            @RequestParam(value = "incomeCategory", required = false) Long incomeCategory,
            @RequestParam(value = "expenseCategory", required = false) Long expenseCategory,
            @RequestParam("start") String start,
            @RequestParam("end") String end) {

        LocalDateTime startDate = LocalDateTime.parse(start);
        LocalDateTime endDate = LocalDateTime.parse(end);

        return incomeService.getBetweenDatesByCategory(incomeCategory, expenseCategory, startDate, endDate);
    }

    @GetMapping("/last-balance")
    public GeneralResponse<IncomeEntity> getLastBalanceBeforeDate(@RequestParam LocalDateTime endDate) {
        IncomeEntity lastIncome = incomeService.getLastBalanceBeforeDate(endDate);
        GeneralResponse gr=new GeneralResponse();
        gr.setData(lastIncome);
        return gr;
    }


}
