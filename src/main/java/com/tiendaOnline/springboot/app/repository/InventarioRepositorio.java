package com.tiendaOnline.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.tiendaOnline.springboot.app.models.entity.Inventario;

public interface InventarioRepositorio extends CrudRepository<Inventario, Integer>{

}
