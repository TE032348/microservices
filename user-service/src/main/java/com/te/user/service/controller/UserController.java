package com.te.user.service.controller;

import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.te.user.service.entity.User;
import com.te.user.service.response.UserResponse;
import com.te.user.service.service.UserService;
import com.te.user.service.wrapper.UserDepartmentWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired 
	private UserService userService;
	
	@PostMapping("/add-user")
	public ResponseEntity<UserResponse> saveUser(@RequestBody User userDetails){
		log.info("save user method");
		User user = userService.addUser(userDetails);
		UserResponse response = new UserResponse();
		if(user!=null) {
			response.setError(false);
			response.setMessage("User added successfully");
			response.setData(Arrays.asList(user));
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			response.setError(true);
			response.setMessage("User not added");
			response.setData(Arrays.asList(user));
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
	
	@GetMapping("/get-user/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) throws RestClientException, URISyntaxException{
		log.info("get user method");
		UserDepartmentWrapper wrapper = userService.getUserr(id);
		UserResponse response = new UserResponse();
		if(wrapper!=null) {
			response.setError(false);
			response.setMessage("User fetched successfully");
			response.setDetalis(wrapper);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			response.setError(true);
			response.setMessage("User not fetched");
			response.setDetalis(null);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
}
