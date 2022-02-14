package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ToDoList;

public interface ToDoListService {
	Iterable<ToDoList> findAll();

	List<ToDoList> search(String name);

	ToDoList findOne(long id);

	void save(ToDoList tdl);

	void delete(long id);
}
