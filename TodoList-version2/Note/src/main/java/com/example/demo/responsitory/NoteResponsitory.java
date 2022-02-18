package com.example.demo.responsitory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Note;

public interface NoteResponsitory extends JpaRepository<Note, Long> {
   List<Note> findByNameContaining(String keyword);
   
}
