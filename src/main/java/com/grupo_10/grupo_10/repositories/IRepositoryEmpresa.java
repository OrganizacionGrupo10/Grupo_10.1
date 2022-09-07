package com.grupo_10.grupo_10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IRepositoryEmpresa extends JpaRepository {
    @Query(value ="select = from Empresa", nativeQuery = true)
    public abstract ArrayList<Empresa> findAll();
}
