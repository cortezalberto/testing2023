package com.example.apirest.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.example.apirest.ApirestApplication;
import com.example.apirest.entities.Persona;
import com.example.apirest.repositories.PersonaRepository;

@SpringBootTest(classes = ApirestApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-test.properties")
class PersonaControllerIntegration {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Test
	void testSearchString() throws Exception{
		Persona persona = new Persona();
		persona.setNombre("Paul");
		persona.setApellido("McCartney");
		
		
		personaRepository.save(persona);
		
		mockMvc.perform(get("/api/v1/personas/search")
				.param("filtro", "Paul")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].nombre", is("Paul")))
				.andExpect(jsonPath("$[0].apellido", is("McCartney")));
		
		
		
	}

}
