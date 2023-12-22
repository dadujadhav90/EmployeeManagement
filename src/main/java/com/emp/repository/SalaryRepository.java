package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary,Long>{
	List<Salary> findByPositionId(long id);
	
	Salary findByEmployeeId(long id);
	
	
}
