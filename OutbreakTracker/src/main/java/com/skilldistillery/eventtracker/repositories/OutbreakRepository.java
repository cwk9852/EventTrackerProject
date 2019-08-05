package com.skilldistillery.eventtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Outbreak;

public interface OutbreakRepository extends JpaRepository<Outbreak, Integer> {

	List<Outbreak> findAll();

}
