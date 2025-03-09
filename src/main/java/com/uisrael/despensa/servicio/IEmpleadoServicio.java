package com.uisrael.despensa.servicio;

import java.util.List;


import com.uisrael.despensa.modelo.Empleado;


public interface IEmpleadoServicio {

	public List<Empleado>findByEstadoEmpleado(boolean estadoEmpleado);
	public Empleado findByIdEmpleado(int idEmpleado);
	public void crearEmpleado(Empleado nuevoEmpleado);
}
