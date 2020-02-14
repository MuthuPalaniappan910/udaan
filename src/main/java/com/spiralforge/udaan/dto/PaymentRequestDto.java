package com.spiralforge.udaan.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sri Keerthna.
 * @since 2020-02-14.
 */
@Getter
@Setter
public class PaymentRequestDto {

	private Long schemeId;
	private String userName;
	private String emailId;
	private Long mobileNumber;
	private String panNumber;
	
}
