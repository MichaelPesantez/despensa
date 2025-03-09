package com.uisrae.despensa.request;

import lombok.Data;

@Data
public class DetalleFacturaRequest {

	public int idDetalleInventario;
	public int cantidad;
	public int codigoProducto;
	public int codigoCabecera;
	public DetalleFacturaRequest(int idDetalleInventario, int cantidad, int codigoProducto, int codigoCabecera) {
		super();
		this.idDetalleInventario = idDetalleInventario;
		this.cantidad = cantidad;
		this.codigoProducto = codigoProducto;
		this.codigoCabecera = codigoCabecera;
	}
	public DetalleFacturaRequest() {
		super();
	}
	
	
	
}
