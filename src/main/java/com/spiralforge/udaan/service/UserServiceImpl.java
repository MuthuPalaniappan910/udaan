package com.spiralforge.udaan.service;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiralforge.udaan.constants.ApiConstant;
import com.spiralforge.udaan.constants.ApplicationConstants;
import com.spiralforge.udaan.dto.PaymentRequestDto;
import com.spiralforge.udaan.dto.PaymentResponseDto;
import com.spiralforge.udaan.entity.Scheme;
import com.spiralforge.udaan.entity.User;
import com.spiralforge.udaan.exception.SchemeNotFoundException;
import com.spiralforge.udaan.repository.SchemeRepository;
import com.spiralforge.udaan.repository.UserRepository;
import com.spiralforge.udaan.util.Utility;

/**
 * @author Sri Keerthna.
 * @author Sujal
 * @since 2020-02-14.
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private SchemeRepository schemeRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> getUser(Long userId) {
		return userRepository.findById(userId);
	}

	/**
	 * @author Sri Keerthna.
	 * @since 2020-02-14. In this method user will give their details to make a
	 *        payment.
	 * @param paymentRequestDto has username,pan number,emailId and mobile number.
	 * @return success message is sent to user.
	 * @throws SchemeNotFoundException if no scheme found.
	 */
	@Override
	public PaymentResponseDto charitablePayment(@Valid PaymentRequestDto paymentRequestDto)
			throws SchemeNotFoundException {
		Optional<Scheme> scheme = schemeRepository.findById(paymentRequestDto.getSchemeId());
		if (!scheme.isPresent()) {
			logger.error("No scheme found");
			throw new SchemeNotFoundException(ApplicationConstants.SCHEME_NOT_FOUND_EXCEPTION);
		}
		User user = new User();
		PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
		BeanUtils.copyProperties(paymentRequestDto, user);
		user.setUserStatus(ApplicationConstants.ACTIVE_STATUS);
		userRepository.save(user);
		BeanUtils.copyProperties(paymentRequestDto, paymentResponseDto);
		BeanUtils.copyProperties(scheme.get(), paymentResponseDto);
		paymentResponseDto.setUserId(user.getUserId());
		Double taxBenefitAmount=Utility.calculateCharges(scheme.get().getSchemeAmount(), scheme.get().getTaxBenefit());
		paymentResponseDto.setTaxBenefit(taxBenefitAmount);
		paymentResponseDto.setMessage(ApiConstant.PAYMENT_SUCCESS);
		paymentResponseDto.setStatusCode(ApiConstant.SUCCESS_CODE);
		logger.info("Payment Success");
		return paymentResponseDto;
	}
}
