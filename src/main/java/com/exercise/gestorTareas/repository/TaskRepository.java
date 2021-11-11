package com.exercise.gestorTareas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.gestorTareas.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	public List<Task> findByName(String name);
	public List<Task> findByDeleted(boolean deleted);
	public List<Task> findByStatus(String status);
	
}
