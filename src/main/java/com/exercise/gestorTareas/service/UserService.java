package com.exercise.gestorTareas.service;

import java.util.List;

import com.exercise.gestorTareas.entity.Task;
import com.exercise.gestorTareas.entity.User;
import com.exercise.gestorTareas.utils.DTO.UserDTO;

public interface UserService {
	
	public List<UserDTO> getAllUsers();
	public UserDTO getUser(Long id);
	public UserDTO createUser(UserDTO userDTO);
	public UserDTO deleteUser(Long id);
	public UserDTO updateUser(UserDTO userDTO);

}
