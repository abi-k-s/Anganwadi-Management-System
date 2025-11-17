package com.anganwadi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anganwadi.model.Distribution;
import com.anganwadi.model.Item;
import com.anganwadi.service.DistributionService;
import com.anganwadi.service.ItemService;
import com.anganwadi.service.PregnantWomanService;

@Controller
@RequestMapping("/teacher/distribution")
public class DistributionController {

	@Autowired
	private DistributionService distributionService;

	@Autowired
	private PregnantWomanService womanService;

	@Autowired
	private ItemService itemService;

	@GetMapping
	public String listAll(Model model) {
		model.addAttribute("distributions", distributionService.getAll());
		return "distribution/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");
		model.addAttribute("months", months);

		// Years
		List<String> years = Arrays.asList("2025", "2026", "2027", "2028", "2029");
		model.addAttribute("years", years);
		model.addAttribute("distribution", new Distribution());
		model.addAttribute("women", womanService.getAll());
		model.addAttribute("items", itemService.getAll());
		return "distribution/add";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Distribution distribution) {
		boolean isEdit = distribution.getId()!=null;
		
		Long itemId = distribution.getItem().getId();
		Item item = itemService.getById(itemId);
		
		boolean alreadyExists = distributionService.isItemAlreadyDistributed(distribution.getWoman().getId(),
				distribution.getMonth(), item.getItemName(),distribution.getYear());
	
		if (!isEdit && alreadyExists) {
			return "redirect:/teacher/distribution?duplicate=true";
		}
		distributionService.save(distribution);
		return "redirect:/teacher/distribution";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");
		model.addAttribute("months", months);

		// Years
		List<String> years = Arrays.asList("2025", "2026", "2027", "2028", "2029");
		model.addAttribute("years", years);
		model.addAttribute("distribution", distributionService.getById(id));
		model.addAttribute("women", womanService.getAll());
		model.addAttribute("items", itemService.getAll());
		return "distribution/edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		distributionService.delete(id);
		return "redirect:/teacher/distribution";
	}
}
