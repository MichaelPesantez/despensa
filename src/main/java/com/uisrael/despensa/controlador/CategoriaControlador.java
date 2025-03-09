package com.uisrael.despensa.controlador;

import java.io.Serial;
import java.io.Serializable;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.despensa.modelo.Categoria;
import com.uisrael.despensa.servicio.ICategoriaServicio;

@Controller
public class CategoriaControlador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
	
	@Autowired
	private ICategoriaServicio categoriaServicio;
	private List<Categoria>listaCategoriasBD;
	
	@GetMapping("/categoria")
	private String abrirCategoria(Model model) {
		listaCategoriasBD = categoriaServicio.findByEstadoCategoria(true);
		model.addAttribute("listanuevaCategoriasAll", listaCategoriasBD);
		return "ListaCategoria";
	}
	
	//Crear categoria
	@GetMapping("/nuevacategoria")
	private String crearNuevaCategoria(Model model) {
		Categoria nuevaCategoria = new Categoria();
		model.addAttribute("nueva", nuevaCategoria);
		return "NuevaCategoria";
	}
	
	//guardar Categoria
	@PostMapping("/guardarcategoria")
	private String guardarCategoria(@ModelAttribute("nuevaCategoriaLlena") Categoria categoriaLlena) {
		categoriaLlena.setEstadoCategoria(true);
		categoriaServicio.crearCategoria(categoriaLlena);
		return "redirect:/categoria";
	}
	
	@GetMapping("/editarcategoria/{idCategoria}")
	private String editarCategoria(@PathVariable Integer idCategoria, Model model) {
		model.addAttribute("nueva", categoriaServicio.findByIdCategoria(idCategoria));
		return "NuevaCategoria";
	}
	
	@GetMapping("/eliminarcategoria/{idCategoria}")
	private String eliminarCategoria(@PathVariable Integer idCategoria) {
		Categoria eliminarCategoria = new Categoria();
		eliminarCategoria = categoriaServicio.findByIdCategoria(idCategoria);
		eliminarCategoria.setEstadoCategoria(false);
	    categoriaServicio.crearCategoria(eliminarCategoria);
		return "redirect:/categoria";
	}

}
