package com.developia.balance.dto.request;

import lombok.Data;

@Data
public class UserUpdateRequestDTO {
	private String email;

	private String fullName;
	private String surname;
	private String phone;
	private Double balance;
	private String password;
	private String userType;

}
