package com.te.department.service.service;


import com.te.department.service.entity.Department;

public interface DepartmentService {
	public Department addDepartment(Department department);
	
	public Department getDepartmentById(Long departmentId);
}
