package com.example.apirest.repositories;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.apirest.entities.Persona;
import com.example.apirest.repositories.PersonaRepository;


@DataJpaTest
class PersonaRepositoryTest {

	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Test
	void testSearchString() {
		Persona persona = new Persona();
		persona.setNombre("Pablo");
		persona.setApellido("Peña");
		
		List<Persona> listaEnviada = new ArrayList();
		listaEnviada.add(persona);
		
		entityManager.persist(persona);
		entityManager.flush();
		
		assertEquals(listaEnviada, personaRepository.searchNative("Pablo"));
		assertEquals(listaEnviada, personaRepository.searchNative("Peña"));
		
		
	}

}