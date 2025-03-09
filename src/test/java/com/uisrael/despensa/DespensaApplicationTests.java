package com.uisrael.despensa;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.despensa.modelo.CabeceraInventario;
import com.uisrael.despensa.modelo.Categoria;
import com.uisrael.despensa.modelo.DetalleInventario;
import com.uisrael.despensa.modelo.Persona;
import com.uisrael.despensa.modelo.Producto;
import com.uisrael.despensa.servicio.ICabeceraInventarioServicio;
import com.uisrael.despensa.servicio.ICategoriaServicio;
import com.uisrael.despensa.servicio.IDetalleInventarioServicio;
import com.uisrael.despensa.servicio.IPersonaServicio;
import com.uisrael.despensa.servicio.IProductoServicio;

@SpringBootTest
class DespensaApplicationTests 
{
	
	@Autowired
	IProductoServicio productoServicio;
	@Autowired
	ICategoriaServicio categoriaServicio;
	@Autowired
	ICabeceraInventarioServicio cabeceraInventarioServicio;
	@Autowired
	IDetalleInventarioServicio detalleInventarioServicio;
	@Autowired
	IPersonaServicio personaServicio;
	
	@Test
	void contextLoads() 
	{
	//Listar producto por nombre
	/*
	List<Producto> listaProducto = productoServicio.findByNombreProducto("Doritos Fiesta");
	for(Producto producto : listaProducto) 
	{
		System.err.println(producto.getIdProducto()+" - "+producto.getNombreProducto());
	}
	
	//Listar producto despues de fecha
	List<Producto> listaProductoFecha = productoServicio.findByFechaIngresoAfter(new Date());
	for(Producto producto : listaProductoFecha) 
	{
		System.err.println(producto.getIdProducto()+" - "+producto.getNombreProducto());
	}
	
	
	//Listar producto por identificador like
	List<Producto>listarProductoIdentificador = productoServicio.findByIdentificadorComercialLike("%N%");
	for(Producto producto : listarProductoIdentificador) 
	{
		System.err.println(producto.getIdProducto()+" - "+producto.getNombreProducto());
	}
	
	//Listar personas que viven en Cuenca
	List<Persona>listaPersona = personaServicio.buscarPorCiudad("Cuenca");
	for(Persona persona : listaPersona)
	{
		System.err.println(persona.getIdPersona()+" - "+persona.getNombrePersona());
	}
	
	//Contar el numero de personas que se llaman Michael
	int numeroPersonas = personaServicio.contarPorNombreExcepto("Michael");
	System.err.println(numeroPersonas);
	
	//Primera persona de la lista ordenada por nombre
	Persona primera = personaServicio.primeraPersonaPorNombre();
	System.err.println(primera.getIdPersona()+" - "+primera.getNombrePersona());
	
		
	//Listar Categoria por nombres parecido
	List<Categoria>listaCategoria = categoriaServicio.buscarPorNombreLike("Co");
	for(Categoria categoria : listaCategoria) 
	{
		System.err.println(categoria.getIdCategoria()+" - "+categoria.getNombre());
	}
	
	//Listar por estado y codigo mayor
	List<Categoria>listaCategoriaEstado = categoriaServicio.buscarPorEstadoCodigoMayor(true, 3);
	for(Categoria categoria : listaCategoriaEstado) 
	{
		System.err.println(categoria.getIdCategoria()+" - "+categoria.getNombre());
	}
	
	//Listar Categoria por estado true
	List<Categoria>listaCategoriaEstadoTrue = categoriaServicio.findByEstadoCategoriaTrue();
	for(Categoria categoria : listaCategoriaEstadoTrue) 
	{
		System.err.println(categoria.getIdCategoria()+" - "+categoria.getNombre());
	}
	
		
	//Listar cabecera pedido por fecha
	List<CabeceraInventario>listaCabecera = cabeceraInventarioServicio.listarPorFecha();
	for(CabeceraInventario cabeceraInventario : listaCabecera) 
	{
		System.err.println(cabeceraInventario.getIdCabeceraInventario()+" - "+cabeceraInventario.getFechaCabeceraInventario()+" - "+cabeceraInventario.getObservacion());
	}
	
	//Ordenar por fecha
	List<CabeceraInventario>listaCabeceraOrdenada = cabeceraInventarioServicio.findByOrderByFechaCabeceraInventario();
	for(CabeceraInventario cabeceraInventario : listaCabeceraOrdenada) 
	{
		System.err.println(cabeceraInventario.getIdCabeceraInventario()+" - "+cabeceraInventario.getFechaCabeceraInventario()+" - "+cabeceraInventario.getObservacion());
	}
	
	//Listar Cabecera por persona
	Persona nueva = new Persona();
	nueva.setIdPersona(1);
	List<CabeceraInventario>listaCabeceraPersona = cabeceraInventarioServicio.listarPorPersona(nueva);
	for(CabeceraInventario cabeceraInventario : listaCabeceraPersona) 
	{
		System.err.println(cabeceraInventario.getIdCabeceraInventario()+" - "+cabeceraInventario.getFechaCabeceraInventario()+" - "+cabeceraInventario.getObservacion());
	}
	
		
	//Seleccionar la cantidad mayor de Detall inventario	
	int maximo = detalleInventarioServicio.seleccionarMayor();
	System.err.println(maximo);
	
	//Listar por cabecera
	CabeceraInventario nuevo = new CabeceraInventario();
	nuevo.setIdCabeceraInventario(1);
	List<DetalleInventario>listaDetalle = detalleInventarioServicio.findByFkDetalleCabeceraInventario(nuevo);
	for(DetalleInventario detalleInventario : listaDetalle) 
	{
		System.err.println(detalleInventario.getIdDetalleInventario()+" - "+detalleInventario.getIdDetalleInventario()+" - "+detalleInventario.getCantidad());
	}
	
	//Buscar por id
	DetalleInventario regresar = new DetalleInventario();
	regresar = detalleInventarioServicio.findByIdDetalleInventario(1);
	System.err.println(regresar.getIdDetalleInventario()+" - "+regresar.getCantidad()+" - "+regresar.getIdDetalleInventario());
	*/
	}
}