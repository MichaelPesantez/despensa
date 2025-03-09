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

import com.uisrael.despensa.modelo.Persona;
import com.uisrael.despensa.servicio.IPersonaServicio;

@Controller
public class PersonaControlador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

	@Autowired
	private IPersonaServicio servicioPersona;

	@GetMapping("/persona")
	public String abrirPersona(Model model) {
		model.addAttribute("listaPersonas", servicioPersona.findByEstadoPersona(true));
		return "ListaPersona";
	}

	@GetMapping("/nuevapersona")
	private String crearNuevaPersona(Model model) {
		model.addAttribute("nuevaPersona", new Persona());
		return "NuevaPersona";
	}

	@PostMapping("/guardarpersona")
	private String guardarPersona(@ModelAttribute("nuevaPersona") Persona personaLlena) {
		personaLlena.setEstadoPersona(true);
		servicioPersona.crearPersona(personaLlena);
		return "redirect:/persona";
	}
	
	@GetMapping("/editarpersona/{idPersona}")
	private String editarPersona(@PathVariable Integer idPersona, Model model) {
		model.addAttribute("nuevaPersona", servicioPersona.findByIdPersona(idPersona));
		return "NuevaPersona";
	}
	
	@GetMapping("/eliminarpersona/{idPersona}")
	private String eliminarPersona(@PathVariable Integer idPersona) {
		Persona eliminarPersona = new Persona();
		eliminarPersona = servicioPersona.findByIdPersona(idPersona);
		eliminarPersona.setEstadoPersona(false);
		servicioPersona.crearPersona(eliminarPersona);
		return "redirect:/persona";
	}
	
}
