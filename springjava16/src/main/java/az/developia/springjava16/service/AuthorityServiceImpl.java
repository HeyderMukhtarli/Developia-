package az.developia.springjava16.service;

import az.developia.springjava16.dto.response.AuthoritiesResponseDTO;
import az.developia.springjava16.dto.response.BookListResponseDTO;
import az.developia.springjava16.dto.response.BookResponseDTOEntity;
import az.developia.springjava16.entity.AuthorityEntity;
import az.developia.springjava16.entity.BookEntity;
import az.developia.springjava16.repository.AuthorityRepository;
import az.developia.springjava16.service.interfaces.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private  final AuthorityRepository authorityRepository;
    @Autowired
    private final ModelMapper mapper;
    @Override
    public List<AuthoritiesResponseDTO> getAuthorities() {
        List<AuthorityEntity> authoritiesEntity=  authorityRepository.findAll();
       return entitiesToDtos(authoritiesEntity);
    }

    private List<AuthoritiesResponseDTO> entitiesToDtos(List<AuthorityEntity> entities) {
        List<AuthoritiesResponseDTO> dtoEntities = new ArrayList<AuthoritiesResponseDTO>();
        for (AuthorityEntity en : entities) {
            AuthoritiesResponseDTO dt = new AuthoritiesResponseDTO();
            mapper.map(en, dt);
            dtoEntities.add(dt);
        }


        return dtoEntities;
    }
}
