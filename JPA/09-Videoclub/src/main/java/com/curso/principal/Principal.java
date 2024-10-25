package com.curso.principal;

import com.curso.consultas.Consulta;
import com.curso.model.Pelicula;
/**
 * @version 1.0
 * @author Nerea Hernandez Cano
 * */
public class Principal {

	public static void main(String[] args) {
		Consulta consulta = new Consulta();

		// BUSCAR TODOS
		System.out.println("////TODOS*******************************************************************************************************");
		for (Pelicula peli : consulta.buscarTodos()) {
			System.out.println(peli);
		}
		// BUSCAR COSME
		System.out.println("////Cosme*******************************************************************************************************");
		for (Pelicula peli : consulta.buscarCosme()) {
			System.out.println(peli);
		}
		// BUSCAR DIRECTORES QUE EMPIEZAN POR M
		System.out.println("////Directores que empiezan por M*******************************************************************************");
		for (Pelicula peli : consulta.buscarDirectorInicialM()) {
			System.out.println(peli);
		}

		// BUSCAR PELÍCULAS DE ANA O EVA
		System.out.println("////Directoras Ana o Eva****************************************************************************************");
		for (Pelicula peli : consulta.buscarDirectorasAnaOEva()) {
			System.out.println(peli);
		}

		// MOSTRAR SOLO DIRECTORES
		System.out.println("////Directores**************************************************************************************************");
		for (String director : consulta.buscarSoloDirectores()) {
			System.out.println(director);
		}

		// PELÍCULAS CON PRECIO ENTRE 20 Y 55
		System.out.println("////Películas con precio entre 20 y 55**************************************************************************");
		for (Pelicula peli : consulta.buscarPorPrecio()) {
			System.out.println(peli);
		}
		
		// CANTIDAD DE PELÍCULAS POR PRECIO
		System.out.println("////Cantidad de películas por precio de alquiler****************************************************************");
		for (Object[] result : consulta.cantidadPorPrecio()) {
			System.out.println("Precio: " + result[0] + " - Cantidad: " + result[1]);
		}
	}
}
