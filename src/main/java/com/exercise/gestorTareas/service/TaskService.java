package com.exercise.gestorTareas.service;

import java.util.List;

import com.exercise.gestorTareas.entity.Task;

public interface TaskService {
	
	public List<Task> listAllTasks();
	public Task getTask(Long id);
	public Task createTask(Task task);
	public List<Task> findByStatus(String status);
	public List<Task> findByDeleted(boolean deleted);
	public Task deleteTask(Long id);
	public Task updateTask(Task task);
	
	

}
