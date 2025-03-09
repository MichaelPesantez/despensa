package com.uisrael.despensa.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.despensa.modelo.Producto;

public interface IProductoRepositorio extends JpaRepository<Producto, Integer> {
	
	public List<Producto>findByNombreProducto(String nombreProducto);
	public List<Producto>findByFechaIngresoAfter(Date fecha);
	public List<Producto>findByIdentificadorComercialLike(String identificadorComercial);
	public List<Producto> findByEstadoProducto(boolean estadoProducto);
	public Producto findByIdProducto(int idProducto);

}
