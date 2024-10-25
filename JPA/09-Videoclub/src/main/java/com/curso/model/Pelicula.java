package com.curso.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
@NamedQueries({ 
	@NamedQuery(name = "Pelicula.buscarTodas", query = "SELECT l FROM Pelicula l"),
    @NamedQuery(name = "Pelicula.buscarCosme", query = "SELECT l FROM Pelicula l WHERE l.nomDirector = 'Cosme'"),
    @NamedQuery(name = "Pelicula.buscarPorDirectorInicialM", query = "SELECT l FROM Pelicula l WHERE l.nomDirector LIKE 'M%'"),
    @NamedQuery(name = "Pelicula.buscarDirectorasAnaOEva", query = "SELECT l FROM Pelicula l WHERE l.nomDirector IN ('Ana', 'Eva')"),
    @NamedQuery(name = "Pelicula.buscarSoloDirectores", query = "SELECT DISTINCT l.nomDirector FROM Pelicula l"),
    @NamedQuery(name = "Pelicula.buscarPorPrecio", query = "SELECT l FROM Pelicula l WHERE l.precAlquiler BETWEEN 20 AND 55"),
    @NamedQuery(name = "Pelicula.cantidadPorPrecio", query = "SELECT l.precAlquiler, COUNT(l) FROM Pelicula l GROUP BY l.precAlquiler")
})
public class Pelicula {
	@Id
	private int codigo;
	private String titulo;
	
	@Column(name = "nom_director")
	private String nomDirector;
	
	@Column(name="prec_alquiler")
	private Double precAlquiler;

	public Pelicula() {
		super();
	}

	public Pelicula(int codigo, String titulo, String nomDirector, Double precAlquiler) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.nomDirector = nomDirector;
		this.precAlquiler = precAlquiler;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomDirector() {
		return nomDirector;
	}

	public void setNomDirector(String nomDirector) {
		this.nomDirector = nomDirector;
	}

	public Double getPrecAlquiler() {
		return precAlquiler;
	}

	public void setPrecAlquiler(Double precAlquiler) {
		this.precAlquiler = precAlquiler;
	}

	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", nomDirector=" + nomDirector + ", precAlquiler="
				+ precAlquiler + "]";
	}

}
