package com.tiendaOnline.springboot.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tiendaOnline.springboot.app.models.entity.Despacho;
import com.tiendaOnline.springboot.app.services.DespachoService;

@Controller
@RequestMapping("/despacho")
public class DespachoController {
	
	@Autowired
	private DespachoService servicio;
	
	@RequestMapping( "/listar")
	public String listar (Model model) {
		
		List <Despacho> listaTienda= servicio.buscarTodo();
		System.out.println("LISTATIENDA: " + listaTienda);
		model.addAttribute("listaTienda", listaTienda);
		return "moduloDespacho/listar";
	}
	
	@RequestMapping( "/nuevo")
	public String crear(Model model) {
		Despacho tienda = new Despacho ();
		String subTitulo = "Crear Despacho";
		model.addAttribute("subTitulo", subTitulo);
		model.addAttribute("despacho",tienda);
		return "moduloDespacho/crearDespacho";	
	}
	
	@RequestMapping(value ="/guardar", method= RequestMethod.POST)
	public String crear(@ModelAttribute("despacho") Despacho despacho) {
		    servicio.crear(despacho);
		    return "redirect:/despacho/listar";		
	}
	
	@Valid
	 @RequestMapping(value ="/actualizar/{id}")
	public ModelAndView editar(@PathVariable(name="id") int id, Model model) {
		ModelAndView mav = new ModelAndView("/moduloDespacho/actualizarDespacho");
		Despacho despacho = servicio.buscarPorId(id);
		String subTitulo = "Actualizar Despacho";
		model.addAttribute("subTitulo", subTitulo);
		mav.addObject("despacho",despacho);
		return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(name="id") int id) {
		servicio.eliminarDespacho(id);
		return "redirect:/despacho/listar";
	}
	

}
