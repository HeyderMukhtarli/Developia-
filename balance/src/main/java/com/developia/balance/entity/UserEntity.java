package com.developia.balance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {

	@Id
	private String email;

	private String fullName;

	private String phone;
	private String password;
	private String userType;
	private Integer enabled;
	private Double balance;

}
