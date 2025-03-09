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
public class CabeceraInventario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCabeceraInventario;
	@Temporal(TemporalType.DATE)
	private Date fechaCabeceraInventario;
	private String observacion;
	
	@ManyToOne
	@JoinColumn(name = "fkPersona")
	private Persona fkPersona;
	
	@ManyToOne
	@JoinColumn(name = "fkEmpleado")
	private Empleado fkEmpleado;
	
	@OneToMany(mappedBy = "fkDetalleCabeceraInventario")
	private List<DetalleInventario> listaDetalleCabeceraInventario = new ArrayList<>();



}
