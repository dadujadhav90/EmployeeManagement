package com.emp.service;

import java.util.List;

import com.emp.entity.Designation;
import com.emp.entity.Employee;

public interface DesignationService {
	List<Designation> getAllDesignations();
	void saveDesignation(Designation des);
	Designation getDesignationById(long id);
	void deleteDesignationById(long id);
}
