package com.emp.service;

import java.util.List;

import com.emp.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee saveEmployee(Employee emp);
	Employee getEmployeeById(long id);
	boolean deleteEmployee(Long id);
	Employee updateEmployee(long id,Employee emp);
	
}
