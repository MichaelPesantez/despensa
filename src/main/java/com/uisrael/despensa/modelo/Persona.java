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
public class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	
	private String cedula;
	private String nombrePersona;
	private String apellidoPersona;
	private String telefonoPersona;
	private String direccionPersona;
	private String emailPersona;
	private boolean estadoPersona;
	
	@OneToMany(mappedBy = "fkPersona")
	private List<CabeceraInventario> listaCabeceraInventario = new ArrayList<>();
}
