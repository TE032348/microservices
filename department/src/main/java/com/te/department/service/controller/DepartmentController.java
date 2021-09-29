package com.te.department.service.controller;

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

import com.te.department.service.entity.Department;
import com.te.department.service.response.DepartmentResponse;
import com.te.department.service.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save-department")
	public ResponseEntity<DepartmentResponse> saveDepartment(@RequestBody Department department){
		log.info("save departmnet method");
		Department dept = departmentService.addDepartment(department);
		DepartmentResponse response = new DepartmentResponse();
		if(dept!=null) {
			response.setError(false);
			response.setMessage("Department Added successfully");
			response.setData(Arrays.asList(dept));
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			response.setError(true);
			response.setMessage("Department Not Added");
			response.setData(Arrays.asList(dept));
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
	
	@GetMapping("/get-department/{id}")
	public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable("id") Long departmentId){
		log.info("get department method");
		Department dept = departmentService.getDepartmentById(departmentId);
		DepartmentResponse response = new DepartmentResponse();
		if(dept!=null) {
			response.setError(false);
			response.setMessage("Department fetched successfully");
			response.setData(Arrays.asList(dept));
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			response.setError(true);
			response.setMessage("Department Not fetched");
			response.setData(Arrays.asList(dept));
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
}
