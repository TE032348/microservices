package com.te.user.service.value_object;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResposne {
	private boolean error;
	private String message;
	private List<Department> data;
}
