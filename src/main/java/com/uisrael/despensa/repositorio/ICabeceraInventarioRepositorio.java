package com.uisrael.despensa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.despensa.modelo.CabeceraInventario;
import com.uisrael.despensa.modelo.Persona;

public interface ICabeceraInventarioRepositorio extends JpaRepository<CabeceraInventario, Integer>{

	@Query("Select c from CabeceraInventario c where date('2023/06/17')<=fechaCabeceraInventario")
	public List<CabeceraInventario>listarPorFecha();
	
	public List<CabeceraInventario>findByOrderByFechaCabeceraInventario();
	
	@Query("Select c from CabeceraInventario c where fkPersona =:codigo")
	public List<CabeceraInventario>listarPorPersona(@Param("codigo")Persona codigo);
	
	@Query("Select p from CabeceraInventario p order by idCabeceraInventario desc limit 1")
	public CabeceraInventario ultima();
}
