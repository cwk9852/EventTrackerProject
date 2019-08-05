package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Outbreak;

public interface OutbreakService {

	List<Outbreak> index();

	Outbreak getOutbreakById(Integer id);

	Outbreak create(Outbreak outbreak);

	Boolean delete(Integer id);

	Outbreak update(Integer id, Outbreak outbreak);

}
