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
@Table(name="despacho")
@NamedQueries({
    @NamedQuery(name = "Despacho.findAll", query = "SELECT d FROM Despacho d"),
    @NamedQuery(name = "Despacho.findById_despacho", query = "SELECT d FROM Despacho d WHERE d.id_despacho = :id_despacho"),
    @NamedQuery(name = "Despacho.findByNombre", query = "SELECT d FROM Despacho d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Despacho.findByDireccion", query = "SELECT d FROM Despacho d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Despacho.findByRazon_Social", query = "SELECT d FROM Despacho d WHERE d.razon_social = :razon_social"),
})
public class Despacho implements Serializable{

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
