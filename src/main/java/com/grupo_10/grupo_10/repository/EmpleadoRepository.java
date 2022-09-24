package com.grupo_10.grupo_10.repository;

import com.grupo_10.grupo_10.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado, Long> {

    @Query(value="SELECT * FROM empleados where id_empresa= ?1", nativeQuery=true)

    List<Empleado> findByEmpresa(Integer id);

}