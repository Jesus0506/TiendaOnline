package com.tiendaOnline.springboot.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendaOnline.springboot.app.models.entity.Despacho;
import com.tiendaOnline.springboot.app.repository.DespachoRepository;

@Service
@Transactional
public class DespachoService {

	@Autowired
	private DespachoRepository repositorio;
	
	public Despacho crear(Despacho despacho) {
		return repositorio.save(despacho);
	}
	
	public List<Despacho> buscarTodo(){
		return (List<Despacho>) repositorio.findAll();
	}
	
	public Despacho buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public Despacho actualizar(Despacho tiendaActualizar) {
		Despacho tiendaActual = repositorio.findById(tiendaActualizar.getId_despacho()).get();
		
		tiendaActual.setId_despacho(tiendaActualizar.getId_despacho());
		tiendaActual.setNombre(tiendaActualizar.getDireccion());
		tiendaActual.setDireccion(tiendaActualizar.getDireccion());
		tiendaActual.setRazon_social(tiendaActualizar.getRazon_social());
		
		
		Despacho tiendaActualizada = repositorio.save(tiendaActual); 
		return tiendaActualizada;
	}
	
	public void eliminarDespacho(Integer id) {
		repositorio.deleteById(id);
	}
	
	
}
