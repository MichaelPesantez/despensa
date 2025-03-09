package com.uisrael.despensa.servicio;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.uisrael.despensa.modelo.CabeceraInventario;
import com.uisrael.despensa.modelo.Persona;

public interface ICabeceraInventarioServicio {

	public void crearCabeceraInventario(CabeceraInventario nuevaCabeceraInventario);
	public List<CabeceraInventario>listarPorFecha();
	public List<CabeceraInventario>findByOrderByFechaCabeceraInventario();
	public List<CabeceraInventario>listarPorPersona(@Param("codigo")Persona codigo);
	public CabeceraInventario ultima();
}
