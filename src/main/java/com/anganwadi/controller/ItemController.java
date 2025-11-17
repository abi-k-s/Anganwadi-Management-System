package com.anganwadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anganwadi.model.Item;
import com.anganwadi.service.ItemService;

@Controller
@RequestMapping("/teacher/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("items", itemService.getAll());
        return "stock/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("item", new Item());
        return "stock/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("item") Item item) {
        itemService.save(item);
        return "redirect:/teacher/items";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.getById(id));
        return "stock/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        itemService.delete(id);
        return "redirect:/teacher/items";
    }
}

