package com.spiralforge.udaan.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spiralforge.udaan.dto.LoginRequestDto;
import com.spiralforge.udaan.dto.LoginResponseDto;
import com.spiralforge.udaan.exception.AdminNotFoundException;
import com.spiralforge.udaan.service.AdminService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AdminControllerTest {
	LoginRequestDto loginRequestDto = null;
	LoginResponseDto loginResponseDto = null;

	@Mock
	AdminService adminService;

	@InjectMocks
	AdminController adminController;

	@Before
	public void before() {
		loginRequestDto = new LoginRequestDto();
		loginRequestDto.setMobileNumber(9876543210L);
		loginRequestDto.setPassword("hello123");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setAdminId(1L);
		loginResponseDto.setAdminName("Muthu");
	}

	@Test
	public void testCheckLoginPositive() throws AdminNotFoundException {
		Mockito.when(adminService.checkLogin(loginRequestDto)).thenReturn(loginResponseDto);
		ResponseEntity<LoginResponseDto> response = adminController.checkLogin(loginRequestDto);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
