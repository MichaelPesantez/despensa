package com.uisrael.despensa.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.despensa.modelo.CabeceraInventario;
import com.uisrael.despensa.modelo.Persona;
import com.uisrael.despensa.repositorio.ICabeceraInventarioRepositorio;
import com.uisrael.despensa.servicio.ICabeceraInventarioServicio;

@Service
@Component
public class CabeceraInventarioServicio implements ICabeceraInventarioServicio {
	
	@Autowired
	private ICabeceraInventarioRepositorio repo;

	@Override
	public void crearCabeceraInventario(CabeceraInventario nuevaCabeceraInventario) {
		// TODO Auto-generated method stub
		try
		{
			repo.save(nuevaCabeceraInventario);
		}
		catch(Exception e)
		{
			throw (e);
		}
	}

	@Override
	public List<CabeceraInventario> listarPorFecha() {
		// TODO Auto-generated method stub
		return repo.listarPorFecha();
	}

	@Override
	public List<CabeceraInventario> findByOrderByFechaCabeceraInventario() {
		// TODO Auto-generated method stub
		return repo.findByOrderByFechaCabeceraInventario();
	}

	@Override
	public List<CabeceraInventario> listarPorPersona(Persona codigo) {
		// TODO Auto-generated method stub
		return repo.listarPorPersona(codigo);
	}

	@Override
	public CabeceraInventario ultima() {
		// TODO Auto-generated method stub
		return repo.ultima();
	}


}
