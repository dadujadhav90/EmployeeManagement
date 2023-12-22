package com.emp.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.SalaryCalculation;

public interface SalaryCalculationRepository extends JpaRepository<SalaryCalculation,Long>{
	boolean existsByCalculationDate(LocalDate firstDayOfMonth);
}
