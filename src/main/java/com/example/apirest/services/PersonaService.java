package com.example.apirest.services;

import java.util.List;

import com.example.apirest.entities.Persona;

public interface PersonaService extends BaseService<Persona, Long>{

	public List<Persona> search (String filtro) throws Exception;
}
