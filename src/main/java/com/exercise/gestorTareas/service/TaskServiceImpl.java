package com.exercise.gestorTareas.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.gestorTareas.entity.Folder;
import com.exercise.gestorTareas.entity.Task;
import com.exercise.gestorTareas.repository.FolderRepository;
import com.exercise.gestorTareas.repository.TaskRepository;
import com.exercise.gestorTareas.utils.DTO.TaskDTO;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FolderRepository folderRepository;
	
	
	
	public List<TaskDTO> generarListaDTO(List<Task> tasks){
		List<TaskDTO> tasksDTO = new ArrayList<TaskDTO>();
		for(int i = 0; i < tasks.size(); i++) {
			tasksDTO.add(modelMapper.map(tasks.get(i), TaskDTO.class));
		}
		return tasksDTO;
	}
	
	@Override
	public List<TaskDTO> listAllTasks() {
		//return taskRepository.findAll();
		List<Task> tasks = taskRepository.findByDeleted(false);
		List<TaskDTO> tasksDTO = this.generarListaDTO(tasks);
		return tasksDTO;
	}

	@Override
	public TaskDTO getTask(Long id) {
		Task task = taskRepository.findById(id).orElse(null);
		if (task == null) {
			return null;
		}
		TaskDTO taskDTO = modelMapper.map(task, TaskDTO.class);
		return taskDTO;
	}
	
	private void updateFolder(Task taskCreated, Folder folder) {
		// buscar carpeta en la que quiero guardar
		// recuperar su lista de tareas, y agregar tarea
		List<Task> tasksOfFolder = folder.getTasks();
		if (tasksOfFolder == null) {
			folder.setTasks(new ArrayList<Task>());
		}
		tasksOfFolder.add(taskCreated);
		folder.setTasks(tasksOfFolder);
		this.folderRepository.save(folder);
	}

	@Override
	public TaskDTO createTask(TaskDTO taskDTO, Long idFolder) {
		Folder folder = this.folderRepository.getById(idFolder);
		if(taskDTO == null || taskDTO.getName()==null || folder == null) {
			return null;
		}
		taskDTO.setDeleted(false);
		taskDTO.setStatus("Undone");
		taskDTO.setFolder(folder);
		Task task = modelMapper.map(taskDTO, Task.class);
		Task taskCreated = this.taskRepository.save(task);
		TaskDTO taskCreatedDTO = modelMapper.map(taskCreated, TaskDTO.class);
		this.updateFolder(taskCreated, folder);
		return taskCreatedDTO;	
	}

	@Override
	public List<TaskDTO> findByStatus(String status) {
		List<Task> tasks = this.taskRepository.findByStatus(status);
		return this.generarListaDTO(tasks);
	}

	@Override
	public List<TaskDTO> findByDeleted(boolean deleted) {
		List<Task> tasks = this.taskRepository.findByDeleted(deleted);
		return this.generarListaDTO(tasks);
	}

	@Override
	public TaskDTO deleteTask(Long id) {
		TaskDTO taskDB = this.getTask(id);
		if (taskDB == null) {
			return null;
		}
		taskDB.setDeleted(true);
		Task task = this.taskRepository.save(modelMapper.map(taskDB,Task.class));
		TaskDTO taskDTO = modelMapper.map(task, TaskDTO.class);
		return taskDTO;
	}

	@Override
	public TaskDTO updateTask(TaskDTO task) {
		if(task.getName() == null || task.getId() == null) {
			return null;
		}
		TaskDTO taskDB = this.getTask(task.getId());//busco la tarea en la bd
		if (taskDB == null) {
			return null;
		}
		if(task.getName() != null) {
			taskDB.setName(task.getName());
		}
		if(task.getStatus() != null) {
			taskDB.setStatus(task.getStatus());
		}
		Task taskAux = this.taskRepository.save(modelMapper.map(taskDB, Task.class));
		return modelMapper.map(taskAux, TaskDTO.class);
	}
	
	
	
	
	
	

}
