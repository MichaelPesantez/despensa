package com.uisrael.despensa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.despensa.modelo.CabeceraInventario;
import com.uisrael.despensa.modelo.DetalleInventario;

public interface IDetalleInventarioRepositorio extends JpaRepository<DetalleInventario, Integer> {

	@Query("Select max(cantidad) from DetalleInventario")
	public int seleccionarMayor();
	
	public List<DetalleInventario>findByFkDetalleCabeceraInventario(CabeceraInventario fkDetalleCabeceraInventario);
	public DetalleInventario findByIdDetalleInventario(int idDetalleInventario);
}
