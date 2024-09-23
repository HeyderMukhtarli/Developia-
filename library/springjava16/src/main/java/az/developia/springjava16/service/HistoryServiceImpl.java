package az.developia.springjava16.service;

import az.developia.springjava16.dto.response.AuthoritiesListResponseDTO;
import az.developia.springjava16.dto.response.HistoryResponseDTO;
import az.developia.springjava16.dto.response.UserBooksResponseDTO;
import az.developia.springjava16.entity.AuthorityListEntity;
import az.developia.springjava16.entity.HistoryEntity;
import az.developia.springjava16.entity.UserBooksEntity;
import az.developia.springjava16.entity.UserBooksViewEntity;
import az.developia.springjava16.enums.LibraryActivity;
import az.developia.springjava16.exceptionHandler.OurException;
import az.developia.springjava16.repository.HistoryRepository;
import az.developia.springjava16.repository.UserBooksRepository;
import az.developia.springjava16.repository.UserBooksViewRepository;
import az.developia.springjava16.service.interfaces.UserBooksService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@EnableCaching
public class HistoryServiceImpl  {
private final HistoryRepository historyRepository;
private  final ModelMapper mapper;


    public List<HistoryResponseDTO> getHistories(String email) {
        List<HistoryEntity> historyEntities=historyRepository.findAllByEmail(email);
        List<HistoryResponseDTO> histories=entitiesToDtos(historyEntities);
        return histories;
    }

    private List<HistoryResponseDTO> entitiesToDtos(List<HistoryEntity> entities) {
        List<HistoryResponseDTO> dtoEntities = new ArrayList<>();
        for (HistoryEntity en : entities) {
            HistoryResponseDTO dt = new HistoryResponseDTO();
            mapper.map(en, dt);
             dt.setActionDate(en.getTimestamp().toString());
            dtoEntities.add(dt);
        }


        return dtoEntities;
    }
}
