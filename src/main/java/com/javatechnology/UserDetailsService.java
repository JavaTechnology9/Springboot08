package com.javatechnology;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javatechnology.dao.UserRepository;
import com.javatechnology.model.Role;
import com.javatechnology.model.User;
@Service
public class UserDetailsService /*
								 * implements org.springframework.security.core.userdetails.UserDetailsService
								 */{
	/*@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User findByUsername = userRepository.findByUsername(username);
		Set<GrantedAuthority> userAuthority = getUserAuthority(findByUsername.getRole());
		return buildUserAuthorities(findByUsername,userAuthority);
	}
	private UserDetails buildUserAuthorities(User findByUsername, Set<GrantedAuthority> userAuthority) {
		return  new org.springframework.security.core.userdetails.User(findByUsername.getUsername(),
				findByUsername.getPassword(),true,true,true,true,userAuthority);
		
		
		
	}
	private Set<GrantedAuthority> getUserAuthority(Set<Role> roles) {
		Set<GrantedAuthority> userRoles= new HashSet<>();
		for(Role role:roles) {
			userRoles.add(new SimpleGrantedAuthority(role.getRole()));
			
		}
		return userRoles;
		
	}*/

}
