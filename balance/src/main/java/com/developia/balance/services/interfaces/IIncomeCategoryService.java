package com.developia.balance.services.interfaces;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.IncomeCategoryRequestDto;
import com.developia.balance.dto.response.IncomeCategoryResponseDto;

import java.util.List;

public interface IIncomeCategoryService {
    GeneralResponse<List<IncomeCategoryResponseDto>> getCategories();
    GeneralResponse<String> saveIncomeCategory(IncomeCategoryRequestDto incomeCategoryRequestDto);
    GeneralResponse<String> deleteIncomeCategory(Long id);
    GeneralResponse<String> updateIncomeCategory(Long id,IncomeCategoryRequestDto incomeCategoryRequestDto);
}
