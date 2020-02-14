package com.spiralforge.udaan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiralforge.udaan.repository.SchemeRepository;

@Service
public class SchemeServiceImpl implements SchemeService {
	@Autowired
	SchemeRepository schemeRepository;
}
