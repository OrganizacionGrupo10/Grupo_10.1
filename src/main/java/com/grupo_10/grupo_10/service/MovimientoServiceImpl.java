package com.grupo_10.grupo_10.service;

import com.grupo_10.grupo_10.model.Empresa;
import com.grupo_10.grupo_10.model.Movimiento;
import com.grupo_10.grupo_10.repository.EmpresaRepository;
import com.grupo_10.grupo_10.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired private MovimientoRepository movimientoRepository;
    @Override
    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll(Sort.by(Sort.Direction.ASC, "fecha"));
    }
    @Override
    public void saveMovimiento(Movimiento movimiento) {
        this.movimientoRepository.save(movimiento);
    }
    @Override
    public Movimiento getMovimientoId(Long id_movimiento) {
        Optional<Movimiento> optional = movimientoRepository.findById(id_movimiento);
        Movimiento movimiento = null;
        if (optional.isPresent()) {
            movimiento = optional.get();
        } else {
            throw new RuntimeException(" Movimiento not found for id :: " + id_movimiento);
        }
        return movimiento;
    }
    @Override
    public void deleteMovimiento(Long id_movimiento) {
        this.movimientoRepository.deleteById(id_movimiento);
    }

    public List<Movimiento> obtenerPorEmpleado(Integer id) { //Obterner teniendo en cuenta el id del empleado
        return movimientoRepository.findByEmpleado(id);
    }

    public List<Movimiento> obtenerPorEmpresa(Integer id) { //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
        return movimientoRepository.findByEmpresa(id);
    }

    public Long SumaMontosEmpresa(Integer id) {
        return movimientoRepository.SumaMontosEmpresa(id);
    }

    public Long SumaMontos(){return movimientoRepository.SumaMontos();}

}