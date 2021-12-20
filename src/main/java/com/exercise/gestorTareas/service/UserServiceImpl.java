package com.exercise.gestorTareas.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.gestorTareas.entity.Task;
import com.exercise.gestorTareas.entity.User;
import com.exercise.gestorTareas.repository.UserRepository;
import com.exercise.gestorTareas.utils.DTO.TaskDTO;
import com.exercise.gestorTareas.utils.DTO.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	
	public List<UserDTO> generarListaDTO(List<User> users){
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(int i = 0; i < users.size(); i++) {
			usersDTO.add(modelMapper.map(users.get(i), UserDTO.class));
		}
		return usersDTO;
	}
	
	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findByDeleted(false);
		List<UserDTO> usersDTO = this.generarListaDTO(users);
		return usersDTO;
	}
	
	@Override
	public UserDTO getUser(Long id) {
		User user = userRepository.findById(id).orElse(null);
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		if(userDTO == null || userDTO.getUsername() == null || userDTO.getPassword() == null) {
			return null;
		}
		userDTO.setDeleted(false);
		User userSaved = userRepository.save(modelMapper.map(userDTO, User.class));
		UserDTO userResponse = modelMapper.map(userSaved, UserDTO.class);
		return userResponse;
	}

	@Override
	public UserDTO deleteUser(Long id) {
		UserDTO userDB = this.getUser(id);
		if (userDB == null) {
			return null;
		}
		userDB.setDeleted(true);
		User userSaved = this.userRepository.save(modelMapper.map(userDB, User.class));
		UserDTO userResponse = modelMapper.map(userSaved, UserDTO.class);
		return userResponse;
	}

	@Override
	public UserDTO updateUser(UserDTO user) {
		if(user.getUsername() == null || user.getId() == null) {
			return null;
		}
		UserDTO userDB = this.getUser(user.getId());
		if (userDB == null) {
			return null;
		}
		if(user.getUsername() != null) {
			userDB.setUsername(user.getUsername());
		}
		if(user.getPassword() != null) {
			userDB.setPassword(user.getPassword());
		}
		User userSaved = this.userRepository.save(modelMapper.map(userDB, User.class));
		UserDTO userResponse = modelMapper.map(userSaved, UserDTO.class);
		return userResponse;
	}

	
}
