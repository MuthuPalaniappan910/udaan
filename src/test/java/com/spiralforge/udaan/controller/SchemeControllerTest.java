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

import com.spiralforge.udaan.config.exception.SchemeNotFoundException;
import com.spiralforge.udaan.dto.SchemeDetailsResponseDto;
import com.spiralforge.udaan.service.SchemeService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SchemeControllerTest {
	SchemeDetailsResponseDto schemeDetailsResponseDto = null;

	@Mock
	SchemeService schemeService;

	@InjectMocks
	SchemeController schemeController;

	@Before
	public void before() {
		schemeDetailsResponseDto = new SchemeDetailsResponseDto();
		schemeDetailsResponseDto.setSchemeAmount(100.00);
		schemeDetailsResponseDto.setTaxBenefit(10.0f);
		schemeDetailsResponseDto.setTaxBenefitAmount(2000.00);
		schemeDetailsResponseDto.setDescription("Give some seed for your feed");
		schemeDetailsResponseDto.setSchemeName("Agri");
	}

	@Test
	public void testGetSchemeDetails() throws SchemeNotFoundException {
		Long schemeId = 1L;
		Mockito.when(schemeService.getSchemeDetails(schemeId)).thenReturn(schemeDetailsResponseDto);
		ResponseEntity<SchemeDetailsResponseDto> response = schemeController.getSchemeDetails(schemeId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
