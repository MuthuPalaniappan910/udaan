package com.spiralforge.udaan.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.spiralforge.udaan.dto.SchemeResponseDto;
import com.spiralforge.udaan.exception.SchemeNotFoundException;
import com.spiralforge.udaan.service.SchemeService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SchemeControllerTest {

	@InjectMocks
	SchemeController schemeController;

	@Mock
	SchemeService schemeService;
	
	List<SchemeResponseDto> resultList=new ArrayList<>();
	
	@Test
	public void testGetSchemeList() throws SchemeNotFoundException {
		Mockito.when(schemeService.getSchemeList()).thenReturn(resultList);
		ResponseEntity<List<SchemeResponseDto>> result = schemeController.getSchemeList();
		assertEquals(200, result.getStatusCodeValue());
	}
}
