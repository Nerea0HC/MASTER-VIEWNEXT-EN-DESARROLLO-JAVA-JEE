package com.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.curso.model.Curso;

@Service
public class CursoServiceImpl implements CursoService {
    private List<Curso> cursos;
    
    public CursoServiceImpl() {
        cursos = new ArrayList<>(List.of(
            new Curso(1, "Matemáticas", 40, 200.0),
            new Curso(2, "Historia", 30, 150.0),
            new Curso(3, "Inglés", 20, 100.0)
        ));
    }
    
    @Override
    public List<Curso> cursos() {
        return cursos;
    }

    @Override
    public Curso buscarCurso(int codCurso) {
        return cursos.stream()
            .filter(curso -> curso.getCodCurso() == codCurso)
            .findFirst()
            .orElse(null);
    }

    @Override
    public void altaCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public List<Curso> eliminarCurso(int codCurso) {
        cursos.removeIf(curso -> curso.getCodCurso() == codCurso);
        return cursos;
    }

    @Override
    public void actualizarDuracion(int codCurso, int duracion) {
        Curso curso = buscarCurso(codCurso);
        if (curso != null) {
            curso.setDuracion(duracion);
        }
    }

    @Override
    public List<Curso> cursosPorPrecio(double precioMin, double precioMax) {
        return cursos.stream()
            .filter(curso -> curso.getPrecio() >= precioMin && curso.getPrecio() <= precioMax)
            .collect(Collectors.toList());
    }
}
