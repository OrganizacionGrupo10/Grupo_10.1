package com.grupo_10.grupo_10.service;

import com.grupo_10.grupo_10.model.Movimiento;

import java.util.ArrayList;
import java.util.List;

//@Service
public interface MovimientoService {

    List<Movimiento> getAllMovimientos ();
    void saveMovimiento (Movimiento movimiento);
    Movimiento getMovimientoId (Long id_movimiento);
    void deleteMovimiento (Long id_movimiento);
    List<Movimiento> obtenerPorEmpleado(Integer id);
    List<Movimiento> obtenerPorEmpresa(Integer id);
    Long SumaMontosEmpresa(Integer id);
    Long SumaMontos();
}