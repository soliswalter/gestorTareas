package com.exercise.gestorTareas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String status;
	private boolean deleted;
	
	
	public Task() {
	}
	
	
	public Task(Long id, String name, String status, boolean deleted) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.deleted = deleted;
	}


	public Task(String name, String status, boolean deleted) {
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
	
	
	
	

}
