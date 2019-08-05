package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Outbreak;
import com.skilldistillery.eventtracker.services.OutbreakService;

@RestController
@RequestMapping("api")
public class OutbreakController {

	@Autowired
	private OutbreakService svc;
	
	@GetMapping(path = "ping")
	public String getPong() {
		return "pong";
	}

	@GetMapping(path = "outbreaks")
	public List<Outbreak> getOutbreaks() {
		return svc.index();
	}
	
	@GetMapping(path = "outbreaks/{id}")
	public Outbreak getOutbreakById(@PathVariable Integer id, HttpServletResponse resp) {
		
		Outbreak outbreak = svc.getOutbreakById(id);
		
		if (outbreak == null) {
			resp.setStatus(404);
			return null; 
		}
		
		return outbreak;
	}
	
	@DeleteMapping("outbreaks/{id}")
	public Boolean deleteOutbreak(@PathVariable Integer id, HttpServletRequest req, HttpServletResponse resp) {
		try {
			svc.delete(id);
			return true;
		} catch (Exception e) {
			resp.setStatus(409);
			return false;
		}
	}
	
	@PostMapping("outbreaks")
	public Outbreak createOutbreak(@RequestBody Outbreak outbreak, HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(outbreak);
		try {
			svc.create(outbreak);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/");
			url.append(outbreak.getId());
			String newAddrURL = url.toString();
			resp.addHeader("Location", newAddrURL);
		} catch (Exception e) {
			resp.setStatus(400);
			outbreak = null;
		}
		return outbreak;
	}
	
	@PutMapping("outbreaks/{id}")
	public Outbreak replaceOutbreak(@PathVariable Integer id, @RequestBody Outbreak outbreak, HttpServletRequest req, HttpServletResponse resp) {
		try {
			outbreak = svc.update(id, outbreak);
			resp.setStatus(200);
			StringBuffer url = req.getRequestURL();
			String newAddrURL = url.toString();
			resp.addHeader("URL", newAddrURL);
		} catch (Exception e) {
			resp.setStatus(400);
			outbreak = null;
		}
		return outbreak;
	}
	
}
