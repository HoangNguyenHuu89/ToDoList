package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import com.example.demo.model.Note;
import com.example.demo.responsitory.NoteResponsitory;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteResponsitory res;
	
	@Override
	public Iterable<Note> findAll() {
		return res.findAll();
	}

	@Override
	public List<Note> search(String name) {
		return res.findByNameContaining(name);
	}

	@Override
	public Note findOne(long id) {
		return res.findById(id).get();
	}

	@Override
	public void save(Note n) {
	    res.save(n);
		
	}

	@Override
	public void delete(long id) {
		res.deleteById(id);;
	}

	

	

	

}
