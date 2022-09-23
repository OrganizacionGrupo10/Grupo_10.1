package com.grupo_10.grupo_10.service;

import com.grupo_10.grupo_10.model.Empresa;

import java.util.List;

//@Service
public interface EmpresaService {

    List<Empresa> getAllEmpresas ();
    void saveEmpresa(Empresa empresa);
    Empresa getEmpresaId (Long id);
    void deleteEmpresa (Long id);
}