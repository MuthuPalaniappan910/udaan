package com.spiralforge.udaan.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiralforge.udaan.dto.PaymentRequestDto;
import com.spiralforge.udaan.dto.PaymentResponseDto;
import com.spiralforge.udaan.exception.SchemeNotFoundException;
import com.spiralforge.udaan.service.UserService;

/**
 * @author Sri Keerthna.
 * @since 2020-02-14.
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/users")
public class UserController {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/**
	 * @author Sri Keerthna.
	 * @since 2020-02-14. In this method user will give their details to make a
	 *        payment.
	 * @param paymentRequestDto has username,pan number,emailId and mobile number.
	 * @return success message is sent to user.
	 * @throws SchemeNotFoundException if no scheme found.
	 */
	@PostMapping
	public ResponseEntity<PaymentResponseDto> charitablePayment(@Valid @RequestBody PaymentRequestDto paymentRequestDto)
			throws SchemeNotFoundException {
		logger.info("Entered into charitablePayment method in user controller");
		PaymentResponseDto paymentResponseDto = userService.charitablePayment(paymentRequestDto);
		return new ResponseEntity<>(paymentResponseDto, HttpStatus.OK);
	}
}
