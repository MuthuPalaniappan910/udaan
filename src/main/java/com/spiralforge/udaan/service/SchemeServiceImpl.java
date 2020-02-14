package com.spiralforge.udaan.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiralforge.udaan.config.exception.SchemeNotFoundException;
import com.spiralforge.udaan.constants.ApiConstant;
import com.spiralforge.udaan.dto.SchemeDetailsResponseDto;
import com.spiralforge.udaan.entity.Scheme;
import com.spiralforge.udaan.repository.SchemeRepository;
import com.spiralforge.udaan.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SchemeServiceImpl implements SchemeService {
	@Autowired
	SchemeRepository schemeRepository;

	@Override
	public SchemeDetailsResponseDto getSchemeDetails(Long schemeId) throws SchemeNotFoundException {
		SchemeDetailsResponseDto schemeDetailsResponseDto = new SchemeDetailsResponseDto();
		Optional<Scheme> scheme = schemeRepository.findById(schemeId);
		if (!(scheme.isPresent())) {
			log.error(ApiConstant.SCHEME_NOTFOUND_MESSAGE);
			throw new SchemeNotFoundException(ApiConstant.SCHEME_NOTFOUND_MESSAGE);
		}
		Float taxBenefit = scheme.get().getTaxBenefit();
		Double taxBenefitAmount= Utility.calculateCharges(scheme.get().getSchemeAmount(),taxBenefit);
		schemeDetailsResponseDto.setTaxBenefitAmount(taxBenefitAmount);
		BeanUtils.copyProperties(scheme.get(), schemeDetailsResponseDto);
		return schemeDetailsResponseDto;
	}
}
