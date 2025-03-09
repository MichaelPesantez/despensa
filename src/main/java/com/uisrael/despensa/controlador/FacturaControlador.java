package com.uisrael.despensa.controlador;

import java.io.Serial;
import java.io.Serializable;



import java.util.Date;
import java.util.List;

import com.uisrae.despensa.request.DetalleFacturaRequest;
import com.uisrae.despensa.request.FacturaRequest;
import com.uisrael.despensa.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uisrael.despensa.servicio.ICabeceraInventarioServicio;
import com.uisrael.despensa.servicio.IDetalleInventarioServicio;
import com.uisrael.despensa.servicio.IEmpleadoServicio;
import com.uisrael.despensa.servicio.IPersonaServicio;
import com.uisrael.despensa.servicio.IProductoServicio;

@Controller
public class FacturaControlador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
	@Autowired
	private IEmpleadoServicio servicioEmpleado;
	@Autowired
	private IPersonaServicio servicioPersona;
	@Autowired
	private IProductoServicio servicioProducto;
	@Autowired
	private ICabeceraInventarioServicio servicioCabecera;
	@Autowired
	private IDetalleInventarioServicio servicioDetalle;

	
	@GetMapping("/nuevafactura")
	public String nuevaFactura(Model model)
	{
		model.addAttribute("nuevaFactura", new CabeceraInventario());
		model.addAttribute("listaEmpleado", servicioEmpleado.findByEstadoEmpleado(true));
		model.addAttribute("listaCliente", servicioPersona.findByEstadoPersona(true));
		model.addAttribute("nuevoDetalle", new DetalleInventario());
		model.addAttribute("listaProducto", servicioProducto.findByEstadoProducto(true));
		return "NuevaFactura";
		
	}
	
	@PostMapping("/guardarfactura")
	public String guardarFactura(@ModelAttribute("nuevaFactura")CabeceraInventario nuevacabecera) 
	{
		nuevacabecera.setFechaCabeceraInventario(new Date());
		servicioCabecera.crearCabeceraInventario(nuevacabecera);
		return "redirect:/producto";
	}

	@GetMapping("/factura")
	public String listaFactura(Model model) {
		model.addAttribute("listaFactura", servicioCabecera.findByOrderByFechaCabeceraInventario());
		return "ListaFactura";
	}
	
	@GetMapping("/consultarproductos/{idCabeceraInventario}")
	private String editarProducto(@PathVariable Integer idCabeceraInventario) 
	{
		return "redirect:/mostrardetalle/"+idCabeceraInventario;
	}
	
	@GetMapping("/mostrardetalle/{idCabeceraInventario}")
	private String editarDetalle(@PathVariable Integer idCabeceraInventario, Model model) 
	{
		CabeceraInventario nueva = new CabeceraInventario();
		nueva.setIdCabeceraInventario(idCabeceraInventario);
		model.addAttribute("listaDetalles", servicioDetalle.findByFkDetalleCabeceraInventario(nueva));
		return "ListaDetalle";
	}

	@PostMapping("/guardadetalle")
	@ResponseBody
	public String guardaDetalle(@RequestBody FacturaRequest facturaRequest)
	{
	
		Persona persona =  servicioPersona.findByIdPersona(facturaRequest.codigoPersona);
		Empleado empleado = servicioEmpleado.findByIdEmpleado(facturaRequest.codigoEmpleado);
		String observacion = facturaRequest.getObservacion();
		CabeceraInventario cabeceraInventario = new CabeceraInventario();
		cabeceraInventario.setFkPersona(persona);
		cabeceraInventario.setFkEmpleado(empleado);
		cabeceraInventario.setFechaCabeceraInventario(new Date());
		cabeceraInventario.setObservacion(observacion);
		servicioCabecera.crearCabeceraInventario(cabeceraInventario);
		CabeceraInventario detalleCabecera = new CabeceraInventario();
		detalleCabecera = servicioCabecera.ultima();
		List<DetalleFacturaRequest> detalleFactura = facturaRequest.detalleFactura;
		for (DetalleFacturaRequest detalleFacturaRequest:detalleFactura
		) 
		{
			DetalleInventario detalleInventario = new DetalleInventario();
			detalleInventario.setCantidad(detalleFacturaRequest.getCantidad());
			detalleInventario.setFkDetalleInventarioProducto(servicioProducto.findByIdProducto(detalleFacturaRequest.getCodigoProducto()));
			detalleInventario.setFkDetalleCabeceraInventario(detalleCabecera);
			servicioDetalle.crearDetalleInventario(detalleInventario);

		}

		return null;
	}
	
	
}
