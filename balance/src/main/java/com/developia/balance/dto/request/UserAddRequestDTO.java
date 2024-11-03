package com.developia.balance.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAddRequestDTO {
	private String fullName;
	private String surname;
	private String email;
	private String phone;
	private String password;



}
