package com.empresa.controlador;

import com.empresa.dao.EmpleadoDAO;
import com.empresa.modelo.Empleado;

import java.util.List;

public class EmpleadoControlador {
	private EmpleadoDAO empleadoDAO;

	public EmpleadoControlador() {
		this.empleadoDAO = new EmpleadoDAO();
	}

	public void agregarEmpleado(Empleado empleado) {
		empleadoDAO.insertarEmpleado(empleado);
	}

	public void actualizarEmpleado(int id, Empleado empleado) {
		empleadoDAO.actualizarEmpleado(id, empleado);
	}

	public void eliminarEmpleado(int id) {
		empleadoDAO.eliminarEmpleado(id);
	}

	public List<Empleado> listarEmpleados() {
		return empleadoDAO.obtenerEmpleados();
	}

	public List<Empleado> buscarEmpleadosPorApellido(String apellido1) {
		return empleadoDAO.buscarEmpleadosPorApellido(apellido1);
	}

	public double obtenerSalarioMedio() {
		return empleadoDAO.obtenerSalarioMedio();
	}
}
