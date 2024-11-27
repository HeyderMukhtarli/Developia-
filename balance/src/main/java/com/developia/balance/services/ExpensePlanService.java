package com.developia.balance.services;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.ExpenseCategoryRequestDto;
import com.developia.balance.dto.request.ExpensePlanRequestDto;
import com.developia.balance.dto.response.ExpenseCategoryResponseDto;
import com.developia.balance.dto.response.ExpensePlanResponseDto;
import com.developia.balance.entity.ExpenseCategory;
import com.developia.balance.entity.ExpensePlan;
import com.developia.balance.entity.IncomeEntity;
import com.developia.balance.entity.UserEntity;
import com.developia.balance.exceptionHandler.OurException;
import com.developia.balance.repositories.ExpenseCategoryRepository;
import com.developia.balance.repositories.ExpensePlanRepository;
import com.developia.balance.repositories.UserRepository;
import com.developia.balance.services.interfaces.IExpenseCategoryService;
import com.developia.balance.services.interfaces.IExpensePlanService;
import com.developia.balance.utils.EntityToDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensePlanService implements IExpensePlanService {
    private final ExpensePlanRepository expensePlanRepository;
    private final EntityToDto entityToDto;
    private final UserRepository userRepository;
    private final IncomeService incomeService;
    @Override
    public GeneralResponse<String> createExpensePlan(ExpensePlanRequestDto expensePlanRequestDto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow(() -> new OurException("User not found", null, ""));
        ExpensePlan expensePlan = ExpensePlan.builder() // Call builder() directly on the class
                .name(expensePlanRequestDto.getName())
                .endDate(expensePlanRequestDto.getEndDate())
                .startDate(expensePlanRequestDto.getStartDate())
                .estimatedAmount(expensePlanRequestDto.getEstimatedAmount())
                .user(userEntity)
                .build();
        expensePlanRepository.save(expensePlan);
        GeneralResponse<String> response = new GeneralResponse<>();
        response.setData("Expense plan created successfully");
        return response;
    }

    @Override
    public GeneralResponse<List<ExpensePlanResponseDto>> getExpensePlans() {
        List<ExpensePlan> expensePlans = expensePlanRepository.findAll();
        List<ExpensePlanResponseDto> expensePlanDtos = entityToDto.entitiesToDtos(expensePlans, ExpensePlanResponseDto.class);
        GeneralResponse<List<ExpensePlanResponseDto>> response = new GeneralResponse<>();
        response.setData(expensePlanDtos);
        return response;

    }

    @Override
    public GeneralResponse<String> updateExpensePlan(Long id, ExpensePlanRequestDto expensePlanRequestDto) {
        ExpensePlan expensePlan = expensePlanRepository.findById(id).orElseThrow(() -> new OurException("Expense plan not found", null, ""));
        if(expensePlanRequestDto.getName()!=null){
            expensePlan.setName(expensePlanRequestDto.getName());

        }
        if (expensePlanRequestDto.getStartDate() != null) {
            expensePlan.setStartDate(expensePlanRequestDto.getStartDate());
        }
        if (expensePlanRequestDto.getEndDate() != null) {
            expensePlan.setEndDate(expensePlanRequestDto.getEndDate());
        }
        if (expensePlanRequestDto.getEstimatedAmount() != null) {
            expensePlan.setEstimatedAmount(expensePlanRequestDto.getEstimatedAmount());
        }
        expensePlanRepository.save(expensePlan);
        GeneralResponse<String> response = new GeneralResponse<>();
        response.setData("Expense plan updated successfully");
        return response;
    }

    @Override
    public GeneralResponse<String> deleteExpensePlan(Long id) {
        ExpensePlan expensePlan = expensePlanRepository.findById(id).orElseThrow(() -> new OurException("Expense plan not found", null, ""));
        expensePlanRepository.delete(expensePlan);
        GeneralResponse<String> response = new GeneralResponse<>();
        response.setData("Expense plan deleted successfully");
        return response;
    }

    @Override
    public GeneralResponse<String> getReport(Long planId) {
        ExpensePlan expensePlan = expensePlanRepository.findById(planId)
                .orElseThrow(() -> new OurException("Expense plan not found", null, ""));
        LocalDate currentDate = LocalDate.now(); // Get the current date
        LocalDate startDate = expensePlan.getStartDate(); // Get start date
        LocalDate endDate = expensePlan.getEndDate(); // Get end date

        // Check if currentDate is between startDate and endDate (inclusive)
        System.out.println("Current Date: " + currentDate);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);

        if ((currentDate.isEqual(startDate) || currentDate.isAfter(startDate)) &&
                (currentDate.isEqual(endDate) || currentDate.isBefore(endDate))) {

            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

            // Using RoundingMode.HALF_UP to handle non-terminating decimal expansions
            BigDecimal estimatedAmountPerDay = expensePlan.getEstimatedAmount()
                    .divide(new BigDecimal(daysBetween), 2, RoundingMode.HALF_UP); // 2 decimal places

            long pastDays = ChronoUnit.DAYS.between(startDate, currentDate);
            List<IncomeEntity> incomeEntities = incomeService.getExpensesBetweenDates(startDate.atStartOfDay(), currentDate.atStartOfDay());

            BigDecimal totalAmount = BigDecimal.ZERO;
            for (IncomeEntity incomeEntity : incomeEntities) {
                totalAmount = totalAmount.add(new BigDecimal(incomeEntity.getAmount()));
            }

            GeneralResponse<String> response = new GeneralResponse<>();
            response.setData("Estimated : " + estimatedAmountPerDay.multiply(new BigDecimal(pastDays)) + "\n" +
                    "Total amount spent: " + totalAmount + "\n"+"Positive disparity"+ estimatedAmountPerDay.multiply(new BigDecimal(pastDays)).add(totalAmount));
            return response;
        } else {
            throw new OurException("Current date is not between start and end date", null, "");
        }
    }


}
