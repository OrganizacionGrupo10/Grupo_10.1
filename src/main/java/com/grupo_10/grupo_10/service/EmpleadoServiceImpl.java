package com.grupo_10.grupo_10.service;

import com.grupo_10.grupo_10.model.Empleado;
import com.grupo_10.grupo_10.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired private EmpleadoRepository empleadoRepository;
    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }
    @Override
    public void saveEmpleado(Empleado empleado) {
        this.empleadoRepository.save(empleado);
    }
    @Override
    public Empleado getEmpleadoId(Long id_empleado) {
        Optional<Empleado> optional = empleadoRepository.findById(id_empleado);
        Empleado empleado = null;
        if (optional.isPresent()) {
            empleado = optional.get();
        } else {
            throw new RuntimeException(" Empleado not found for id :: " + id_empleado);
        }
        return empleado;
    }
    @Override
    public void deleteEmpleado(Long id_empleado) {
        this.empleadoRepository.deleteById(id_empleado);
    }

    public List<Empleado> obtenerPorEmpresa(Integer id) {
        return empleadoRepository.findByEmpresa(id);
    }
}