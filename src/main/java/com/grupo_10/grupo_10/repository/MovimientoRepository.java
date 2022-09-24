package com.grupo_10.grupo_10.repository;

import com.grupo_10.grupo_10.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovimientoRepository extends JpaRepository <Movimiento, Long> {

    //Metodo para filtrar movimientos por empleado
    @Query(value ="select * from transacciones where id_empleado= ?1", nativeQuery = true)
    List<Movimiento> findByEmpleado(Integer id);

    //Metodo para filtrar movimientos por empresa
    @Query(value="select * from transacciones where id_empleado in (select id_empleado from empleados where id_empresa= ?1)", nativeQuery = true)
    List<Movimiento> findByEmpresa(Integer id);

    //Metodo para sumar  movimientos por empresa
    @Query(value="select SUM(monto) from transacciones where id_empleado in (select id_empleado from empleados where id_empresa= ?1)", nativeQuery = true)
    Long SumaMontosEmpresa(Integer id);

    @Query(value="select SUM(monto) from transacciones", nativeQuery = true)
    Long SumaMontos();
}