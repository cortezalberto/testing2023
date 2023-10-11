package com.example.apirest.services;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.entities.Persona;
import com.example.apirest.repositories.PersonaRepository;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Transactional
	@Override
	public List<Persona> search(String filtro) throws Exception{
		try{
		//return personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
		//return personaRepository.searchJPQL(filtro);
		return personaRepository.searchNative(filtro);
		}
		catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}

}
