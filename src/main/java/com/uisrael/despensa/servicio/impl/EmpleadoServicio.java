package com.uisrael.despensa.servicio.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.despensa.modelo.Empleado;
import com.uisrael.despensa.repositorio.IEmpleadoRepositorio;
import com.uisrael.despensa.servicio.IEmpleadoServicio;

@Service
@Component
public class EmpleadoServicio implements IEmpleadoServicio {

	@Autowired
	private IEmpleadoRepositorio empleadoRepositorio;
	
	@Override
	public void crearEmpleado(Empleado nuevoEmpleado) {
		try
		{
			empleadoRepositorio.save(nuevoEmpleado);
		}
		catch(Exception e)
		{
			throw (e);
		}
		
	}
	@Override
	public List<Empleado> findByEstadoEmpleado(boolean estadoEmpleado) {
		// TODO Auto-generated method stub
		return empleadoRepositorio.findByEstadoEmpleado(estadoEmpleado);
	}
	
	@Override
	public Empleado findByIdEmpleado(int idEmpleado) {
		// TODO Auto-generated method stub
		return empleadoRepositorio.findByIdEmpleado(idEmpleado);
	}

}
