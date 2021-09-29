package com.te.user.service.response;

import java.util.List;

import com.te.user.service.entity.User;
import com.te.user.service.wrapper.UserDepartmentWrapper;

import lombok.Data;

@Data 
public class UserResponse {
	private boolean error;
	private String message;
	private UserDepartmentWrapper detalis;
	private List<User> data;
}
