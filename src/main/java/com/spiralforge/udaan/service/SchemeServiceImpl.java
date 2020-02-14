package com.spiralforge.udaan.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiralforge.udaan.constants.ApplicationConstants;
import com.spiralforge.udaan.controller.SchemeController;
import com.spiralforge.udaan.dto.SchemeResponseDto;
import com.spiralforge.udaan.entity.Scheme;
import com.spiralforge.udaan.exception.SchemeNotFoundException;
import com.spiralforge.udaan.repository.SchemeRepository;

@Service
public class SchemeServiceImpl implements SchemeService {
	
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(SchemeController.class);
	
	@Autowired
	SchemeRepository schemeRepository;

	/**
	 * @author Sri Keerthna.
	 * @since 2020-02-14. In this method scheme list is fetched from database.
	 * @return list of scheme list.
	 * @throws SchemeNotFoundException if there is no scheme.
	 */
	@Override
	public List<SchemeResponseDto> getSchemeList() throws SchemeNotFoundException {
		List<Scheme> schemeList = schemeRepository.findBySchemeStatus(ApplicationConstants.ACTIVE_STATUS);
		if(schemeList.isEmpty()) {
			logger.error("No schemes available");
			throw new SchemeNotFoundException(ApplicationConstants.SCHEME_NOT_FOUND_EXCEPTION);
		}
		List<SchemeResponseDto> responseList=new ArrayList<>();
		schemeList.forEach(scheme->{
			SchemeResponseDto schemeResponse = new SchemeResponseDto();
			BeanUtils.copyProperties(scheme, schemeResponse);
			responseList.add(schemeResponse);
		});
		logger.info("Got the list of scheme");
		return responseList;
	}
}
