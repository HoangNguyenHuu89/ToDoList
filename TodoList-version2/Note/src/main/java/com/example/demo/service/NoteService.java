package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Note;
import com.example.demo.model.User;

public interface NoteService {
	Iterable<Note> findAll();

	List<Note> search(String name);

	Note findOne(long id);
	
	void save(Note n);

	void delete(long id);
	
	
}
