package com.emp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Department;
import com.emp.entity.Employee;
import com.emp.repository.DepartmentRepository;
import com.emp.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments=this.departmentRepository.findAll();
		return departments;
	}

	@Override
	public Department saveDepartment(Department dept) {
		Department d=this.departmentRepository.save(dept);
		return d;
	}

	@Override
	public Department getDepartmentById(long id) {
		Optional<Department> optional=this.departmentRepository.findById(id);
		Department dept=null;
		if(optional.isPresent()) {
			dept=optional.get();
		}
		else {
			throw new RuntimeException("Department not found for id :"+id);
		}
		return dept;
	}
	
	public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

	@Override
	public void deleteDepartmentById(long id) {
		this.departmentRepository.deleteById(id);
		
	}

}
