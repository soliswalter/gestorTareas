package com.exercise.gestorTareas.utils.DTO;

import com.exercise.gestorTareas.entity.Folder;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TaskDTO {
	
	private Long id;
	private String name;
	private String status;
	private boolean deleted;
	private Folder folder;
	
	public TaskDTO() {
	}
	
	
	
	public TaskDTO(Long id, String name, String status, boolean deleted, Folder folder) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.deleted = deleted;
		this.folder = folder;
	}



	public TaskDTO(Long id, String name, String status, boolean deleted) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.deleted = deleted;
	}


	public TaskDTO(String name, String status, boolean deleted) {
		super();
		this.name = name;
		this.status = status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean deleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	@JsonIgnore
	public Folder getFolder() {
		return folder;
	}



	public void setFolder(Folder folder) {
		this.folder = folder;
	}



	public boolean isDeleted() {
		return deleted;
	}
	
	

}
