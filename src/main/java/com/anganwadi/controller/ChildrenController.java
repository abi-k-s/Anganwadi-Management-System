package com.anganwadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anganwadi.model.Children;
import com.anganwadi.service.ChildrenService;

@Controller
@RequestMapping("/teacher/children")  // Only teacher can access 
public class ChildrenController {

    @Autowired
    private ChildrenService childrenService;

    @GetMapping
    public String listChildren(Model model) {
        model.addAttribute("children", childrenService.getAllChildren());
        return "children/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("child", new Children());
        return "children/add";
    }

    @PostMapping("/save")
    public String saveChild(@ModelAttribute Children child) {
        childrenService.saveChild(child);
        return "redirect:/teacher/children";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("child", childrenService.getChildById(id));
        return "children/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteChild(@PathVariable Long id) {
        childrenService.deleteChild(id);
        return "redirect:/teacher/children";
    }
}

