package com.emp.service;

import java.util.List;

import com.emp.entity.Salary;

public interface SalaryService {
	List<Salary> getAllSalarys();
	void saveSalary(Salary salary);
	Salary getSalaryById(long id);
	void deleteSalaryeById(long id);
}
