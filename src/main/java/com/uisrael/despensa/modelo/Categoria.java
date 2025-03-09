package com.uisrael.despensa.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Categoria implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;
	
	
	private String nombre;
	private String descripcion;
	private boolean estadoCategoria;
	
	@OneToMany(mappedBy = "fkCategoria")
	private List<Producto> listaProducto = new ArrayList<>();

}
