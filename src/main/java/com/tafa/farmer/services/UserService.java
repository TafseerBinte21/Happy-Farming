package com.tafa.farmer.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tafa.farmer.controllers.dto.UserRegDto;
import com.tafa.farmer.models.User;

public interface UserService extends UserDetailsService {
	User save(UserRegDto registrationDto);

	User getUserByEmail(String email);

	void deletecropById(User user, Long id);

	void deletecropByIdFromMyCrops(User user, Long valueOf);

	void addcropByIdInMyCrops(User user, Long valueOf);

//	void deleteGameByIdFromCart(User user, Long valueOf);
//
//	void addGameByIdInCart(User user, Long valueOf);

	

	
//	Boolean findbyEmail(String Email);

	
	
	

}