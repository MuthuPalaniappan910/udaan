package com.spiralforge.udaan.config.exception;

public class SchemeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * The exception is used to fetch a doctor if the doctor is
	 * not found in the database it will throw exception.
	 * 
	 * @param message if doctor not found the message will be thrown.
	 */
	public SchemeNotFoundException(String message) {
		super(message);
	}

}
