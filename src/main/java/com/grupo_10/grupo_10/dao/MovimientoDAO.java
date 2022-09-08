package com.grupo_10.grupo_10.dao;



import com.grupo_10.grupo_10.entidades.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovimientoDAO extends JpaRepository <Movimiento, Long> { }