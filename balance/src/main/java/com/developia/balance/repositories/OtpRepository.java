package com.developia.balance.repositories;

import com.developia.balance.entity.OtpEntity;
import com.developia.balance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<OtpEntity, Long> {
    Optional<OtpEntity> findByUserAndOtp(UserEntity user, String otp);
    void deleteByUser(UserEntity user);
}
