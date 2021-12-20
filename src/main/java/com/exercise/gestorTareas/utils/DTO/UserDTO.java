package com.exercise.gestorTareas.utils.DTO;

public class UserDTO {
	
	private Long id;
	private String username;
	private String password;
	private Boolean deleted;
	
	public UserDTO() {
		super();
	}
	
	
	public UserDTO(String username, String password, Boolean deleted) {
		super();
		this.username = username;
		this.password = password;
		this.deleted = deleted;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
