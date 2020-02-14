package com.spiralforge.udaan.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spiralforge.udaan.config.exception.ValidationFailedException;

/**
 * 
 * @author Sujal
 * 
 *         The order validator is used to validate the order information
 *
 */
@Component("orderValidator")
public class OrderValidatorImpl implements OrderValidator<Long> {

	Logger logger = LoggerFactory.getLogger(OrderValidatorImpl.class);

	/**
	 * @author Sujal
	 * 
	 *         This method is used to validate the order information
	 * @param userId
	 * @param orderRequestDto
	 * @return Boolean
	 * @throws UserNotFoundException
	 * @throws InvalidPaymentException
	 * 
	 */
	@Override
	public Boolean validate(Long t) throws ValidationFailedException {
		return null;
	}
}
