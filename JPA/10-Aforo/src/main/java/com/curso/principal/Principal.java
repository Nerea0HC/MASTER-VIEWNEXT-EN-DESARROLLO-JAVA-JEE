package com.curso.principal;

import java.util.List;
import java.util.Scanner;

import com.curso.consultas.Consulta;
import com.curso.model.Persona;
/**
 * @version 1.0
 * @author Nerea Hernandez Cano
 * */
public class Principal {

	public static void main(String[] args) {
		Consulta consulta = new Consulta();
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		while (continuar) {
			System.out.println("Selecciona una opción de búsqueda:");
			System.out.println("1. Mostrar todas las personas");
			System.out.println("2. Buscar por ID");
			System.out.println("3. Buscar por apellido1");
			System.out.println("4. Buscar por apellido1 y apellido2");
			System.out.println("5. Salir");

			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				// Mostrar todas las personas
				System.out.println("//// Todas las personas ////");
				List<Persona> todasLasPersonas = consulta.buscarTodas();
				for (Persona persona : todasLasPersonas) {
					System.out.println(persona);
				}
				break;

			case 2:
				// Buscar por ID
				System.out.println("Introduce el ID de la persona que quieres buscar:");
				int id = scanner.nextInt();
				scanner.nextLine();
				Persona personaPorId = consulta.buscarPorId(id);
				if (personaPorId != null) {
					System.out.println("Resultado: " + personaPorId);
				} else {
					System.out.println("No se encontró ninguna persona con ese ID.");
				}
				break;

			case 3:
				// Buscar por apellido1
				System.out.println("Introduce el apellido1 para buscar:");
				String apellido1 = scanner.nextLine();
				List<Persona> personasPorApellido1 = consulta.buscarPorApellido1(apellido1);
				if (!personasPorApellido1.isEmpty()) {
					for (Persona p : personasPorApellido1) {
						System.out.println(p);
					}
				} else {
					System.out.println("No se encontraron personas con ese apellido.");
				}
				break;

			case 4:
				// Buscar por apellido1 y apellido2
				System.out.println("Introduce el apellido1:");
				apellido1 = scanner.nextLine();
				System.out.println("Introduce el apellido2:");
				String apellido2 = scanner.nextLine();
				List<Persona> personasPorApellidos = consulta.buscarPorApellido1YApellido2(apellido1, apellido2);
				if (!personasPorApellidos.isEmpty()) {
					for (Persona p : personasPorApellidos) {
						System.out.println(p);
					}
				} else {
					System.out.println("No se encontraron personas con esos apellidos.");
				}
				break;

			case 5:
				continuar = false;
				break;

			default:
				System.out.println("Opción no válida. Selecciona una opción correcta.");
			}
			System.out.println();
		}
		scanner.close();
	}
}
