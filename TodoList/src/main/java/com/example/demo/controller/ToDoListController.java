package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.ToDoList;
import com.example.demo.service.ToDoListService;

@Controller
public class ToDoListController {
    @Autowired
	private ToDoListService todolistService;
   
    @GetMapping("/todolist")
	public String index(Model model) {
		model.addAttribute("todolists", todolistService.findAll());
		return "list";
	}

	@GetMapping("/todolist/create")
	public String create(Model model) {
		model.addAttribute("todolist", new ToDoList());
		return "form";
	}

	@GetMapping("/todolist/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("todolist", todolistService.findOne(id));
		return "form";
	}

	@PostMapping("/todolist/save")
	public String save(@Validated ToDoList todolist, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		todolistService.save(todolist);
		redirect.addFlashAttribute("success", "Saved employee successfully!");
		return "redirect:/todolist";
	}

	@GetMapping("/todolist/{id}/delete")
	public String delete(@PathVariable long id, RedirectAttributes redirect) {
		ToDoList emp = todolistService.findOne(id);
		todolistService.delete(emp);
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		return "redirect:/todolist";
	}
	
   
}
