package com.uisrael.despensa.servicio.impl;

import java.util.Date;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.despensa.modelo.Producto;
import com.uisrael.despensa.repositorio.IProductoRepositorio;
import com.uisrael.despensa.servicio.IProductoServicio;

@Service
@Component
public class ProductoServicio implements IProductoServicio {
	
	@Autowired
	private IProductoRepositorio repo;
	
	@Override
	public void crearProducto(Producto nuevoProducto) {
		// TODO Auto-generated method stub
		try 
		{
			repo.save(nuevoProducto);
		}
		catch(Exception e)
		{
			throw(e);
		}	
	}

	@Override
	public List<Producto> findByNombreProducto(String nombreProducto) {
		// TODO Auto-generated method stub
		return repo.findByNombreProducto(nombreProducto);
	}

	@Override
	public List<Producto> findByFechaIngresoAfter(Date fecha) {
		// TODO Auto-generated method stub
		return repo.findByFechaIngresoAfter(fecha);
	}

	@Override
	public List<Producto> findByIdentificadorComercialLike(String identificadorComercial) {
		// TODO Auto-generated method stub
		return repo.findByIdentificadorComercialLike(identificadorComercial);
	}

	@Override
	public List<Producto> findByEstadoProducto(boolean estadoProducto) {
		// TODO Auto-generated method stub
		return repo.findByEstadoProducto(estadoProducto);
	}

	@Override
	public Producto findByIdProducto(int idProducto) {
		// TODO Auto-generated method stub
		return repo.findByIdProducto(idProducto);
	}

}
