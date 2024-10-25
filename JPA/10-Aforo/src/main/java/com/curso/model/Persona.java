package com.curso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
@NamedQueries({
    @NamedQuery(name = "Persona.buscarTodas", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.buscarPorId", query = "SELECT p FROM Persona p WHERE p.id = :id"),
    @NamedQuery(name = "Persona.buscarPorApellido1", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1"),
    @NamedQuery(name = "Persona.buscarPorApellido1YApellido2", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1 AND p.apellido2 = :apellido2")
})
public class Persona {
	@Id
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	@Column(name = "num_telf")
	private int numTelf;
	
	public Persona() {
		super();
	}

	public Persona(String nombre, String apellido1, String apellido2, int numTelf) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.numTelf = numTelf;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getNumTelf() {
		return numTelf;
	}

	public void setNumTelf(int numTelf) {
		this.numTelf = numTelf;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", numTelf=" + numTelf + "]";
	}

}
