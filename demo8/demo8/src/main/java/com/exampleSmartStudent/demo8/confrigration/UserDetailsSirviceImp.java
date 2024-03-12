package com.exampleSmartStudent.demo8.confrigration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.exampleSmartStudent.demo8.Dao.UserRepository;
import com.exampleSmartStudent.demo8.entity.User;

public class UserDetailsSirviceImp implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//fetching user form database
		User user= userRepository.findByEmail(username);
		if(user==null) throw new UsernameNotFoundException("Could not found user !!");
		CustomUserDetails coutomUserDetails = new CustomUserDetails(user);
		return coutomUserDetails;
	}
	

}
