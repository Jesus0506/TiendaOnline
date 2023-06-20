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

import com.tiendaOnline.springboot.app.models.entity.Cliente;
import com.tiendaOnline.springboot.app.services.ClienteServices;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired 
	private ClienteServices servicio;
	
	
	@RequestMapping( "/listar")
	public String listar (Model model) {
		
		List <Cliente> listaCliente= servicio.buscarTodo();
		System.out.println("LISTACLIENTE: " + listaCliente);
		model.addAttribute("listaCliente", listaCliente);
		return "/listar";
	}

	@RequestMapping( "/nuevo")
	public String crear(Model model) {
		Cliente cliente = new Cliente ();
		model.addAttribute("cliente",cliente);
		return "/crearCliente";	
	}
	
	@RequestMapping(value ="/guardar", method= RequestMethod.POST)
	public String crear(@ModelAttribute("cliente") Cliente cliente) {
		    servicio.crear(cliente);
		    return "redirect:/cliente/listar";
		
	}
	@Valid
	 @RequestMapping(value ="/actualizar/{id}")
	public ModelAndView editar(@PathVariable(name="id") int id, Model model) {
		ModelAndView mav = new ModelAndView("/form");
		Cliente cliente = servicio.buscarPorId(id);
		mav.addObject("cliente",cliente);
		String subTitulo= "Actualizar Cliente";
		model.addAttribute("subTitulo", subTitulo);
		return mav;
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(name="id") int id) {
		servicio.eliminarCliente(id);
		return "redirect:/cliente/listar";
	}

}
