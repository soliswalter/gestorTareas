package com.exercise.gestorTareas.service;

import java.util.List;

import com.exercise.gestorTareas.entity.Folder;
import com.exercise.gestorTareas.entity.Task;
import com.exercise.gestorTareas.utils.DTO.FolderDTO;
import com.exercise.gestorTareas.utils.DTO.TaskDTO;

public interface FolderService {
	
	public List<FolderDTO> listAllFolders();
	public FolderDTO getFolder(Long id);
	public FolderDTO createFolder(FolderDTO folder);
	public FolderDTO deleteFolder(Long id);
	public List<TaskDTO> getTasks(Long id);

}
