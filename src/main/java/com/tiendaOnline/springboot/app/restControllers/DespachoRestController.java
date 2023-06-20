package com.tiendaOnline.springboot.app.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tiendaOnline.springboot.app.models.entity.Despacho;
import com.tiendaOnline.springboot.app.services.DespachoService;

@RestController
@RequestMapping("/rest/despacho")
public class DespachoRestController {

	@Autowired
	private DespachoService servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscaTodo(){
		List<Despacho> listaTiendas = servicio.buscarTodo();
		System.out.println("LISTA DE TIENDAS:" + listaTiendas);
		return new ResponseEntity<>(listaTiendas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
		Despacho despacho = servicio.buscarPorId(id);
		if (despacho == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Despacho no encontrado, el ID proporcionado no es correcto");
		return new ResponseEntity<Object>(despacho, HttpStatus.OK);
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
		)
	public ResponseEntity<Object> crear(@RequestBody Despacho despacho) {
		servicio.crear(despacho);
		return new ResponseEntity<Object>("Despacho creado correctamente", HttpStatus.OK);
	}
	
	@PutMapping (value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
			)
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Despacho despacho) {

		servicio.actualizar(despacho);
		return new ResponseEntity<Object>("Despacho actualizado correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		servicio.eliminarDespacho(id);
		return new ResponseEntity<Object>("Despacho eliminado correctamente", HttpStatus.OK);
	}
	
}
