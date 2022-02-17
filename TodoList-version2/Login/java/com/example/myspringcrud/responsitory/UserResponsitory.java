package com.example.myspringcrud.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myspringcrud.model.User;

public interface UserResponsitory extends JpaRepository<User, Long> {
     User findByNameContaining(String username);
}
