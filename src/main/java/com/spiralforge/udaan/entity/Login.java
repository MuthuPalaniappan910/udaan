package com.spiralforge.udaan.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.spiralforge.udaan.config.util.UdaanEnum.Role;

import lombok.Data;

@Entity
@Data
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginId;
	private String name;
	private Long mobileNumber;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
}
