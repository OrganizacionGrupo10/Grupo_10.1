package com.grupo_10.grupo_10.dao;

import com.grupo_10.grupo_10.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoDAO<Long> extends JpaRepository <Empleado, Long> { }