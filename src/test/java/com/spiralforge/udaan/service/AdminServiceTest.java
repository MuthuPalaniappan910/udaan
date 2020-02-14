package com.spiralforge.udaan.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.spiralforge.udaan.config.exception.AdminNotFoundException;
import com.spiralforge.udaan.dto.LoginRequestDto;
import com.spiralforge.udaan.dto.LoginResponseDto;
import com.spiralforge.udaan.entity.Admin;
import com.spiralforge.udaan.repository.AdminRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AdminServiceTest {
	Admin admin = null;
	LoginRequestDto loginRequestDto = null;
	LoginResponseDto loginResponseDto = null;
	LoginRequestDto loginRequestDto1 = null;

	@Mock
	AdminRepository adminRepository;

	@InjectMocks
	AdminServiceImpl adminServiceImpl;

	@Before
	public void before() {
		admin = new Admin();
		admin.setAdminId(1L);
		admin.setMobileNumber(9876543210L);
		admin.setAdminName("Muthu");
		admin.setPassword("hello123");

		loginRequestDto = new LoginRequestDto();
		loginRequestDto.setMobileNumber(9876543210L);
		loginRequestDto.setPassword("hello123");
		
		loginRequestDto1 = new LoginRequestDto();
		loginRequestDto1.setMobileNumber(9876543210L);
		loginRequestDto1.setPassword("hello1234");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setAdminId(1L);
		loginResponseDto.setAdminName("Muthu");
	}

	@Test
	public void testCheckLoginPositive() throws AdminNotFoundException {
		Mockito.when(adminRepository.findByMobileNumberAndPassword(loginRequestDto.getMobileNumber(),
				loginRequestDto.getPassword())).thenReturn(admin);
		LoginResponseDto response = adminServiceImpl.checkLogin(loginRequestDto);
		assertEquals(admin.getAdminName(), response.getAdminName());
	}
	
	@Test(expected=AdminNotFoundException.class)
	public void testCheckLoginException() throws AdminNotFoundException{
		Mockito.when(adminRepository.findByMobileNumberAndPassword(loginRequestDto.getMobileNumber(),
				loginRequestDto.getPassword())).thenReturn(admin);
		adminServiceImpl.checkLogin(loginRequestDto1);
	}
}
