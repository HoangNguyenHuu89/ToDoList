package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.ToDoList;
import com.example.demo.service.ToDoListService;

    @RestController
    public class ToDoListController {
	    @Autowired
	    private ToDoListService todolistService;

	    @GetMapping("/todolists")
	    public List<ToDoList> list() {
		     return (List<ToDoList>) todolistService.findAll();
	    }

	    @GetMapping("/todolists/{id}")
	    public ToDoList get(@PathVariable Long id) {
		    return todolistService.findOne(id);
	    }
	    
	   
	    @PutMapping("/todolists/update/{id}")
	    public void update(@PathVariable Long id, @RequestBody ToDoList t) {
		    ToDoList t1 = todolistService.findOne(id);
		    t1.setName(t.getName());
		    t1.setDate(t.getDate());
		    t1.setContent(t.getContent());
		    todolistService.save(t1);
	    }

	    @PostMapping("/todolists/save")
	    public void add(@RequestBody ToDoList t) {
	       todolistService.save(t);
	    }

	    @DeleteMapping("/todolists/delete/{id}")
	    public void delete(@PathVariable Long id) {
		    todolistService.delete(id);  
	    }


    }
