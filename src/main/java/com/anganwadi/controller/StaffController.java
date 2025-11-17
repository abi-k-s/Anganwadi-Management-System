package com.anganwadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anganwadi.model.Staff;
import com.anganwadi.model.Users;
import com.anganwadi.service.StaffService;

@Controller
@RequestMapping("/teacher/staff")
public class StaffController {

	@Autowired
	private StaffService staffService;

	@GetMapping
	public String listStaff(Model model) {
		model.addAttribute("staff", staffService.getAll());
		return "staff/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		Staff staff = new Staff();
		staff.setUser(new Users()); // initialize empty user
		model.addAttribute("staff", staff);
		return "staff/add";
	}

	@PostMapping("/save")
	public String saveStaff(@ModelAttribute("staff") Staff staff, Model model) {

		boolean isEdit = (staff.getId() != null);

		if (!isEdit && staffService.usernameExists(staff.getUser().getUsername())) {
			
			model.addAttribute("staff", staff); // Repopulate form with user input
			model.addAttribute("duplicate", true); // set flag for alert
			return "staff/add";
		}

		staffService.save(staff);
		// System.out.println("Saving staff with role: " + staff.getRole()); // DEBUG
		return "redirect:/teacher/staff";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Staff staff = staffService.getById(id);
		if (staff != null) {
			model.addAttribute("staff", staff);
			return "staff/edit";
		} else {
			return "redirect:/teacher/staff";
		}
	}

	// Delete staff
	@GetMapping("/delete/{id}")
	public String deleteStaff(@PathVariable Long id) {
		staffService.deleteById(id);
		return "redirect:/teacher/staff";
	}
}
