package com.emp.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Salary;
import com.emp.service.SalaryService;
import com.emp.entity.*;
import com.emp.repository.*;
@Service
public class SalaryServiceImpl implements SalaryService{
	@Autowired
	private  SalaryRepository salaryRepository;
	
	@Autowired
    private AttendenceRepository attendanceRepository;

	
	@Override
	public List<Salary> getAllSalarys() {
		return this.salaryRepository.findAll();
	}

	@Override
	public void saveSalary(Salary salary) {
		this.salaryRepository.save(salary);
	}

	@Override
	public Salary getSalaryById(long id) {
		Optional<Salary> optional=this.salaryRepository.findById(id);
		Salary salary=null;
		if(optional.isPresent()) {
			salary=optional.get();
		}
		else {
			throw new RuntimeException("AtteSalaryndence not found for id :"+id);
		}
		return salary;
	}

	@Override
	public void deleteSalaryeById(long id) {
		this.salaryRepository.deleteById(id);
		
	}
	
	public List<Salary> getSalariesByPosition(Long positionId) {
        return salaryRepository.findByPositionId(positionId);
    }
	
	public Salary calculateSalary(Long employeeId, LocalDate calculationDate) {
        // Fetch employee's salary details
        Salary salary = salaryRepository.findByEmployeeId(employeeId);

        if (salary != null) {
            // Fetch attendance records for the employee for the specified month
            LocalDate startDate = calculationDate.withDayOfMonth(1);
            LocalDate endDate = calculationDate.withDayOfMonth(calculationDate.lengthOfMonth());

            List<Attendence> attendances = attendanceRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);

            // Calculate the number of days worked for basic salary calculation (assuming daily wage)
            int totalDaysWorked = attendances.size(); // Counting total attendance records

            // Perform salary components calculation
            BigDecimal basicSalary = salary.getBasicSalary();
            BigDecimal hra = salary.getHra();
            BigDecimal da = salary.getDa();
            BigDecimal otherAllowances = salary.getOtherAllowances();

            // Sample calculation logic: Assuming basic salary + HRA + DA + Other Allowances
            BigDecimal grossSalary = basicSalary
                    .add(hra)
                    .add(da)
                    .add(otherAllowances);

            // Update the salary object with calculated values
            salary.setGrossSalary(grossSalary);

            // Optionally, save the updated salary record back to the database
            return salaryRepository.save(salary);
        }
        return null; // Handle scenario where salary details are not found for the employee
    }

}
