package com.anganwadi.service;

import java.util.List;

import com.anganwadi.model.Staff;

public interface StaffService {
	List<Staff> getAll();

	Staff getById(Long id);

	void save(Staff staff);

	void deleteById(Long id);
	
	boolean usernameExists(String username);

}
