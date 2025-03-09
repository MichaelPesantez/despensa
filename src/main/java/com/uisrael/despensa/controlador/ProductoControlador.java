package com.uisrael.despensa.controlador;

import java.io.Serial;
import java.io.Serializable;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.despensa.servicio.ICategoriaServicio;
import com.uisrael.despensa.modelo.Producto;
import com.uisrael.despensa.servicio.IProductoServicio;

@Controller
public class ProductoControlador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
	
	@Autowired
	private IProductoServicio servicioProducto;
	@Autowired
	private ICategoriaServicio servicioCategoria;
	
	@GetMapping("/producto")
	public String listaProducto(Model model) {
		model.addAttribute("listaProductos", servicioProducto.findByEstadoProducto(true));
		return "ListaProducto";
	}

	@GetMapping("/nuevoproducto")
	public String nuevoProducto(Model model){
		model.addAttribute("nuevoProducto", new Producto());
		model.addAttribute("listaCategorias", servicioCategoria.findByEstadoCategoria(true));
		return "NuevoProducto";
		
	}
	
	@PostMapping("/guardarproducto")
	public String guardarProducto(@ModelAttribute Producto nuevoProducto) {
		nuevoProducto.setFechaIngreso(new Date());
		nuevoProducto.setEstadoProducto(true);
		servicioProducto.crearProducto(nuevoProducto);
		return "redirect:/producto";
	}
	
	@GetMapping("/editarproducto/{idProducto}")
	private String editarProducto(@PathVariable Integer idProducto, Model model) {
		try {
		model.addAttribute("listaCategorias", servicioCategoria.findByEstadoCategoria(true));
		Producto encontrado = servicioProducto.findByIdProducto(idProducto);
		model.addAttribute("nuevoProducto", encontrado);
		return "NuevoProducto";
		}
		catch(Exception e)
		{
			System.out.println(""+e.getMessage());
			return "";
		}
	}
	
	@GetMapping("/eliminarproducto/{idProducto}")
	private String eliminarProducto(@PathVariable Integer idProducto) {
		Producto eliminarProducto = new Producto();
		eliminarProducto = servicioProducto.findByIdProducto(idProducto);
		eliminarProducto.setEstadoProducto(false);
	    servicioProducto.crearProducto(eliminarProducto);
		return "redirect:/producto";
	}

}
