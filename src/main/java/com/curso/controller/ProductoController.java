package com.curso.controller;

import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.entidades.Producto;
import com.curso.servicio.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService prodService;
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
							
		Producto p = new Producto();
							//en el form como lo hemos llamado
		model.addAttribute("nuevoProducto", p);
		
		return "crear-producto";
	}
	
	@PostMapping("/nuevo")
	public String procesarNuevo(
			@ModelAttribute("nuevoProducto")
			@Valid Producto nuevoPorducto,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "crear-producto";
		}
		
		prodService.crearProducto(nuevoPorducto);
		
		return "redirect:/nuevo";
	}
}
