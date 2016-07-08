package com.ug.encuesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ug.encuesta.dominio.Subgrupo;
import com.ug.encuesta.repository.SubgrupoRepository;

@RestController
public class SubgruposController {
	
	@Autowired
	private SubgrupoRepository SubgrupoRepository;
	
	@RequestMapping (value="/grupos/{grupo_id}/subgrupos", method=RequestMethod.GET)
	public Iterable<Subgrupo> getSubGrupoByGrupo(@PathVariable int grupo_id) {
		
		return SubgrupoRepository.getSubGrupoByGrupo(grupo_id);
		
	}
	
	
	@RequestMapping (value="/subgrupos", method=RequestMethod.GET)
	public Iterable<Subgrupo> findAll(){
		return SubgrupoRepository.findAll();
		
	}
	
	
	@RequestMapping (value="/subgrupos", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Subgrupo subgrupo)
	{
		SubgrupoRepository.save(subgrupo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping (value="/subgrupos/{subgrupo_id}", method=RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable int subgrupo_id) {
			
		Subgrupo  subgrupos= SubgrupoRepository.findOne(subgrupo_id);
			
			return new ResponseEntity<>(subgrupos,HttpStatus.OK);
			
	}
	

	
}
