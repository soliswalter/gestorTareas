package com.exercise.gestorTareas.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.gestorTareas.entity.Folder;
import com.exercise.gestorTareas.entity.Task;
import com.exercise.gestorTareas.repository.FolderRepository;
import com.exercise.gestorTareas.utils.DTO.FolderDTO;
import com.exercise.gestorTareas.utils.DTO.TaskDTO;

@Service
public class FolderServiceImpl implements FolderService {

	@Autowired
	private FolderRepository folderRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TaskService taskService;
	
	private List<FolderDTO> generarListaDTO(List<Folder> folders){
		List<FolderDTO> foldersDTO = new ArrayList<FolderDTO>();
		for(int i = 0; i < folders.size(); i++) {
			foldersDTO.add(modelMapper.map(folders.get(i), FolderDTO.class));
		}
		return foldersDTO;
	}
	
	@Override
	public List<FolderDTO> listAllFolders() {
		List<Folder> folders = folderRepository.findByDeleted(false);
		return this.generarListaDTO(folders);
	}
	
	@Override
	public FolderDTO getFolder(Long id) {
		Folder folder = folderRepository.findById(id).orElse(null);
		if(folder == null) {
			return null;
		}
		FolderDTO folderDTO = modelMapper.map(folder, FolderDTO.class);
		return folderDTO;
	}

	@Override
	public FolderDTO createFolder(FolderDTO folderDTO) {
		if(folderDTO.getName() == null) {
			return null;
		}
		folderDTO.setDeleted(false);
		Folder folder = folderRepository.save(modelMapper.map(folderDTO, Folder.class));
		folderDTO = modelMapper.map(folder,FolderDTO.class);
		return folderDTO;
	}

	@Override
	public FolderDTO deleteFolder(Long id) {
		FolderDTO folderDB = this.getFolder(id);
		if(folderDB == null) {
			return null;
		}
		folderDB.setDeleted(true);
		Folder folder = folderRepository.save(modelMapper.map(folderDB, Folder.class));
		FolderDTO folderDTO = modelMapper.map(folder, FolderDTO.class);
		return folderDTO;
	}

	@Override
	public List<TaskDTO> getTasks(Long id) {
		Folder folder = folderRepository.findById(id).orElse(null);
		List<TaskDTO> tasksDTO = taskService.generarListaDTO(folder.getTasks());
		return tasksDTO;
	}
	
	
}
