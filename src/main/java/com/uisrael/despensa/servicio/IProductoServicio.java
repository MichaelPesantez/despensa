package com.uisrael.despensa.servicio;

import java.util.Date;
import java.util.List;

import com.uisrael.despensa.modelo.Producto;

public interface IProductoServicio {
	
	public void crearProducto(Producto nuevoProducto);
	public List<Producto>findByNombreProducto(String nombreProducto);
	public List<Producto>findByFechaIngresoAfter(Date fecha);
	public List<Producto>findByIdentificadorComercialLike(String identificadorComercial);
	public List<Producto> findByEstadoProducto(boolean estadoProducto);
	public Producto findByIdProducto(int idProducto);


}
