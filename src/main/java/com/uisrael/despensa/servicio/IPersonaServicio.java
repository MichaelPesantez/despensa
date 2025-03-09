package com.uisrael.despensa.servicio;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.uisrael.despensa.modelo.Persona;

public interface IPersonaServicio {

	public void crearPersona(Persona nuevaPersona);
	public int contarPorNombreExcepto(@Param("nombre")String nombre);
	public List<Persona>buscarPorCiudad(String ciudad);
	public List<Persona>listarPersonas();
	public Persona primeraPersonaPorNombre();
	public Persona findByIdPersona(int idPersona);
	public List<Persona>findByEstadoPersona(boolean estadoPersona);
}
