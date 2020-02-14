package com.spiralforge.udaan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiralforge.udaan.entity.User;
import com.spiralforge.udaan.repository.SchemeRepository;
import com.spiralforge.udaan.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SchemeRepository schemeRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> getUser(Long userId) {
		return userRepository.findById(userId);
	}
}
