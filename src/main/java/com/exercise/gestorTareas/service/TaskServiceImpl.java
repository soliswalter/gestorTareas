package com.exercise.gestorTareas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.gestorTareas.entity.Task;
import com.exercise.gestorTareas.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public List<Task> listAllTasks() {
		//return taskRepository.findAll();
		return taskRepository.findByDeleted(false);
	}

	@Override
	public Task getTask(Long id) {
		return taskRepository.findById(id).orElse(null);
	}

	@Override
	public Task createTask(Task task) {
		task.setDeleted(false);
		task.setStatus("Undone");
		return this.taskRepository.save(task);
	}

	@Override
	public List<Task> findByStatus(String status) {
		return this.taskRepository.findByStatus(status);
	}

	@Override
	public List<Task> findByDeleted(boolean deleted) {
		return this.taskRepository.findByDeleted(deleted);
	}

	@Override
	public Task deleteTask(Long id) {
		Task taskDB = this.getTask(id);
		if (taskDB == null) {
			return null;
		}
		taskDB.setDeleted(true);
		return this.taskRepository.save(taskDB);
	}

	@Override
	public Task updateTask(Task task) {
		Task taskDB = this.getTask(task.getId());
		if (taskDB == null) {
			return null;
		}
		if(task.getName() != null) {
			taskDB.setName(task.getName());
		}
		if(task.getStatus() != null) {
			taskDB.setStatus(task.getStatus());
		}
		return this.taskRepository.save(taskDB);
	}
	
	
	
	
	
	

}
