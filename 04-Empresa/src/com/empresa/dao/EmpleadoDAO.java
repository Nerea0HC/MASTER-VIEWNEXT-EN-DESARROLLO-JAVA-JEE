package com.empresa.dao;

import com.empresa.conexion.ConexionBD;
import com.empresa.modelo.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Nerea Hernandez Cano
 * @version 2.3
 */
public class EmpleadoDAO {
    private ConexionBD conexionBD = new ConexionBD();

    // Insertar un nuevo empleado
    public void insertarEmpleado(Empleado empleado) {
        String query = "INSERT INTO empleados (nombre, apellido1, apellido2, fecha_nacimiento, salario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conex = conexionBD.conexion();
             PreparedStatement ps = conex.prepareStatement(query)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido1());
            ps.setString(3, empleado.getApellido2());
            ps.setDate(4, Date.valueOf(empleado.getFechaNacimiento()));
            ps.setDouble(5, empleado.getSalario());
            ps.executeUpdate();
            System.out.println("Empleado insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar empleado por ID
    public void actualizarEmpleado(int id, Empleado empleado) {
        String query = "UPDATE empleados SET nombre = ?, apellido1 = ?, apellido2 = ?, fecha_nacimiento = ?, salario = ? WHERE id = ?";
        try (Connection conex = conexionBD.conexion();
             PreparedStatement ps = conex.prepareStatement(query)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido1());
            ps.setString(3, empleado.getApellido2());
            ps.setDate(4, Date.valueOf(empleado.getFechaNacimiento()));
            ps.setDouble(5, empleado.getSalario());
            ps.setInt(6, id);
            ps.executeUpdate();
            System.out.println("Empleado actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar empleado por ID
    public void eliminarEmpleado(int id) {
        String query = "DELETE FROM empleados WHERE id = ?";
        try (Connection conex = conexionBD.conexion();
             PreparedStatement ps = conex.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Empleado eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener lista de todos los empleados
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleados";
        try (Connection conex = conexionBD.conexion();
             Statement st = conex.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Empleado emp = new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
                        rs.getString("apellido2"), rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getDouble("salario"));
                empleados.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    // Buscar empleados por apellido1
    public List<Empleado> buscarEmpleadosPorApellido(String apellido1) {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleados WHERE apellido1 = ?";
        try (Connection conex = conexionBD.conexion();
             PreparedStatement ps = conex.prepareStatement(query)) {
            ps.setString(1, apellido1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
                        rs.getString("apellido2"), rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getDouble("salario"));
                empleados.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    // Obtener el salario medio de todos los empleados
    public double obtenerSalarioMedio() {
        double salarioMedio = 0;
        String query = "SELECT AVG(salario) AS salario_medio FROM empleados";
        try (Connection conex = conexionBD.conexion();
             Statement st = conex.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) {
                salarioMedio = rs.getDouble("salario_medio");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salarioMedio;
    }
}
