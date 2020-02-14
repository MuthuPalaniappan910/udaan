package com.spiralforge.udaan.constants;

/**
 * 
 * @author Sujal
 *
 */
public class ApiConstant {

	private ApiConstant() {
	}

	public static final String LOGIN_ERROR = "please enter valid username and password";
	public static final String LOGIN_SUCCESS = "you are successfully logged in";

	public static final String SUCCESS = "Operation successful";
	public static final String FAILED = "Operation faild";

	public static final String INTERNAL_SERVER_ERROR = "INTERNAL SERVER ERROR";
	public static final String VALIDATION_FAILED = "VALIDATION FAILED";
	public static final String NO_ELEMENT_FOUND = "NO ELEMENT FOUND";
	public static final String CUSTOMER_NOT_FOUND = "Not a valid customer";

	public static final Integer SUCCESS_CODE = 200;
	public static final Integer FAILURE_CODE = 404;
	public static final Integer NO_CONTENT_CODE = 204;

	public static final Float PERCENTAGE_DIVIDE_VALUE = 100.0f;
	public static final String SCHEME_NOTFOUND_MESSAGE = "There is no such scheme found";

}
