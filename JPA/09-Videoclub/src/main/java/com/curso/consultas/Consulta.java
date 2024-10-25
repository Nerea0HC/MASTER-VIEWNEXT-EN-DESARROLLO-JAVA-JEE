package com.curso.consultas;

import java.util.List;

import com.curso.model.Pelicula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Consulta {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");
	private EntityManager em;
	private TypedQuery<Pelicula> peli;
	
	public List<Pelicula>buscarTodos(){
		em = emf.createEntityManager();
		peli = em.createNamedQuery("Pelicula.buscarTodas", Pelicula.class);
		return peli.getResultList();
	}
	
	public List<Pelicula> buscarCosme() {
		em = emf.createEntityManager();
		peli = em.createNamedQuery("Pelicula.buscarCosme", Pelicula.class);
		return peli.getResultList();
	}
	

    // Buscar películas donde el nombre del director empieza por 'M'
    public List<Pelicula> buscarDirectorInicialM() {
        em = emf.createEntityManager();
        peli = em.createNamedQuery("Pelicula.buscarPorDirectorInicialM", Pelicula.class);
        return peli.getResultList();
    }

    // Buscar películas donde la directora es Ana o Eva
    public List<Pelicula> buscarDirectorasAnaOEva() {
        em = emf.createEntityManager();
        peli = em.createNamedQuery("Pelicula.buscarDirectorasAnaOEva", Pelicula.class);
        return peli.getResultList();
    }

    // Mostrar sólo los nombres de los directores
    public List<String> buscarSoloDirectores() {
        em = emf.createEntityManager();
        TypedQuery<String> directores = em.createNamedQuery("Pelicula.buscarSoloDirectores", String.class);
        return directores.getResultList();
    }

    // Buscar películas cuyo precio es mayor que 20 y menor que 55
    public List<Pelicula> buscarPorPrecio() {
        em = emf.createEntityManager();
        peli = em.createNamedQuery("Pelicula.buscarPorPrecio", Pelicula.class);
        return peli.getResultList();
    }

    // Mostrar la cantidad de películas por precio de alquiler
    public List<Object[]> cantidadPorPrecio() {
        em = emf.createEntityManager();
        TypedQuery<Object[]> query = em.createNamedQuery("Pelicula.cantidadPorPrecio", Object[].class);
        return query.getResultList();
    }
}
