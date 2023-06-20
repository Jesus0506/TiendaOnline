package com.tiendaOnline.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById_producto", query = "SELECT p FROM Producto p WHERE p.id_producto = :id_producto"),
    @NamedQuery(name = "Producto.finByNombreP", query = "SELECT p FROM Producto p WHERE p.id_producto = :id_producto"),
})
public class Producto implements Serializable{

private static final long serialVersionUID = 1l;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_despacho")
	private Integer id_despacho;
	
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	
	
	@Basic(optional = false)
	@Column(name = "direccion")
	private String direccion;
	
	@Basic(optional = false)
	@Column(name = "razon_social")
	private String razon_social;
	
}
