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
@Table(name="inventario")
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT d FROM Inventario d"),
    @NamedQuery(name = "Inventario.findByIdInventario", query = "SELECT d FROM Inventario d WHERE d.id_inventario = :id_inventario"),
    @NamedQuery(name = "Inventario.findByNombreInventario", query = "SELECT d FROM Inventario d WHERE d.nombre_inventario = :nombreInventario"),
    @NamedQuery(name = "Inventario.findByCantidadProducto", query = "SELECT d FROM Inventario d WHERE d.cantidad_producto = :cantidadProducto"),
    @NamedQuery(name = "Inventario.findByDescripcion", query = "SELECT d FROM Inventario d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Inventario.findByEstado", query = "SELECT d FROM Inventario d WHERE d.estado = :estado"),
    @NamedQuery(name = "Inventario.findByNombreproducto", query = "SELECT d FROM Inventario d WHERE d.nombreproducto = :nombreproducto"),
})
public class Inventario implements Serializable{

private static final long serialVersionUID = 1l;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_inventario")
	private Integer id_inventario;
	
	@Basic(optional = false)
	@Column(name = "nombreInventario")
	private String nombreInventario;
	
	@Basic(optional = false)
	@Column(name = "cantidadProducto")
	private Integer cantidadProducto;
	
	
	@Basic(optional = false)
	@Column(name = "descripcion")
	private String descripcion;
	
	@Basic(optional = false)
	@Column(name = "estado")
	private String estado;
	
	@Basic(optional = false)
	@Column(name = "nombreproducto")
	private String nombreproducto;
	
	
}
