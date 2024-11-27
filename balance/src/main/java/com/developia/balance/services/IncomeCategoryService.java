package com.developia.balance.services;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.IncomeCategoryRequestDto;
import com.developia.balance.dto.response.IncomeCategoryResponseDto;
import com.developia.balance.entity.IncomeCategory;
import com.developia.balance.exceptionHandler.OurException;
import com.developia.balance.repositories.IncomeCategoryRepository;
import com.developia.balance.services.interfaces.IIncomeCategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeCategoryService implements IIncomeCategoryService {
    private final IncomeCategoryRepository incomeCategoryRepository;
    private final ModelMapper mapper;
    @Override
    public GeneralResponse<List<IncomeCategoryResponseDto>> getCategories() {
        GeneralResponse<List<IncomeCategoryResponseDto>> response = new GeneralResponse<>();
        List<IncomeCategoryResponseDto> responseData=new ArrayList<>();
        List<IncomeCategory> entities=incomeCategoryRepository.findAll();
        entities.forEach(entity->{
            responseData.add(mapper.map(entity,IncomeCategoryResponseDto.class));
        });
        response.setData(responseData);
        return response;
    }

    @Override
    public GeneralResponse<String> saveIncomeCategory(IncomeCategoryRequestDto incomeCategoryRequestDto) {
      IncomeCategory incomeCategory=new IncomeCategory();
      mapper.map(incomeCategoryRequestDto,incomeCategory);
        LocalDate date=LocalDate.now();
        incomeCategory.setCreateDate(date);
        incomeCategoryRepository.save(incomeCategory);
        GeneralResponse<String> response=new GeneralResponse<>();

        response.setData("Income Category saved successfully");

        return response;

    }

    @Override
    public GeneralResponse<String> deleteIncomeCategory(Long id) {
        incomeCategoryRepository.findById(id).orElseThrow(()->new OurException("Income Category not found"));
        incomeCategoryRepository.deleteById(id);
        GeneralResponse<String> response=new GeneralResponse<>();
        response.setData("Income Category deleted successfully");
        return response;
    }

    @Override
    public GeneralResponse<String> updateIncomeCategory(Long id,IncomeCategoryRequestDto incomeCategoryRequestDto) {
    IncomeCategory incomeCategory= incomeCategoryRepository.findById(id).orElseThrow(()->new RuntimeException("Income Category not found"));
    mapper.map(incomeCategoryRequestDto,incomeCategory);
    incomeCategoryRepository.save(incomeCategory);
    GeneralResponse<String> response=new GeneralResponse<>();
    response.setData("Income Category updated successfully");
        return response;
    }
}
