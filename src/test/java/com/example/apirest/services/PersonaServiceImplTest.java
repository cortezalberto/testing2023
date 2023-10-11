package com.example.apirest.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.apirest.entities.Persona;
import com.example.apirest.repositories.PersonaRepository;
import com.example.apirest.services.PersonaServiceImpl;


@SpringBootTest
class PersonaServiceImplTest {

	@MockBean
	private PersonaRepository personaRepository;
	
	@Autowired
	private PersonaServiceImpl personaService;
	
	@Test
	void testSearchString() throws Exception {
		Persona persona = new Persona();
		persona.setNombre("Pablo");
		persona.setApellido("Peña");
		
		List<Persona> listaEnviada = new ArrayList<Persona>();
		listaEnviada.add(persona);
		
		when(personaRepository.searchNative("Pablo")).thenReturn(listaEnviada);
		
		
		assertEquals(listaEnviada, personaService.search("Pablo"));
		
	}


}