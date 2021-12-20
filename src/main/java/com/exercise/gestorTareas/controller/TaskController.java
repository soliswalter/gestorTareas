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
import com.exercise.gestorTareas.utils.DTO.TaskDTO;

@CrossOrigin
@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="tasks")
	public ResponseEntity<List<TaskDTO>> listAllTasks() {
		List<TaskDTO> tasks = taskService.listAllTasks();
		if (tasks.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(tasks);
	}
	
	@RequestMapping(value = "task/{id}", method = RequestMethod.GET)
	public ResponseEntity<TaskDTO> getTask(@PathVariable("id") Long id){
		TaskDTO taskDTO = taskService.getTask(id);
		if(taskDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(taskDTO);
	}
	
	@RequestMapping(value = "task/folder/{id}", method = RequestMethod.POST)
	public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskDTO taskDTO, @PathVariable("id") Long idFolder){
		TaskDTO taskCreated = taskService.createTask(taskDTO, idFolder);
		if(taskCreated == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
	}

	@RequestMapping(value = "task/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TaskDTO> deleteTask(@PathVariable("id") Long id){
		TaskDTO taskDeleted = this.taskService.deleteTask(id);
		if (taskDeleted == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(taskDeleted);
	}
	
	@RequestMapping(value = "task/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
		taskDTO.setId(id);
		TaskDTO taskDB = this.taskService.updateTask(taskDTO);
		if (taskDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(taskDB);
	}
	
	
	
	
	
}
