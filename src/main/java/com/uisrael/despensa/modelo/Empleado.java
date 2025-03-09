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
public class Empleado implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;
	
	private String cedula;
	private String nombreEmpleado;
	private String apellidoEmpleado;
	private String telefonoEmpleado;
	private String direccionEmpleado;
	private String emailEmpleado;
	private boolean estadoEmpleado;
	
	@OneToMany(mappedBy = "fkEmpleado")
	private List<CabeceraInventario> listaCabeceraInventario = new ArrayList<>();

}
