package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Department;
import com.emp.entity.Employee;

public interface DepartmentRepository extends JpaRepository<Department,Long>{
	Department findByName(String name);
}
