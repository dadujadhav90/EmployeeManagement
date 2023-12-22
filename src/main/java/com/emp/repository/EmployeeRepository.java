package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	Employee findByName(String name);
	
	List<Employee> findByDepartmentId(long id);
	
	List<Employee> findByDesignationId(long id);
}
