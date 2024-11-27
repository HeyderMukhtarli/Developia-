package com.developia.balance.services;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.ExpenseCategoryRequestDto;
import com.developia.balance.dto.request.IncomeRequestDto;
import com.developia.balance.dto.response.ExpenseCategoryResponseDto;
import com.developia.balance.dto.response.IncomeResponseDto;
import com.developia.balance.entity.ExpenseCategory;
import com.developia.balance.entity.IncomeCategory;
import com.developia.balance.entity.IncomeEntity;
import com.developia.balance.entity.UserEntity;
import com.developia.balance.exceptionHandler.OurException;
import com.developia.balance.repositories.ExpenseCategoryRepository;
import com.developia.balance.repositories.IncomeCategoryRepository;
import com.developia.balance.repositories.IncomeRepository;
import com.developia.balance.repositories.UserRepository;
import com.developia.balance.services.interfaces.IExpenseCategoryService;
import com.developia.balance.services.interfaces.IIncomeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeService implements IIncomeService {
    private final IncomeRepository incomeRepository;
    private final ModelMapper mapper;
    private final IncomeCategoryRepository incomeCategoryRepository;
    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final UserRepository userRepository;

    @Override
    public GeneralResponse<List<IncomeResponseDto>> getCategories() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<IncomeEntity> incomeEntities = incomeRepository.findByUser_Email(username);
        List<IncomeResponseDto> incomeResponseDtos = new ArrayList<>();
        for (IncomeEntity incomeEntity : incomeEntities) {
            IncomeResponseDto incomeResponseDto = mapper.map(incomeEntity, IncomeResponseDto.class);
            incomeResponseDtos.add(incomeResponseDto);
        }
        GeneralResponse<List<IncomeResponseDto>> response = new GeneralResponse<>();
        response.setData(incomeResponseDtos);
        return response;
    }

    @Override
    @Transactional
    public GeneralResponse<String> saveIncome(IncomeRequestDto incomeRequestDto) {
        IncomeEntity incomeEntity = new IncomeEntity();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepository.findByEmail(username).orElseThrow(()->new OurException("User not found",null,""));
        if(user.getBalance()+incomeRequestDto.getAmount()<0){
            throw new OurException("Not enough balance",null,"");
        }

        if(incomeRequestDto.getIncomeCategory()!=null&&incomeRequestDto.getExpenseCategory()!=null){
            throw new OurException("Both category cannot have value",null,"");
        }
        if(incomeRequestDto.getIncomeCategory()!=null){
            incomeEntity.setIncomeCategory(incomeCategoryRepository.findById(incomeRequestDto.getIncomeCategory()).orElseThrow(()->new OurException("Income category not found",null,"")));

        }
        if(incomeRequestDto.getExpenseCategory()!=null){
            incomeEntity.setExpenseCategory(expenseCategoryRepository.findById(incomeRequestDto.getExpenseCategory()).orElseThrow(()->new OurException("Expense category not found",null,"")));
            incomeRequestDto.setAmount(-incomeRequestDto.getAmount());
        }
        incomeEntity.setAmount(incomeRequestDto.getAmount());
        incomeEntity.setDate(LocalDateTime.now());

        incomeEntity.setUser(user);
        incomeRepository.save(incomeEntity);

        user.setBalance(user.getBalance()+incomeRequestDto.getAmount());
        incomeEntity.setBalance(user.getBalance());
        userRepository.save(user);
        GeneralResponse<String> response = new GeneralResponse<>();
        response.setData("Income saved");
        return response;
    }

    @Override
    public GeneralResponse<String> deleteIncome(Long id) {
        IncomeEntity incomeEntity = incomeRepository.findById(id).orElseThrow(()->new OurException("Income not found",null,""));
        incomeRepository.delete(incomeEntity);
        GeneralResponse<String> response = new GeneralResponse<>();
        response.setData("Income deleted");
        return response;
    }

    @Override
    public GeneralResponse<String> updateIncome(Long id, IncomeRequestDto incomeRequestDto) {
        IncomeEntity incomeEntity = incomeRepository.findById(id).orElseThrow(()->new OurException("Income not found",null,""));
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepository.findByEmail(username).orElseThrow(()->new OurException("User not found",null,""));
        if(incomeRequestDto.getIncomeCategory()==null&&incomeRequestDto.getExpenseCategory()==null){
            throw new OurException("Both category cannot be null",null,"");
        }
        if(incomeRequestDto.getIncomeCategory()!=null&&incomeRequestDto.getExpenseCategory()!=null){
            throw new OurException("Both category cannot have value",null,"");
        }
        if(incomeRequestDto.getIncomeCategory()!=null){
            incomeEntity.setIncomeCategory(incomeCategoryRepository.findById(incomeRequestDto.getIncomeCategory()).orElseThrow(()->new OurException("Income category not found",null,"")));

        }
        if(incomeRequestDto.getExpenseCategory()!=null){
            incomeEntity.setExpenseCategory(expenseCategoryRepository.findById(incomeRequestDto.getExpenseCategory()).orElseThrow(()->new OurException("Expense category not found",null,"")));
            incomeRequestDto.setAmount(-incomeRequestDto.getAmount());
        }
        if(incomeRequestDto.getAmount()!=null){
            user.setBalance(user.getBalance()-incomeEntity.getAmount()+incomeRequestDto.getAmount());
            incomeEntity.setBalance(user.getBalance());
        }
        incomeEntity.setAmount(incomeRequestDto.getAmount());

        incomeRepository.save(incomeEntity);
        userRepository.save(user);
        GeneralResponse<String> response = new GeneralResponse<>();
        response.setData("Income updated");
        return response;
    }

    public List<IncomeEntity> getIncomesBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return incomeRepository.findByDateBetweenAndIncomeCategoryIsNotNullAndUser_Email(startDate, endDate,username);
    }
    public List<IncomeEntity> getExpensesBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return incomeRepository.findByDateBetweenAndExpenseCategoryIsNotNullAndUser_Email(startDate, endDate,username);
    }
    public List<IncomeEntity> getBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return incomeRepository.findByDateBetweenAndUser_Email(startDate, endDate,username);
    }
    public List<IncomeEntity> getBetweenDatesByCategory(Long incomeCategory,Long expenseCategory,LocalDateTime startDate, LocalDateTime endDate) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if(incomeCategory!=null){
           IncomeCategory incomeCategory1=incomeCategoryRepository.findById(incomeCategory).orElseThrow(()->new OurException("Income category not found",null,""));
           return incomeRepository.findByDateBetweenAndIncomeCategoryAndUser_Email(startDate, endDate,incomeCategory1,username);
       }
       if(expenseCategory!=null){
           ExpenseCategory expenseCategory1=expenseCategoryRepository.findById(expenseCategory).orElseThrow(()->new OurException("Expense category not found",null,""));
           return incomeRepository.findByDateBetweenAndExpenseCategoryAndUser_Email(startDate, endDate,expenseCategory1,username);
       }
       throw new OurException("Category cannot be null",null,"");
    }

    public IncomeEntity getLastBalanceBeforeDate(LocalDateTime endDate) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Pageable pageable = PageRequest.of(0, 1);  // Get only the first (most recent) record
        Page<IncomeEntity> page = incomeRepository.findLastBalanceBeforeDateAndUser_Email(endDate, pageable,username);
        return page.isEmpty() ? null : page.getContent().get(0);  // Return the first (most recent) result if exists
    }

}
