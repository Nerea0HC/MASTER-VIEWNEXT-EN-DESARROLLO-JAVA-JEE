package com.curso.service;

import java.util.List;
import com.curso.model.Curso;

public interface CursoService {
    public List<Curso> cursos();
    public Curso buscarCurso(int codCurso);
    public void altaCurso(Curso curso);
    public List<Curso> eliminarCurso(int codCurso);
    public void actualizarDuracion(int codCurso, int duracion);
    public List<Curso> cursosPorPrecio(double precioMin, double precioMax);
}
