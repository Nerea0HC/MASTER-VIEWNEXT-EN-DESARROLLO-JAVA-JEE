package com.curso.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.curso.model.Curso;
import com.curso.service.CursoService;

@RestController
@RequestMapping("cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> cursos() {
        return cursoService.cursos();
    }

    @GetMapping(value = "/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso buscarCurso(@PathVariable int codCurso) {
        return cursoService.buscarCurso(codCurso);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> altaCurso(@RequestBody Curso curso) {
        cursoService.altaCurso(curso);
        return cursoService.cursos();
    }

    @DeleteMapping(value = "/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> eliminarCurso(@PathVariable int codCurso) {
        return cursoService.eliminarCurso(codCurso);
    }

    @PutMapping(value = "/{codCurso}/{duracion}")
    public void actualizarDuracion(@PathVariable int codCurso, @PathVariable int duracion) {
        cursoService.actualizarDuracion(codCurso, duracion);
    }

    @GetMapping(value = "/precio/{precioMin}/{precioMax}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> cursosPorPrecio(@PathVariable double precioMin, @PathVariable double precioMax) {
        return cursoService.cursosPorPrecio(precioMin, precioMax);
    }
}
