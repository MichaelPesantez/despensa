package com.uisrael.despensa.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.despensa.modelo.CabeceraInventario;
import com.uisrael.despensa.modelo.DetalleInventario;
import com.uisrael.despensa.repositorio.IDetalleInventarioRepositorio;
import com.uisrael.despensa.servicio.IDetalleInventarioServicio;

@Service
@Component
public class DetalleInventarioServicio implements IDetalleInventarioServicio {
	
	@Autowired
	private IDetalleInventarioRepositorio repo;

	@Override
	public void crearDetalleInventario(DetalleInventario nuevoDetalleInventario) {
		// TODO Auto-generated method stub
		try
		{
			repo.save(nuevoDetalleInventario);
		}
		catch(Exception e)
		{
			throw (e);
		}
	}

	@Override
	public int seleccionarMayor() {
		// TODO Auto-generated method stub
		return repo.seleccionarMayor();
	}

	@Override
	public List<DetalleInventario> findByFkDetalleCabeceraInventario(CabeceraInventario fkDetalleCabeceraInventario) {
		// TODO Auto-generated method stub
		return repo.findByFkDetalleCabeceraInventario(fkDetalleCabeceraInventario);
	}

	@Override
	public DetalleInventario findByIdDetalleInventario(int idDetalleInventario) {
		// TODO Auto-generated method stub
		return repo.findByIdDetalleInventario(idDetalleInventario);
	}

}
