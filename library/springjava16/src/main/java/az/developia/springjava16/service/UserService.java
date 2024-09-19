package az.developia.springjava16.service;

import az.developia.springjava16.dto.request.UserUpdateRequestDTO;
import az.developia.springjava16.dto.response.AuthoritiesListResponseDTO;
import az.developia.springjava16.dto.response.LoginResponseDTO;
import az.developia.springjava16.dto.response.UsersListResponseDTO;
import az.developia.springjava16.entity.AuthorityListEntity;
import az.developia.springjava16.exceptionHandler.OurException;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import az.developia.springjava16.entity.UserEntity;
import az.developia.springjava16.repository.UserRepository;
import az.developia.springjava16.dto.request.UserAddRequestDTO;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository repo;
	private final ModelMapper mapper;

	public void addLibrarian(UserAddRequestDTO req) {
		Optional<UserEntity> ue= repo.findByEmail(req.getEmail());

		if(ue.isPresent()){
			throw new OurException("user with this email exists", null,"");
		}
		String parol = req.getPassword();

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String bcrParol = "{bcrypt}" + encoder.encode(parol);

		UserEntity u = new UserEntity(req.getEmail(),req.getName(),req.getSurname(), req.getPhone(), req.getAddress(),bcrParol, 1,"librarian");
		repo.save(u);
		repo.addUserAuthorities(req.getEmail());

	}
	public void addStudent(UserAddRequestDTO req) {
		Optional<UserEntity> ue= repo.findByEmail(req.getEmail());

		if(ue.isPresent()){
			throw new OurException("user with this email exists", null,"");
		}
		String parol = req.getPassword();

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String bcrParol = "{bcrypt}" + encoder.encode(parol);

		UserEntity u = new UserEntity(req.getEmail(),req.getName(),req.getSurname(), req.getPhone(), req.getAddress(),bcrParol, 1,"student");
		repo.save(u);
		repo.addStudentAuthorities(req.getEmail());

	}
	public LoginResponseDTO findByUsername(String username){

		UserEntity ue= repo.findByEmail(username).orElseThrow(() -> new OurException("user tapilmadi", null,""));
		LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
		mapper.map(ue, loginResponseDTO);
		return loginResponseDTO;
	};
	public void updateUser(UserUpdateRequestDTO userUpdateRequestDTO,String profession){

		Optional<UserEntity> userEntity=repo.findByEmail(userUpdateRequestDTO.getEmail());
		if(userEntity.isPresent()){
			if(profession.equals(userEntity.get().getProfession())){
				mapper.map(userUpdateRequestDTO,userEntity);
				repo.save(userEntity.get());
			}else {
				throw new OurException("Email does not belong to student",null,null);
			}

		}else {
			throw new OurException("not found",null,null);
		}
	}

	public List<UsersListResponseDTO> getStudents() {
		List<UserEntity> students=repo.findStudents("student");
		return entitiesToDtos(students);
	}

	private List<UsersListResponseDTO> entitiesToDtos(List<UserEntity> entities) {
		List<UsersListResponseDTO> dtoEntities = new ArrayList<UsersListResponseDTO>();
		for (UserEntity en : entities) {
			UsersListResponseDTO dt = new UsersListResponseDTO();
			mapper.map(en, dt);
			dtoEntities.add(dt);
		}


		return dtoEntities;
	}

	public void deleteByEmail(String email) {
		Optional<UserEntity> ue=repo.findByEmail(email);
		if(ue.isPresent()){
			if(ue.get().getProfession().equals("student")){
				repo.deleteByEmail(email);

			}else {
				throw new OurException("Email not belongs to student",null,null);
			}

		}else {
			throw new OurException("Email not found",null,null);
		}
	}
}
