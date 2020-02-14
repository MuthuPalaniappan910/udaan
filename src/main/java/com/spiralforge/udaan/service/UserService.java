package com.spiralforge.udaan.service;

import java.util.Optional;

import com.spiralforge.udaan.entity.User;

public interface UserService {
	
	Optional<User> getUser(Long userId);

}
