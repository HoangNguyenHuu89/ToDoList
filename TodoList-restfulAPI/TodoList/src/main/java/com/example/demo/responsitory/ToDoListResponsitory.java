package com.example.demo.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ToDoList;

public interface ToDoListResponsitory extends JpaRepository<ToDoList, Long> {
	List<ToDoList> findByNameContaining(String name);
}
