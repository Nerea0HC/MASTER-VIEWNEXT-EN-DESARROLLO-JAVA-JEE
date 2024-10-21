package com.empresa.modelo;

import java.time.LocalDate;
/**
 * @author Nerea Hernandez Cano
 * @version 2.3
 */
public class Empleado {
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private LocalDate fechaNacimiento; 
	private double salario;

	public Empleado(int id, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento,
			double salario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado{id=" + id + ", nombre='" + nombre + '\'' + ", apellido1='" + apellido1 + '\'' + ", apellido2='"
				+ apellido2 + '\'' + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario + '}';
	}
}
