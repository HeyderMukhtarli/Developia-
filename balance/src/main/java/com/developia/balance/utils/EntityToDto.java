package com.developia.balance.utils;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class EntityToDto {
    private final ModelMapper mapper=new ModelMapper();
    ;

    public <E, D> List<D> entitiesToDtos(List<E> entities, Class<D> dtoClass) {
        List<D> dtoEntities = new ArrayList<>();
        for (E entity : entities) {
            D dto = mapper.map(entity, dtoClass);
            dtoEntities.add(dto);
        }
        return dtoEntities;
    }
}