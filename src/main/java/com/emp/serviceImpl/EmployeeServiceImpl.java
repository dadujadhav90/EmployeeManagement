package com.emp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.repository.EmployeeRepository;
import com.emp.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository empRepo;
	
	public List<Employee> getAllEmployees(){
		List<Employee> list=this.empRepo.findAll();
		return list;
	}
	
	public Employee saveEmployee(Employee emp) {
		Employee emp1=this.empRepo.save(emp);
		return emp1;
	}
	
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional=this.empRepo.findById(id);
		Employee emp=null;
		if(optional.isPresent()) {
			emp=optional.get();
		}
		else {
			throw new RuntimeException("Employee not found for id :"+id);
		}
		return emp;
	}
	
	  public Employee getEmployeeByName(String name) {
	        return empRepo.findByName(name);
	    }

	  public List<Employee> getEmployeesByDepartment(Long departmentId) {
	        return empRepo.findByDepartmentId(departmentId);
	    }

	    public List<Employee> getEmployeesByPosition(Long did) {
	        return empRepo.findByDesignationId(did);
	    }


	@Override
		public boolean deleteEmployee(Long id) {
	        Optional<Employee> employeeOptional = empRepo.findById(id);

	        if (employeeOptional.isPresent()) {
	        	empRepo.deleteById(id);
	            return true;
	        } else {
	            // Employee with the specified id not found
	            return false;
	        }
	    		
	}

	@Override
	   public Employee updateEmployee(long id,Employee emp) {
        Optional<Employee> existingEmployeeOptional = empRepo.findById(id);

        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            
            // Update fields of the existing employee with the new values
            existingEmployee.setName(emp.getName());
            existingEmployee.setDepartment(emp.getDepartment());
            existingEmployee.setDesignation(emp.getDesignation());

            // Save the updated employee
            return empRepo.save(existingEmployee);
        } else {
            // Employee with the specified id not found
            return null;
        }
    }
}
