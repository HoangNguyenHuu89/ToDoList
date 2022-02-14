package com.example.demo.service;

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
		// TODO Auto-generated method stub
		return todolistResponsitory.findAll();
	}

	@Override
	public ToDoList findOne(long id) {
		// TODO Auto-generated method stub
		return todolistResponsitory.findById(id).get();
	}

	@Override
	public void save(ToDoList tdl) {
		todolistResponsitory.save(tdl);
		
	}

	@Override
	public void delete(ToDoList tdl) {
		todolistResponsitory.delete(tdl);
		
	}





	
	

}
