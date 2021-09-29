package com.te.user.service.service;

import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;

import com.te.user.service.entity.User;
import com.te.user.service.wrapper.UserDepartmentWrapper;

public interface UserService {
	public User addUser(User user);
	
	public UserDepartmentWrapper getUser(Long userId) throws RestClientException, URISyntaxException;

	UserDepartmentWrapper getUserr(Long id) throws RestClientException, URISyntaxException;
}
