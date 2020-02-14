package com.spiralforge.udaan.service;

import javax.validation.Valid;

import com.spiralforge.udaan.dto.PaymentRequestDto;
import com.spiralforge.udaan.dto.PaymentResponseDto;
import com.spiralforge.udaan.exception.SchemeNotFoundException;

/**
 * @author Sri Keerthna.
 * @since 2020-02-14.
 */
public interface UserService {

	PaymentResponseDto charitablePayment(@Valid PaymentRequestDto paymentRequestDto) throws SchemeNotFoundException;

}
