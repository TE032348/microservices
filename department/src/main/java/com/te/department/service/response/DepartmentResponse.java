package com.te.department.service.response;

import java.util.List;

import com.te.department.service.entity.Department;

import lombok.Data;

@Data
public class DepartmentResponse {
	private boolean error;
	private String message;
	private List<Department> data;
}
