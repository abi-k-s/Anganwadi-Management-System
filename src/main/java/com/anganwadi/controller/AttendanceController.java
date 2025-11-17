package com.anganwadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anganwadi.model.Attendance;
import com.anganwadi.service.AttendanceService;
import com.anganwadi.service.ChildrenService;

@Controller
@RequestMapping("/attendance") // Both Teacher and Assistant can access
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@Autowired
	private ChildrenService childrenService;

	@GetMapping
	public String listAll(Model model) {
		model.addAttribute("attendances", attendanceService.getAll());
		return "attendance/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("attendance", new Attendance());
		model.addAttribute("children", childrenService.getAllChildren());
		return "attendance/add";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("attendance") Attendance attendance) {

		boolean isEdit = (attendance.getId() != null);

		if (!isEdit && attendanceService.attendanceExists(attendance.getChild().getId(), attendance.getDate())) {
			return "redirect:/attendance?duplicate=true";
		}

		attendanceService.save(attendance);
		return "redirect:/attendance";
	}

	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable Long id, Model model) {
		model.addAttribute("attendance", attendanceService.getById(id));
		model.addAttribute("children", childrenService.getAllChildren());
		return "attendance/edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		attendanceService.delete(id);
		return "redirect:/attendance";
	}
}