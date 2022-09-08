package com.grupo_10.grupo_10.rest;

import com.grupo_10.grupo_10.dao.EmpleadoDAO;
import com.grupo_10.grupo_10.entidades.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class EmpleadoRest {

    @Autowired
    private EmpleadoDAO empleadoDAO;

    @GetMapping
    public ResponseEntity<List<Empleado>> getEmpleados(){
        List<Empleado> empleados = empleadoDAO.findAll();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping(value = "{empleadoid}")
    public ResponseEntity<Empleado> getEmpleadoByID(@PathVariable("empleadoid") Long empleadoid){
        java.util.Optional<Empleado> optionalEmpleado = empleadoDAO.findById(empleadoid);
        if (((java.util.Optional<Empleado>) optionalEmpleado).isPresent()) {
            return ResponseEntity.ok(((java.util.Optional<Empleado>) optionalEmpleado).get());
        }else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Empleado> crearempleado (@RequestBody Empleado empleado) {
        Empleado newempleado = (Empleado) empleadoDAO.save(empleado);
        return ResponseEntity.ok(newempleado);
    }

    @DeleteMapping(value="{empleadoid}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable("empleadoid") Long empleadoid){
        empleadoDAO.deleteById(empleadoid);
        return ResponseEntity.ok(null);
    }

    @PatchMapping (value="{empleadoid}")
        public ResponseEntity<Empleado> updateEmpleado(@PathVariable("empleadoid") Long empleadoid, @RequestBody Empleado empleado){
            Optional<Empleado> optionalEmpleado = empleadoDAO.findById(empleadoid);
            if(optionalEmpleado.isPresent()){
                Empleado updateEmpleado = optionalEmpleado.get();
                updateEmpleado.setNombre(empleado.getNombre());
                updateEmpleado.setEmail(empleado.getEmail());
                updateEmpleado.setIdentificacion(empleado.getIdentificacion());
                updateEmpleado.setTelefono(empleado.getTelefono());
                updateEmpleado.setEmpresa_empleado(empleado.getEmpresa_empleado());
                updateEmpleado.setRol_empleado(empleado.isRol_empleado());
                empleadoDAO.save(updateEmpleado);
                return ResponseEntity.ok(updateEmpleado);
            }else
                return ResponseEntity.notFound().build();
            }

}