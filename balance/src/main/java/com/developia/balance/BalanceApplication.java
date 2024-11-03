package com.developia.balance;

import com.developia.balance.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BalanceApplication {


	public static void main(String[] args) {
		SecurityConfig securityConfig=new SecurityConfig();
		SpringApplication.run(BalanceApplication.class, args);

	}

}
