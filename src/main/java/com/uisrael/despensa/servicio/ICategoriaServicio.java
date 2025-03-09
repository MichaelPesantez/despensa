package com.uisrael.despensa.servicio;

import java.util.List;


import org.springframework.data.repository.query.Param;

import com.uisrael.despensa.modelo.Categoria;

public interface ICategoriaServicio {

	public boolean crearCategoria (Categoria nuevaCategoria);
	public List<Categoria>buscarPorEstadoCodigoMayor(@Param("estado")boolean estado, 
			 @Param("codigo")int codigo);
	public List<Categoria>buscarPorNombreLike(String nombreCategoria);
	public List<Categoria>findByEstadoCategoria(boolean estadoCategoria);
	public List<Categoria>listarCategoria();
	public Categoria findByIdCategoria(int idCategoria);
}
