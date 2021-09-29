package com.te.user.service.wrapper;

import com.te.user.service.entity.User;
import com.te.user.service.value_object.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDepartmentWrapper {
	private User user;
	private Department department;
}
