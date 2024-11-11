package com.empresa.controlador;

import com.empresa.modelo.Empleado;
import com.empresa.repositorio.EmpleadoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
@Api(value = "Empleado API", tags = "Empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @ApiOperation(value = "Obtener todos los empleados", notes = "Devuelve una lista de todos los empleados registrados.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operación exitosa, empleados encontrados"),
        @ApiResponse(code = 500, message = "Error en el servidor")
    })
    @GetMapping
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    @ApiOperation(value = "Obtener un empleado por ID", notes = "Devuelve un empleado basado en su ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Empleado encontrado"),
        @ApiResponse(code = 404, message = "Empleado no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable int id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Crear un nuevo empleado", notes = "Crea un nuevo registro de empleado")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Empleado creado con éxito"),
        @ApiResponse(code = 400, message = "Error en la solicitud, datos inválidos")
    })
    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @ApiOperation(value = "Actualizar un empleado existente", notes = "Actualiza los datos de un empleado basado en su ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Empleado actualizado con éxito"),
        @ApiResponse(code = 404, message = "Empleado no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable int id, @RequestBody Empleado detallesEmpleado) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if (empleadoOptional.isPresent()) {
            Empleado empleado = empleadoOptional.get();
            empleado.setNombre(detallesEmpleado.getNombre());
            empleado.setApellido(detallesEmpleado.getApellido());
            empleado.setEmail(detallesEmpleado.getEmail());
            return ResponseEntity.ok(empleadoRepository.save(empleado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Eliminar un empleado por ID", notes = "Elimina un empleado basado en su ID")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Empleado eliminado con éxito"),
        @ApiResponse(code = 404, message = "Empleado no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable int id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
