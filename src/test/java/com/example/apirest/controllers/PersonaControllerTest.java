package com.example.apirest.controllers;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.apirest.controllers.PersonaController;
import com.example.apirest.entities.Persona;
import com.example.apirest.services.PersonaServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
@WebMvcTest(PersonaController.class)
class PersonaControllerTest {

	@MockBean
	private PersonaServiceImpl personaService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testSearchString() throws Exception {
		Persona persona = new Persona();
		persona.setNombre("Pablo");
		persona.setApellido("Peña");
		
		List<Persona> listaEnviada = new ArrayList();
		listaEnviada.add(persona);
		
		when(personaService.search("Pablo")).thenReturn(listaEnviada);
		
		mockMvc.perform(get("/api/v1/personas/search")
				.param("filtro", "Pablo")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].nombre", is("Pablo")))
				.andExpect(jsonPath("$[0].apellido", is("Peña")));
		
		
		
	}
}