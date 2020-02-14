package com.spiralforge.udaan.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
	@Email(message = "Email should be valid")
	private String emailId;
	private Long mobileNumber;
	@Size(min = 10, max = 10)
	private String panNumber;
	
}
