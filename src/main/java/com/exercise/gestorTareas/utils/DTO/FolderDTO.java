package com.exercise.gestorTareas.utils.DTO;

import java.util.ArrayList;
import java.util.List;

import com.exercise.gestorTareas.entity.Task;

public class FolderDTO {
	
	private Long id;
	
	private String name;
	
	private Boolean deleted;
	
	private List<Task> tasks = new ArrayList();
	
	public FolderDTO() {
		
	}
	
	public FolderDTO(String name) {
		super();
		this.name = name;
	}
	
	
	public FolderDTO(String name, Boolean deleted) {
		super();
		this.name = name;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Folder [id=" + id + ", name=" + name + ", deleted=" + deleted + "]";
	}


}
