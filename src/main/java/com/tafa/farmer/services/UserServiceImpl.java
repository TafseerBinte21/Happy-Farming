package com.tafa.farmer.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tafa.farmer.models.Role;
import com.tafa.farmer.models.User;
import com.tafa.farmer.repository.UserRepository;
import com.tafa.farmer.controllers.dto.*;

@Service
public class UserServiceImpl implements UserService, ApplicationContextAware, InitializingBean {

	private UserRepository userRepository;

	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegDto registrationDto) {
		User user = new User(registrationDto.getName(),
				registrationDto.getPhone(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getAddress(),
				Arrays.asList(new Role("ROLE_USER")), registrationDto.getCroplist());

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByEmail(String email) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return user;
	}

	@Override
	public void deletecropById(User user, Long id) {
		List<Long> croplist = user.getCroplist();
		croplist.remove(id);
		user.setCroplist(croplist);

		userRepository.saveAndFlush(user);
	}
	
	@Override
	public void deletecropByIdFromMyCrops(User user, Long id) {
		List<Long> croplist = user.getMyCrops();
		croplist.remove(id);
		user.setMyCrops(croplist);

		userRepository.saveAndFlush(user);
	}

	@Override
	public void addcropByIdInMyCrops(User user, Long id) {
		List<Long> croplist = user.getMyCrops();
		System.out.println("\n" + "\n");

		if (!croplist.contains(id)) {
			croplist.add(id);
			user.setMyCrops(croplist);
			userRepository.saveAndFlush(user);
		}
	}

	
//	 @Override
//		public Boolean  findbyEmail(String Email) {
//			 return userRepository.findbyEmail(Email);
//		 }
	 
	

}
