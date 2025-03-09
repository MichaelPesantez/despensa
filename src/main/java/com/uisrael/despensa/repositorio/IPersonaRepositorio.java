package com.uisrael.despensa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.despensa.modelo.Persona;

public interface IPersonaRepositorio extends JpaRepository<Persona, Integer> {
	
	@Query("Select count(nombrePersona) from Persona where nombrePersona =:nombre")
	public int contarPorNombreExcepto(@Param("nombre")String nombre);
	
	@Query("Select p from Persona p where direccionPersona = ?1")
	public List<Persona>buscarPorCiudad(String ciudad);
	
	@Query("Select p from Persona p order by nombrePersona desc limit 1")
	public Persona primeraPersonaPorNombre();
	
	public List<Persona>findByEstadoPersona(boolean estadoPersona);
	
	public Persona findByIdPersona(int idPersona);

}
