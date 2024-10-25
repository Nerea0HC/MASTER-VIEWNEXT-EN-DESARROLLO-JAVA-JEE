package com.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
@NamedQueries({ 
		@NamedQuery(name = "Pelicula.buscarTodas", query = "SELECT l FROM Pelicula l"),
		@NamedQuery(name = "Pelicula.buscarCosme", query = "SELECT l FROM Pelicula l WHERE nom_director = 'Cosme'"),
		@NamedQuery(name = "Pelicula.buscarPorDirectorInicialM", query = "SELECT l FROM Pelicula l WHERE l.nom_director LIKE 'M%'"),
	    @NamedQuery(name = "Pelicula.buscarDirectorasAnaOEva", query = "SELECT l FROM Pelicula l WHERE l.nom_director IN ('Ana', 'Eva')"),
	    @NamedQuery(name = "Pelicula.buscarSoloDirectores", query = "SELECT DISTINCT l.nom_director FROM Pelicula l"),
	    @NamedQuery(name = "Pelicula.buscarPorPrecio", query = "SELECT l FROM Pelicula l WHERE l.prec_alquiler BETWEEN 20 AND 55"),
	    @NamedQuery(name = "Pelicula.cantidadPorPrecio", query = "SELECT l.prec_alquiler, COUNT(l) FROM Pelicula l GROUP BY l.prec_alquiler")
})
public class Pelicula {
	@Id
	private int codigo;
	private String titulo;
	private String nom_director;
	private Double prec_alquiler;

	public Pelicula() {
		super();
	}

	public Pelicula(String titulo, String nom_director, Double prec_alquiler) {
		super();
		this.titulo = titulo;
		this.nom_director = nom_director;
		this.prec_alquiler = prec_alquiler;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNom_director() {
		return nom_director;
	}

	public void setNom_director(String nom_director) {
		this.nom_director = nom_director;
	}

	public Double getPrec_alquiler() {
		return prec_alquiler;
	}

	public void setPrec_alquiler(Double prec_alquiler) {
		this.prec_alquiler = prec_alquiler;
	}

	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", nom_director=" + nom_director
				+ ", prec_alquiler=" + prec_alquiler + "]";
	}

}
