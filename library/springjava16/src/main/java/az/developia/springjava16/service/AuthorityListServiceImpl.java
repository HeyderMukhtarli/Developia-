package az.developia.springjava16.service;

import az.developia.springjava16.dto.request.AddRoleRequestDTO;
import az.developia.springjava16.dto.response.AuthoritiesListResponseDTO;
import az.developia.springjava16.dto.response.AuthoritiesResponseDTO;
import az.developia.springjava16.entity.AuthorityEntity;
import az.developia.springjava16.entity.AuthorityListEntity;
import az.developia.springjava16.entity.UserEntity;
import az.developia.springjava16.exceptionHandler.OurException;
import az.developia.springjava16.repository.AuthorityListRepository;
import az.developia.springjava16.repository.AuthorityRepository;
import az.developia.springjava16.service.interfaces.AuthorityListService;
import az.developia.springjava16.service.interfaces.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorityListServiceImpl implements AuthorityListService {
    @Autowired
    private  final AuthorityListRepository authorityListRepository;

    @Autowired
    private  final AuthorityRepository authorityRepository;
    @Autowired
    private final ModelMapper mapper;
    @Override
    public List<AuthoritiesListResponseDTO> getAuthoritiesList() {
        List<AuthorityListEntity> authoritiesEntity=  authorityListRepository.findAll();
       return entitiesToDtos(authoritiesEntity);
    }

    @Override
    @Transactional
    public String addRole(AddRoleRequestDTO addRoleRequestDTO) {
        Optional<AuthorityListEntity> al= authorityListRepository.findByAuthority(addRoleRequestDTO.getAuthority());

        if(al.isPresent()){
            throw new OurException("This role exists", null,"");
        }
        AuthorityListEntity authorityListEntity=new AuthorityListEntity();
        mapper.map(addRoleRequestDTO,authorityListEntity);
        authorityListRepository.save(authorityListEntity);
        authorityRepository.addAuthority(addRoleRequestDTO.getAuthority());
        return "Success";
    }

    private List<AuthoritiesListResponseDTO> entitiesToDtos(List<AuthorityListEntity> entities) {
        List<AuthoritiesListResponseDTO> dtoEntities = new ArrayList<AuthoritiesListResponseDTO>();
        for (AuthorityListEntity en : entities) {
            AuthoritiesListResponseDTO dt = new  AuthoritiesListResponseDTO();
            mapper.map(en, dt);
            dtoEntities.add(dt);
        }


        return dtoEntities;
    }
}
