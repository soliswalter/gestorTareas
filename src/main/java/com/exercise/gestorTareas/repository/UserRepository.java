package com.exercise.gestorTareas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.gestorTareas.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByUsername(String username);
	public List<User> findByPassword(String password);
	public List<User> findByDeleted(Boolean deleted);

}
