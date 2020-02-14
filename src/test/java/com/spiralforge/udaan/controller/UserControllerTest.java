package com.spiralforge.udaan.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.spiralforge.udaan.dto.PaymentRequestDto;
import com.spiralforge.udaan.dto.PaymentResponseDto;
import com.spiralforge.udaan.exception.SchemeNotFoundException;
import com.spiralforge.udaan.service.UserService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
	PaymentRequestDto paymentRequestDto = new PaymentRequestDto();

	@Test
	public void testCharitablePayment() throws SchemeNotFoundException {
		Mockito.when(userService.charitablePayment(paymentRequestDto)).thenReturn(paymentResponseDto);
		ResponseEntity<PaymentResponseDto> result = userController.charitablePayment(paymentRequestDto);
		assertEquals(200, result.getStatusCodeValue());
	}
}
