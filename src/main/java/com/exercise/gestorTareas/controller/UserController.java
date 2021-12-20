package com.exercise.gestorTareas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.exercise.gestorTareas.entity.Task;
import com.exercise.gestorTareas.entity.User;
import com.exercise.gestorTareas.service.UserService;
import com.exercise.gestorTareas.utils.DTO.UserDTO;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "users")
	public ResponseEntity<List<UserDTO>> getUsers(){
		List<UserDTO> users = userService.getAllUsers();
		if(users == null || users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO, UriComponentsBuilder ucBuilder){
		UserDTO userCreated = userService.createUser(userDTO);
		if(userCreated == null) {
			return ResponseEntity.noContent().build();
		}
		URI location = ucBuilder.path("/user/{id}").buildAndExpand(userCreated.getId()).toUri();
		return ResponseEntity.created(location).body(userCreated);
	}
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") Long id){
		UserDTO userDeleted = this.userService.deleteUser(id);
		if (userDeleted == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userDeleted);
	}
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
		userDTO.setId(id);
		UserDTO userDB = this.userService.updateUser(userDTO);
		if (userDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userDB);
	}
	
	
	
}
