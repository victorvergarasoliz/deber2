package com.ug.encuesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ug.encuesta.dominio.Grupo;
import com.ug.encuesta.repository.GrupoRepository;

@RestController
public class GrupoController {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	
	@RequestMapping (value="/grupos", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Grupo grupo)
	{
		grupoRepository.save(grupo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

	@RequestMapping (value="/grupos", method=RequestMethod.GET)
	public ResponseEntity<?> findAll (@RequestParam(defaultValue="true") boolean control) {
			Iterable<Grupo> grupos;
			
			if (control)
				grupos = grupoRepository.findAll();
				else
					grupos = grupoRepository.getGrupo();
			
			
			
			return new ResponseEntity<>(grupos,HttpStatus.OK);
	}
	

	
	@RequestMapping (value="/grupos/{grupo_id}", method=RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable int grupo_id) {
			
		Grupo  grupos= grupoRepository.findOne(grupo_id);
			
			return new ResponseEntity<>(grupos,HttpStatus.OK);
			
	}

	@RequestMapping (value="/grupos/{literal}", method=RequestMethod.GET)
	public ResponseEntity<?> findByLiteral(@PathVariable String literal) {
			
		Iterable<Grupo>  grupos= grupoRepository.findByLiteral(literal);
			
			return new ResponseEntity<>(grupos,HttpStatus.OK);
			
	}
	
}



