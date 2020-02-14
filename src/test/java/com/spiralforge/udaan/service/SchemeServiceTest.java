package com.spiralforge.udaan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.spiralforge.udaan.constants.ApplicationConstants;
import com.spiralforge.udaan.controller.SchemeController;
import com.spiralforge.udaan.controller.UserController;
import com.spiralforge.udaan.dto.SchemeResponseDto;
import com.spiralforge.udaan.entity.Scheme;
import com.spiralforge.udaan.exception.SchemeNotFoundException;
import com.spiralforge.udaan.repository.SchemeRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SchemeServiceTest {

	@InjectMocks
	SchemeServiceImpl schemeService;

	@Mock
	SchemeRepository schemeRepository;

	List<SchemeResponseDto> resultList=new ArrayList<>();
	List<Scheme> schemeList=new ArrayList<>();
	Scheme scheme= new Scheme();
	SchemeResponseDto schemeResponse = new SchemeResponseDto();
	
	@Before
	public void setUp() {
		scheme.setSchemeId(1L);
		scheme.setSchemeStatus(ApplicationConstants.ACTIVE_STATUS);
		schemeList.add(scheme);
		BeanUtils.copyProperties(scheme, schemeResponse);
		resultList.add(schemeResponse);
	}
	
	@Test
	public void testGetSchemeList() throws SchemeNotFoundException {
		Mockito.when(schemeRepository.findBySchemeStatus(ApplicationConstants.ACTIVE_STATUS)).thenReturn(schemeList);
		List<SchemeResponseDto> result=schemeService.getSchemeList();
		assertEquals(1, result.size());
	}
	
	@Test(expected = SchemeNotFoundException.class)
	public void testGetSchemeListNegative() throws SchemeNotFoundException {
		Mockito.when(schemeRepository.findBySchemeStatus("INACTIVE")).thenReturn(schemeList);
		schemeService.getSchemeList();
	}
}
