package com.spiralforge.udaan.helper;

import com.spiralforge.udaan.exception.ValidationFailedException;

public interface OrderValidator<T> {
	
	Boolean validate(T t) throws ValidationFailedException ;
}
