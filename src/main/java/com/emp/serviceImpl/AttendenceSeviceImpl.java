package com.emp.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Attendence;
import com.emp.repository.AttendenceRepository;
import com.emp.service.AttendenceSevice;
@Service
public class AttendenceSeviceImpl implements AttendenceSevice{
	@Autowired
	private AttendenceRepository attendenceRepository;
	
	@Override
	public List<Attendence> getAllAttendences() {
		return this.attendenceRepository.findAll();
	}

	@Override
	public void saveAttendence(Attendence attendence) {
		this.attendenceRepository.save(attendence);
	}

	@Override
	public Attendence getAttendenceById(long id) {
		Optional<Attendence> optional=this.attendenceRepository.findById(id);
		Attendence attendence=null;
		if(optional.isPresent()) {
			attendence=optional.get();
		}
		else {
			throw new RuntimeException("Attendence not found for id :"+id);
		}
		return attendence;
	}

	@Override
	public void deleteAttendenceById(long id) {
		this.attendenceRepository.deleteById(id);
	}
	
	public List<Attendence> getAttendanceByEmployee(Long employeeId) {
        return attendenceRepository.findByEmployeeId(employeeId);
    }
	
	public List<Attendence> getAttendanceByDateRange(LocalDate startDate, LocalDate endDate) {
        return attendenceRepository.findByDateBetween(startDate, endDate);
    }

}
