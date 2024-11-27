package com.developia.balance.services;

import com.developia.balance.dto.GeneralResponse;
import com.developia.balance.dto.request.UserAddRequestDTO;
import com.developia.balance.dto.request.UserUpdateRequestDTO;
import com.developia.balance.dto.response.LoginResponseDTO;
import com.developia.balance.dto.response.UsersListResponseDTO;
import com.developia.balance.entity.OtpEntity;
import com.developia.balance.entity.UserEntity;
import com.developia.balance.exceptionHandler.OurException;
import com.developia.balance.repositories.OtpRepository;
import com.developia.balance.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository repo;
	private final ModelMapper mapper;
	private final OtpRepository otpRepository;
	private final EmailService emailService;
	private final PasswordEncoder passwordEncoder;


	public void addUser(UserAddRequestDTO req) {
		Optional<UserEntity> ue= repo.findByEmail(req.getEmail());

		if(ue.isPresent()){
			throw new OurException("user with this email exists", null,"");
		}
		String parol = req.getPassword();

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String bcrParol = "{bcrypt}" + encoder.encode(parol);

		UserEntity u = new UserEntity(req.getEmail(),req.getFullName(),req.getPhone(),bcrParol,"user", 1,(double)0);

		repo.save(u);
		repo.addUserAuthorities(req.getEmail());

	}
	public LoginResponseDTO findByUsername(String username){

		UserEntity ue= repo.findByEmail(username).orElseThrow(() -> new OurException("user tapilmadi", null,""));
		LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
		mapper.map(ue, loginResponseDTO);
		return loginResponseDTO;
	};
	public void updateUser(UserUpdateRequestDTO userUpdateRequestDTO, String profession){

		Optional<UserEntity> userEntity=repo.findByEmail(userUpdateRequestDTO.getEmail());
		if(userEntity.isPresent()){
			if(profession.equals(userEntity.get().getUserType())){
				mapper.map(userUpdateRequestDTO,userEntity);
				repo.save(userEntity.get());
			}else {
				throw new OurException("Email does not belong to user",null,null);
			}

		}else {
			throw new OurException("not found",null,null);
		}
	}

	public List<UsersListResponseDTO> getUsers() {
		List<UserEntity> students=repo.findStudents("user");
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
			if(ue.get().getUserType().equals("user")){
				repo.deleteByEmail(email);

			}else {
				throw new OurException("Email not belongs to user",null,null);
			}

		}else {
			throw new OurException("Email not found",null,null);
		}
	}

	public String initiatePasswordReset(String email) {
		Optional<UserEntity> userOptional = repo.findByEmail(email);

		if (userOptional.isPresent()) {
			UserEntity user = userOptional.get();

			// Generate OTP
			String otp = String.format("%06d", new Random().nextInt(1000000));

			// Save OTP in a separate Otp entity
			OtpEntity otpEntity = new OtpEntity();
			otpEntity.setUser(user);
			otpEntity.setOtp(otp);
			otpEntity.setExpiry(LocalDateTime.now().plusMinutes(10));  // OTP valid for 10 minutes
			otpRepository.save(otpEntity);

			// Send OTP via email
			emailService.sendHtmlEmail(user.getEmail(), "OTP code: ", otp);
		}

		return "If an account with this email exists, a reset link has been sent.";
	}
@Transactional
	public String verifyOtp(String email, String otp) {
		Optional<UserEntity> userOptional = repo.findByEmail(email);

		if (!userOptional.isPresent()) {
			return "User not found";
		}

		UserEntity user = userOptional.get();
		Optional<OtpEntity> otpOptional = otpRepository.findByUserAndOtp(user, otp);

		if (otpOptional.isPresent() && otpOptional.get().getExpiry().isAfter(LocalDateTime.now())) {
			// OTP is valid
			otpRepository.deleteByUser(user);  // Clear OTP after successful verification
			return "OTP verified. You can now reset your password.";
		} else {
			throw new OurException("Invalid or expired OTP") ;
		}
	}

	public String resetPassword(String email, String newPassword) {
		Optional<UserEntity> userOptional = repo.findByEmail(email);

		if (!userOptional.isPresent()) {
			throw new OurException("User not found");
		}

		UserEntity user = userOptional.get();

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String bcrParol = "{bcrypt}" + encoder.encode(newPassword);
		user.setPassword(bcrParol);
		repo.save(user);

		return "Password has been reset successfully.";
	}

    public String getBalance() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserEntity user = repo.findByEmail(username).orElseThrow(()->new OurException("User not found",null,""));
		return user.getBalance().toString();
	}
}

