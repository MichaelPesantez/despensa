package com.uisrael.despensa.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	
	private String nombreProducto;
	private String descripcionProducto;
	private String identificadorComercial;
	private double precio;
	private int stock;
	private boolean estadoProducto;
	
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;
	
	@ManyToOne
	@JoinColumn(name = "fkCategoria")
	private Categoria fkCategoria;
	
	@OneToMany(mappedBy = "fkDetalleInventarioProducto")
	private List<DetalleInventario> listaDetalleInventario = new ArrayList<>();
	
}
