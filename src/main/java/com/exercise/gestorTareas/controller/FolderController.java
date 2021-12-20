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

import com.exercise.gestorTareas.entity.Folder;
import com.exercise.gestorTareas.entity.Task;
import com.exercise.gestorTareas.service.FolderService;
import com.exercise.gestorTareas.utils.DTO.FolderDTO;
import com.exercise.gestorTareas.utils.DTO.TaskDTO;

@CrossOrigin
@RestController
public class FolderController {
	
	@Autowired
	private FolderService folderService;
	
	@RequestMapping(value = "folders")
	public ResponseEntity<List<FolderDTO>> getAllFolders() {
		List<FolderDTO> folders = folderService.listAllFolders();
		if(folders == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(folders);
	}
	
	@RequestMapping(value = "folder", method = RequestMethod.POST)
	public ResponseEntity<FolderDTO> createFolder(@RequestBody FolderDTO folderDTO, UriComponentsBuilder ucBuilder){
		FolderDTO folderCreated = folderService.createFolder(folderDTO);
		if(folderCreated == null) {
			return ResponseEntity.noContent().build();
		}
		URI location = ucBuilder.path("/folder/{id}").buildAndExpand(folderCreated.getId()).toUri();
		return ResponseEntity.created(location).body(folderCreated);
	}
	
	@RequestMapping(value = "folder/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<FolderDTO> deleteFolder(@PathVariable("id") Long id){
		FolderDTO folderDeleted = folderService.deleteFolder(id);
		if(folderDeleted == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(folderDeleted);
	}
	
	@RequestMapping(value = "folder/{id}/tasks")
	public ResponseEntity<List<TaskDTO>> getTasksFromFolder(@PathVariable("id") Long id) {
		List<TaskDTO> tasks = folderService.getTasks(id);
		if(tasks == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(tasks);
	}
	
	
	

}
