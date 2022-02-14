package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ToDoList;
import com.example.demo.responsitory.ToDoListResponsitory;

@Service
public class ToDoListServiceImpl implements ToDoListService {

	@Autowired
	private ToDoListResponsitory todolistResponsitory;

	@Override
	public Iterable<ToDoList> findAll() {
		return todolistResponsitory.findAll();
	}

	@Override
	public ToDoList findOne(long id) {
		return todolistResponsitory.findById(id).get();
	}

	@Override
	public void save(ToDoList tdl) {
		todolistResponsitory.save(tdl);

	}

	@Override
	public void delete(long id) {
		todolistResponsitory.deleteById(id);

	}

	@Override
	public List<ToDoList> search(String name) {
		return todolistResponsitory.findByNameContaining(name);
	}
}
