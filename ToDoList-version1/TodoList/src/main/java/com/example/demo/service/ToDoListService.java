package com.example.demo.service;

import com.example.demo.model.ToDoList;

public interface ToDoListService {
	Iterable<ToDoList> findAll();
	
    ToDoList findOne(long id);

    void save(ToDoList tdl);

    void delete(ToDoList tdl);
}
