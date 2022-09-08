package com.grupo_10.grupo_10.dao;


import com.grupo_10.grupo_10.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpresaDAO extends JpaRepository <Empresa, Long> { }