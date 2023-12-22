package com.emp.service;

import java.util.List;

import com.emp.entity.Department;

public interface DepartmentService {
	List<Department> getAllDepartments();
	Department saveDepartment(Department dept);
	Department getDepartmentById(long id);
	void deleteDepartmentById(long id);
}
