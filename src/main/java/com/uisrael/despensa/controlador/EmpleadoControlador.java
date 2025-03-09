package com.uisrael.despensa.controlador;

import java.io.Serial;
import java.io.Serializable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.despensa.modelo.Empleado;
import com.uisrael.despensa.servicio.IEmpleadoServicio;


@Controller
public class EmpleadoControlador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
	
	@Autowired
	private IEmpleadoServicio servicioEmpleado;

	@GetMapping("/empleado")
	public String abrirEmpleado(Model model) {
		model.addAttribute("listaEmpleados", servicioEmpleado.findByEstadoEmpleado(true));
		return "ListaEmpleado";
	}

	@GetMapping("/nuevoempleado")
	private String crearNuevaPersona(Model model) {
		model.addAttribute("nuevoEmpleado", new Empleado());
		return "NuevoEmpleado";
	}

	@PostMapping("/guardarempleado")
	private String guardarPersona(@ModelAttribute("nuevoEmpleado") Empleado empleadoLleno) {
		empleadoLleno.setEstadoEmpleado(true);
		servicioEmpleado.crearEmpleado(empleadoLleno);
		return "redirect:/empleado";
	}
	
	@GetMapping("/editarempleado/{idEmpleado}")
	private String editarEmpleado(@PathVariable Integer idEmpleado, Model model) {
		model.addAttribute("nuevoEmpleado", servicioEmpleado.findByIdEmpleado(idEmpleado));
		return "NuevoEmpleado";
	}
	
	@GetMapping("/eliminarempleado/{idEmpleado}")
	private String eliminarEmpleado(@PathVariable Integer idEmpleado) {
		Empleado eliminarEmpleado = new Empleado();
		eliminarEmpleado = servicioEmpleado.findByIdEmpleado(idEmpleado);
		eliminarEmpleado.setEstadoEmpleado(false);
		servicioEmpleado.crearEmpleado(eliminarEmpleado);
		return "redirect:/empleado";
	}

}
