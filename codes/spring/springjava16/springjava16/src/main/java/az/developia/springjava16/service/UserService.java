package az.developia.springjava16.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import az.developia.springjava16.entity.UserEntity;
import az.developia.springjava16.repository.UserRepository;
import az.developia.springjava16.request.UserAddRequestDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository repo;

	public void add(UserAddRequestDTO req) {
		String parol = req.getPassword();

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String bcrParol = "{bcrypt}" + encoder.encode(parol);

		UserEntity u = new UserEntity(req.getUsername(), bcrParol, 1);
		repo.save(u);
		repo.addUserAuthorities(req.getUsername());

	}

}
