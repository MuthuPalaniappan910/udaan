package com.spiralforge.udaan.service;

import java.util.List;

import com.spiralforge.udaan.dto.SchemeResponseDto;
import com.spiralforge.udaan.exception.SchemeNotFoundException;

public interface SchemeService {

	List<SchemeResponseDto> getSchemeList() throws SchemeNotFoundException;

}
