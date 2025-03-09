package com.uisrael.despensa.repositorio;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.despensa.modelo.Categoria;

public interface ICategoriaRepositorio extends JpaRepository<Categoria, Integer>{
	
	@Query("Select c from Categoria c where estadoCategoria =:estado and idCategoria>:codigo")
	public List<Categoria>buscarPorEstadoCodigoMayor(@Param("estado")boolean estado, 
													 @Param("codigo")int codigo);
	@Query("Select c from Categoria c where nombre like %?1%")
	public List<Categoria>buscarPorNombreLike(String nombreCategoria);
	public List<Categoria>findByEstadoCategoria(boolean estadoCategoria);
	public Categoria findByIdCategoria(int idCategoria);

}
