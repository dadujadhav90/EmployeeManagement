package com.emp.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.emp.entity.Employee;
import com.emp.entity.SalaryCalculation;
import com.emp.repository.SalaryCalculationRepository;
import com.emp.service.EmployeeService;
import com.emp.service.SalaryCalculationService;

public class SalaryCalculationServiceImpl implements SalaryCalculationService{
	 @Autowired
	    private SalaryCalculationRepository salaryCalculationRepository;
	    
	    @Autowired
	    private EmployeeService employeeService; // Assuming you have an EmployeeService to perform salary calculations

	    public void performMonthlySalaryCalculation() {
	        LocalDate currentDate = LocalDate.now();
	        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);

	        // Check if salary calculation for the current month is already completed
	        boolean isSalaryCalculated = salaryCalculationRepository.existsByCalculationDate(firstDayOfMonth);
	        
	        if (!isSalaryCalculated) {
	            // If not calculated, mark as "Pending" and initiate the calculation
	            SalaryCalculation salaryCalculation = new SalaryCalculation();
	            salaryCalculation.setCalculationDate(firstDayOfMonth);
	            salaryCalculation.setStatus("Pending");
	            salaryCalculationRepository.save(salaryCalculation);

	            // Get all employees for salary calculation
	            List<Employee> employees = employeeService.getAllEmployees();

	            // Perform salary calculation for each employee
	            for (Employee employee : employees) {
	                // Calculate salary for each employee using your SalaryService logic
	                // Salary calculatedSalary = salaryService.calculateSalary(employee.getId(), firstDayOfMonth);
	                // You may update the salary record in the Salary table
	                // salaryService.updateSalary(calculatedSalary.getId(), calculatedSalary);
	                // Update SalaryCalculation status for the current month to "Completed"
	            }

	            // Update SalaryCalculation status for the current month to "Completed"
	            salaryCalculation.setStatus("Completed");
	            salaryCalculationRepository.save(salaryCalculation);
	        }
	    }

	    public void updateSalaryCalculationStatus(Long id, String status) {
	        // Fetch the SalaryCalculation record by ID
	        SalaryCalculation salaryCalculation = salaryCalculationRepository.findById(id).orElse(null);

	        if (salaryCalculation != null) {
	            salaryCalculation.setStatus(status);
	            salaryCalculationRepository.save(salaryCalculation);
	        }
	    }
	
}
