package com.developia.balance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authority_list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AuthorityListEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String authority;

	private Integer type_user;
	private Integer admin;

}
