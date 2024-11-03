package com.developia.balance.dto.response;

import lombok.Data;

@Data
public class LoginResponseDTO {

	private String email;

	private String name;
	private String surname;
	private String phone;
	private Double balance;

	private String profession;

}
