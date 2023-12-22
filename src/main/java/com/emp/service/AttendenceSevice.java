package com.emp.service;

import java.util.List;

import com.emp.entity.Attendence;

public interface AttendenceSevice {
	List<Attendence> getAllAttendences();
	void saveAttendence(Attendence attendence);
	Attendence getAttendenceById(long id);
	void deleteAttendenceById(long id);
}
