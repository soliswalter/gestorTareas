package com.exercise.gestorTareas.service;

import java.util.List;

import com.exercise.gestorTareas.entity.Task;
import com.exercise.gestorTareas.utils.DTO.TaskDTO;

public interface TaskService {
	
	public List<TaskDTO> listAllTasks();
	public TaskDTO getTask(Long id);
	public TaskDTO createTask(TaskDTO taskDTO, Long idFolder);
	public List<TaskDTO> findByStatus(String status);
	public List<TaskDTO> findByDeleted(boolean deleted);
	public TaskDTO deleteTask(Long id);
	public TaskDTO updateTask(TaskDTO taskDTO);
	public List<TaskDTO> generarListaDTO(List<Task> tasks);
	
	

}
