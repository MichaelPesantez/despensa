package com.uisrael.despensa.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.despensa.modelo.Persona;
import com.uisrael.despensa.repositorio.IPersonaRepositorio;
import com.uisrael.despensa.servicio.IPersonaServicio;

@Service
@Component
public class PersonaServicio implements IPersonaServicio {
	
	@Autowired
	private IPersonaRepositorio repo;

	@Override
	public void crearPersona(Persona nuevaPersona) {
		// TODO Auto-generated method stub
		try
		{
			repo.save(nuevaPersona);
		}
		catch(Exception e)
		{
			throw (e);
		}
		
	}

	@Override
	public List<Persona> buscarPorCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return repo.buscarPorCiudad(ciudad);
	}

	@Override
	public Persona primeraPersonaPorNombre() {
		// TODO Auto-generated method stub
		return repo.primeraPersonaPorNombre();
	}

	@Override
	public int contarPorNombreExcepto(String nombre) {
		// TODO Auto-generated method stub
		return repo.contarPorNombreExcepto(nombre);
				}

	@Override
	public List<Persona> listarPersonas() {
		return repo.findAll();
	}

	@Override
	public Persona findByIdPersona(int idPersona) {
		// TODO Auto-generated method stub
		return repo.findByIdPersona(idPersona);
	}

	@Override
	public List<Persona> findByEstadoPersona(boolean estadoPersona) {
		// TODO Auto-generated method stub
		return repo.findByEstadoPersona(estadoPersona);
	}
	
	

}
