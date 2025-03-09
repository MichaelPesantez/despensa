package com.uisrael.despensa.servicio.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.despensa.modelo.Categoria;
import com.uisrael.despensa.repositorio.ICategoriaRepositorio;
import com.uisrael.despensa.servicio.ICategoriaServicio;

@Service
@Component
public class CategoriaServicio implements ICategoriaServicio {
	
	@Autowired
	private ICategoriaRepositorio repo;

	@Override
	public boolean crearCategoria(Categoria nuevaCategoria) {
		// TODO Auto-generated method stub
		try 
		{
			repo.save(nuevaCategoria);
			return true;
		}
		catch(Exception e)
		{
		 throw (e);
		}
	}

	@Override
	public List<Categoria> buscarPorEstadoCodigoMayor(boolean estado, int codigo) {
		// TODO Auto-generated method stub
		return repo.buscarPorEstadoCodigoMayor(estado, codigo);
	}

	@Override
	public List<Categoria> buscarPorNombreLike(String nombreCategoria) {
		// TODO Auto-generated method stub
		return repo.buscarPorNombreLike(nombreCategoria);
	}



	@Override
	public List<Categoria> listarCategoria() {
		try
		{
			return repo.findAll();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Categoria> findByEstadoCategoria(boolean estadoCategoria) {
		// TODO Auto-generated method stub
		return repo.findByEstadoCategoria(estadoCategoria);
	}

	@Override
	public Categoria findByIdCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return repo.findByIdCategoria(idCategoria);
	}

}
