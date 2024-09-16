package az.developia.springjava16.service.interfaces;

import az.developia.springjava16.dto.request.UserAddRequestDTO;
import az.developia.springjava16.dto.response.AuthoritiesResponseDTO;
import az.developia.springjava16.entity.UserEntity;
import az.developia.springjava16.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorityService {
	public List<AuthoritiesResponseDTO> getAuthorities();


}
