package com.exercise.gestorTareas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.gestorTareas.entity.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long>{
	
	List<Folder> findByName(String name);
	List<Folder> findByDeleted(boolean deleted);
}
