package com.uisrael.despensa.modelo;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DetalleInventario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleInventario;
	
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "fkDetalleInventarioProducto")
	private Producto fkDetalleInventarioProducto;
	
	@ManyToOne
	@JoinColumn(name = "fkDetalleCabeceraInventario")
	private CabeceraInventario fkDetalleCabeceraInventario;

}
