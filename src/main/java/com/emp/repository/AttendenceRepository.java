package com.emp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Attendence;

public interface AttendenceRepository extends JpaRepository<Attendence,Long>{
	List<Attendence> findByEmployeeId(long id);
	
	List<Attendence> findByDateBetween(LocalDate startDate, LocalDate endDate);
	
	List<Attendence> findByEmployeeIdAndDateBetween(long employeeId, LocalDate startDate,LocalDate endDate);
}
