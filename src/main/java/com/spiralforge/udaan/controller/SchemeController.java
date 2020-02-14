package com.spiralforge.udaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiralforge.udaan.config.exception.SchemeNotFoundException;
import com.spiralforge.udaan.dto.SchemeDetailsResponseDto;
import com.spiralforge.udaan.service.SchemeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/schemes")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class SchemeController {
	@Autowired
	SchemeService schemeService;

	@GetMapping("/{schemeId}")
	public ResponseEntity<SchemeDetailsResponseDto> getSchemeDetails(@PathVariable(name = "schemeId") Long schemeId)
			throws SchemeNotFoundException {
		log.info("Getting details of a particular scheme by using its id");
		SchemeDetailsResponseDto schemeDetailsResponseDto = schemeService.getSchemeDetails(schemeId);
		return new ResponseEntity<>(schemeDetailsResponseDto, HttpStatus.OK);
	}
}
