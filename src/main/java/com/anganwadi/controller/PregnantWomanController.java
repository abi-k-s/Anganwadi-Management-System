package com.anganwadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anganwadi.model.PregnantWomen;
import com.anganwadi.service.PregnantWomanService;

@Controller
@RequestMapping("/teacher/pregnant")
public class PregnantWomanController {

    @Autowired
    private PregnantWomanService womanService;

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("woman", womanService.getAll());
        return "pregnant/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("woman", new PregnantWomen());
        return "pregnant/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("woman") PregnantWomen woman) {
        womanService.save(woman);
        return "redirect:/teacher/pregnant";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("woman", womanService.getById(id));
        return "pregnant/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        womanService.delete(id);
        return "redirect:/teacher/pregnant";
    }
}
