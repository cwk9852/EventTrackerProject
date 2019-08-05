package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Outbreak;
import com.skilldistillery.eventtracker.repositories.OutbreakRepository;

@Service
public class OutbreakServiceImpl implements OutbreakService {

	@Autowired
	private OutbreakRepository repo;

	@Override
	public List<Outbreak> index() {
		return repo.findAll();
	}

	@Override
	public Outbreak getOutbreakById(Integer id) {
		Optional<Outbreak> outbreakOpt = repo.findById(id);
		if (outbreakOpt.isPresent()) {
			Outbreak outbreak = outbreakOpt.get();
			return outbreak;
		}
		return null;
	}
	
	@Override
	public Outbreak create(Outbreak outbreak) {
		outbreak = repo.saveAndFlush(outbreak);
		return outbreak;
	}

	@Override
	public Boolean delete(Integer id) {
		Optional<Outbreak> outbreakOpt = repo.findById(id);
		Outbreak managedOutbreak = null;
		if (outbreakOpt.isPresent()) {
			managedOutbreak = outbreakOpt.get();
			repo.delete(managedOutbreak);
			return true;
		}
		return false;
	}

	@Override
	public Outbreak update(Integer id, Outbreak outbreak) {
		Optional<Outbreak> optOutbreak = repo.findById(id);
		Outbreak managed = null;
		if (optOutbreak.isPresent()) {
			managed = optOutbreak.get();
			managed.setCases(outbreak.getCases());
			managed.setDate(outbreak.getDate());
			managed.setDeaths(outbreak.getDeaths());
			managed.setDisease(outbreak.getDisease());
			managed.setLocation(outbreak.getLocation());
			managed.setSignificance(outbreak.getSignificance());
			managed.setSpecies(outbreak.getSpecies());
			managed.setSummary(outbreak.getSummary());
			repo.saveAndFlush(managed);
		}
		return managed;
	}
}
