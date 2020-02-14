package com.spiralforge.udaan.service;

import com.spiralforge.udaan.config.exception.SchemeNotFoundException;
import com.spiralforge.udaan.dto.SchemeDetailsResponseDto;

public interface SchemeService {

	SchemeDetailsResponseDto getSchemeDetails(Long schemeId) throws SchemeNotFoundException;

}
