package com.anganwadi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anganwadi.model.Staff;
import com.anganwadi.model.Users;
import com.anganwadi.repository.StaffRepository;
import com.anganwadi.repository.UserRepository;

@Service
public class StaffServiceImpl implements StaffService {

    

	@Autowired
    private StaffRepository staffRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getById(Long id) {
       // return staffRepo.findById(id).orElse(null);
        Optional<Staff> optional= staffRepository.findById(id);
        Staff staff=null;
    	if(optional.isPresent()) {
    		staff=optional.get();
    	}else {
    		throw new RuntimeException("Staff not found for id : "+id);
    	}
        return staff;
        
    }

    @Override
    public void save(Staff staff) {
    	
        // Handle new user creation or update
        Users user = staff.getUser();
        

        
        if (user.getId() == 0) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(staff.getRole());//changed
        } else if (user.getPassword() != null && !user.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(staff.getRole());
        } else {
            user.setPassword(userRepository.findById(user.getId()).get().getPassword()); // keep old password
            user.setRole(staff.getRole());
        }

        staff.setUser(user);
        user.setStaff(staff);

        userRepository.save(user);
        staffRepository.save(staff);
    }

    @Override
    public void deleteById(Long id) {
		/*
		 * Staff staff = staffRepository.findById(id).orElse(null); if (staff != null) {
		 * staffRepository.delete(staff);
		 * userRepository.deleteById(staff.getUser().getId()); }//can be avoided if used cascade
		 */
    	 staffRepository.deleteById(id);
    }

	@Override
	public boolean usernameExists(String username) {
		
		return userRepository.existsByUsername(username);
	}
}