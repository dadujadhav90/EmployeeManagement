package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Designation;

public interface DesignationRepository extends JpaRepository<Designation,Long>{
	Designation findByName(String id);
	
	List<Designation> findByDepartmentId(long id);
}
