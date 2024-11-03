package com.developia.balance.dto.response;

import lombok.Data;

@Data
public class UsersListResponseDTO {

	private String email;

	private String fullName;
	private String phone;
	private String address;
	private String password;
	private Integer enabled;
	private String userType;
}
