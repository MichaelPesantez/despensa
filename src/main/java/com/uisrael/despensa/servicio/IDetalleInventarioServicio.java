package com.uisrael.despensa.servicio;

import java.util.List;

import com.uisrael.despensa.modelo.CabeceraInventario;
import com.uisrael.despensa.modelo.DetalleInventario;

public interface IDetalleInventarioServicio {

	public void crearDetalleInventario(DetalleInventario nuevoDetalleInventario);
	public int seleccionarMayor();
	public List<DetalleInventario>findByFkDetalleCabeceraInventario(CabeceraInventario fkDetalleCabeceraInventario);
	public DetalleInventario findByIdDetalleInventario(int idDetalleInventario);
}
