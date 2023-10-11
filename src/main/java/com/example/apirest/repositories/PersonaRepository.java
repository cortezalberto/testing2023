package com.example.apirest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.apirest.entities.Persona;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long>{

	public List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
	
	@Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
	public List<Persona> searchJPQL(@Param("filtro") String filtro);
	
	@Query(
			value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
			nativeQuery = true)
	public List<Persona> searchNative(@Param("filtro") String filtro);
}
