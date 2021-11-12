package com.exercise.gestorTareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.gestorTareas.entity.Task;
import com.exercise.gestorTareas.service.TaskService;

@CrossOrigin
@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="tasks")
	public ResponseEntity<List<Task>> listAllTasks() {
		List<Task> tasks = taskService.listAllTasks();
		if (tasks.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(tasks);
	}
	
	@RequestMapping(value = "task/{id}", method = RequestMethod.GET)
	public ResponseEntity<Task> getTask(@PathVariable("id") Long id){
		Task task = taskService.getTask(id);
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(task);
	}
	
	@RequestMapping(value = "task", method = RequestMethod.POST)
	public ResponseEntity<Task> saveTask(@RequestBody Task task){
		Task taskCreated = taskService.createTask(task);
		if(taskCreated == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
	}

	@RequestMapping(value = "task/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Task> deleteTask(@PathVariable("id") Long id){
		Task taskDeleted = this.taskService.deleteTask(id);
		if (taskDeleted == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(taskDeleted);
	}
	
	@RequestMapping(value = "task/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
		task.setId(id);
		Task taskDB = this.taskService.updateTask(task);
		if (taskDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(taskDB);
	}
	
	
	
	
	
}
