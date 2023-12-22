package com.emp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Department;
import com.emp.entity.Designation;
import com.emp.repository.DesignationRepository;
import com.emp.service.DesignationService;
@Service
public class DesignationServiceImpl implements DesignationService{
	@Autowired
	private DesignationRepository designationRepository;
	
	@Override
	public List<Designation> getAllDesignations() {
		List<Designation> designations=this.designationRepository.findAll();
		return designations;
	}

	@Override
	public void saveDesignation(Designation des) {
		this.designationRepository.save(des);
	}

	@Override
	public Designation getDesignationById(long id) {
		Optional<Designation> optional=this.designationRepository.findById(id);
		Designation des=null;
		if(optional.isPresent()) {
			des=optional.get();
		}
		else {
			throw new RuntimeException("Designation not found for id :"+id);
		}
		return des;
	}
	
	public Designation getDepartmentByName(String name) {
        return designationRepository.findByName(name);
    }
	
	public List<Designation> getPositionsByDepartment(Long departmentId) {
	     return designationRepository.findByDepartmentId(departmentId);
	}

	@Override
	public void deleteDesignationById(long id) {
		this.designationRepository.deleteById(id);
		
	}

}
