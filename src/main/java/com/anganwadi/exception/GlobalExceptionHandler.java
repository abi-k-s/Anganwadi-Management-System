package com.anganwadi.exception;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.anganwadi.service.ItemService;
import com.anganwadi.service.PregnantWomanService;

@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private PregnantWomanService womanService;

	@Autowired
	private ItemService itemService;

	@ExceptionHandler(InsufficientStockException.class)
	public String handleInsufficientStockException(InsufficientStockException ex, Model model) {
		model.addAttribute("errorMessage", ex.getMessage());

		model.addAttribute("months", Arrays.asList("January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December"));

		model.addAttribute("years", Arrays.asList("2025", "2026", "2027", "2028", "2029"));

		model.addAttribute("women", womanService.getAll());
		model.addAttribute("items", itemService.getAll());

		return "distribution/add";
	}

}