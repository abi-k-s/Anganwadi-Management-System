package com.anganwadi.service;

import java.time.LocalDate;
import java.util.List;

import com.anganwadi.model.Attendance;

public interface AttendanceService {
	List<Attendance> getAll();
    Attendance getById(Long id);
    void save(Attendance attendance);
    void delete(Long id);
    boolean attendanceExists(Long childId, LocalDate date) ;
}