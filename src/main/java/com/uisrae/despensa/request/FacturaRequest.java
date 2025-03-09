package com.uisrae.despensa.request;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class FacturaRequest implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;
	
	public int idCabeceraInventario;
	public Date fechaCabeceraInventario;
	public int codigoEmpleado;
	public int codigoPersona;
	public String observacion;
	
	public List<DetalleFacturaRequest>detalleFactura;

	public FacturaRequest(int idCabeceraInventario, Date fechaCabeceraInventario, int codigoEmpleado, int codigoPersona,
			String observacion, List<DetalleFacturaRequest> detalleFactura) {
		super();
		this.idCabeceraInventario = idCabeceraInventario;
		this.fechaCabeceraInventario = fechaCabeceraInventario;
		this.codigoEmpleado = codigoEmpleado;
		this.codigoPersona = codigoPersona;
		this.observacion = observacion;
		this.detalleFactura = detalleFactura;
	}

	public FacturaRequest() {
		super();
	}
	
	

}
