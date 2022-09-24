package com.grupo_10.grupo_10.service;

import com.grupo_10.grupo_10.model.Empleado;

import java.util.ArrayList;
import java.util.List;

//@Service
public interface EmpleadoService {

    List<Empleado> getAllEmpleados ();
    void saveEmpleado(Empleado empleado);
    Empleado getEmpleadoId (Long id_empleado);
    void deleteEmpleado (Long id_empleado);
    List<Empleado> obtenerPorEmpresa(Integer id);
}