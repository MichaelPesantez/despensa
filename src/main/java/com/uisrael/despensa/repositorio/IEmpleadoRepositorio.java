package com.uisrael.despensa.repositorio;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.despensa.modelo.Empleado;

public interface IEmpleadoRepositorio extends JpaRepository<Empleado, Integer> {

	public List<Empleado>findByEstadoEmpleado(boolean estadoEmpleado);
	public Empleado findByIdEmpleado(int idEmpleado);
}
