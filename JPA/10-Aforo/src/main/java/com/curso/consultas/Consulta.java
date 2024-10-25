package com.curso.consultas;

import java.util.List;

import com.curso.model.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Consulta {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("10-aforo");
    private EntityManager em;

    // Mostrar todas las personas
    public List<Persona> buscarTodas() {
        em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createNamedQuery("Persona.buscarTodas", Persona.class);
        return query.getResultList();
    }
    
    // Buscar por ID
    public Persona buscarPorId(int id) {
        em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createNamedQuery("Persona.buscarPorId", Persona.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    // Buscar por apellido1
    public List<Persona> buscarPorApellido1(String apellido1) {
        em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createNamedQuery("Persona.buscarPorApellido1", Persona.class);
        query.setParameter("apellido1", apellido1);
        return query.getResultList();
    }

    // Buscar por apellido1 y apellido2
    public List<Persona> buscarPorApellido1YApellido2(String apellido1, String apellido2) {
        em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createNamedQuery("Persona.buscarPorApellido1YApellido2", Persona.class);
        query.setParameter("apellido1", apellido1);
        query.setParameter("apellido2", apellido2);
        return query.getResultList();
    }
}
