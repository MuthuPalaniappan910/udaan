package com.spiralforge.udaan.service;

import java.util.Optional;

import javax.validation.Valid;

import com.spiralforge.udaan.dto.PaymentRequestDto;
import com.spiralforge.udaan.dto.PaymentResponseDto;
import com.spiralforge.udaan.entity.User;
import com.spiralforge.udaan.exception.SchemeNotFoundException;

/**
 * @author Sri Keerthna.
 * @author Sujal
 * @since 2020-02-14.
 */
public interface UserService {

	Optional<User> getUser(Long userId);
	
	PaymentResponseDto charitablePayment(@Valid PaymentRequestDto paymentRequestDto) throws SchemeNotFoundException;

}
