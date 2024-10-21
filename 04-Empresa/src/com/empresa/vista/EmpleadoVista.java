package com.empresa.vista;

import com.empresa.controlador.EmpleadoControlador;
import com.empresa.modelo.Empleado;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
/**
 * @author Nerea Hernandez Cano
 * @version 2.3
 */
public class EmpleadoVista {

    public static void main(String[] args) {
        EmpleadoControlador controlador = new EmpleadoControlador();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("1. Insertar Empleado");
            System.out.println("2. Actualizar Empleado");
            System.out.println("3. Eliminar Empleado");
            System.out.println("4. Mostrar Todos los Empleados");
            System.out.println("5. Buscar Empleados por Apellido");
            System.out.println("6. Ver Salario Medio");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    insertarEmpleado(controlador, scanner);
                    break;
                case 2:
                    actualizarEmpleado(controlador, scanner);
                    break;
                case 3:
                    eliminarEmpleado(controlador, scanner);
                    break;
                case 4:
                    mostrarEmpleados(controlador);
                    break;
                case 5:
                    buscarEmpleadoPorApellido(controlador, scanner);
                    break;
                case 6:
                    mostrarSalarioMedio(controlador);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static void insertarEmpleado(EmpleadoControlador controlador, Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido1: ");
        String apellido1 = scanner.nextLine();
        System.out.print("Apellido2: ");
        String apellido2 = scanner.nextLine();

        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
            String fechaNacimientoStr = scanner.nextLine();
            try {
                fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido.");
            }
        }

        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); 

        Empleado empleado = new Empleado(0, nombre, apellido1, apellido2, fechaNacimiento, salario);
        controlador.agregarEmpleado(empleado);
    }

    private static void actualizarEmpleado(EmpleadoControlador controlador, Scanner scanner) {
        System.out.print("ID del Empleado a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo Apellido1: ");
        String apellido1 = scanner.nextLine();
        System.out.print("Nuevo Apellido2: ");
        String apellido2 = scanner.nextLine();

        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            System.out.print("Nueva Fecha de nacimiento (yyyy-MM-dd): ");
            String fechaNacimientoStr = scanner.nextLine();
            try {
                fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Intentee de nuevo.");
            }
        }

        System.out.print("Nuevo Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Empleado empleado = new Empleado(id, nombre, apellido1, apellido2, fechaNacimiento, salario);
        controlador.actualizarEmpleado(id, empleado);
    }

    private static void eliminarEmpleado(EmpleadoControlador controlador, Scanner scanner) {
        System.out.print("ID del Empleado a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        controlador.eliminarEmpleado(id);
    }

    private static void mostrarEmpleados(EmpleadoControlador controlador) {
        List<Empleado> empleados = controlador.listarEmpleados();
        System.out.println("Lista de Empleados:");
        for (Empleado emp : empleados) {
            System.out.println(emp.getId() + ": " + emp.getNombre() + " " + emp.getApellido1() + " " + emp.getApellido2() +
                               ", Fecha de Nacimiento: " + emp.getFechaNacimiento() + ", Salario: " + emp.getSalario());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }

    private static void buscarEmpleadoPorApellido(EmpleadoControlador controlador, Scanner scanner) {
        System.out.print("Apellido1 a buscar: ");
        String apellido1 = scanner.nextLine();
        List<Empleado> empleados = controlador.buscarEmpleadosPorApellido(apellido1);
        System.out.println("Empleados encontrados:");
        for (Empleado emp : empleados) {
            System.out.println(emp.getId() + ": " + emp.getNombre() + " " + emp.getApellido1() + " " + emp.getApellido2() +
                               ", Fecha de Nacimiento: " + emp.getFechaNacimiento() + ", Salario: " + emp.getSalario());
        }
    }

    private static void mostrarSalarioMedio(EmpleadoControlador controlador) {
        double salarioMedio = controlador.obtenerSalarioMedio();
        System.out.println("El salario medio de los empleados es: " + salarioMedio);
    }
}

