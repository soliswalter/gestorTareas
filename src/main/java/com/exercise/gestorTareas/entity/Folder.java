package com.exercise.gestorTareas.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Folder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Boolean deleted;
	
	@OneToMany(mappedBy = "folder")
	@JsonIgnore
	private List<Task> tasks = new ArrayList();
	
	public Folder() {
		
	}
	
	public Folder(String name) {
		super();
		this.name = name;
	}
	
	
	public Folder(String name, Boolean deleted) {
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
