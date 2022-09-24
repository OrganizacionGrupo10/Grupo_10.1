package com.grupo_10.grupo_10.service;

import com.grupo_10.grupo_10.model.Empresa;
import com.grupo_10.grupo_10.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired private EmpresaRepository empresaRepository;
    @Override
    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }
    @Override
    public void saveEmpresa(Empresa empresa) {
        this.empresaRepository.save(empresa);
    }
    @Override
    public Empresa getEmpresaId(Long id) {
        Optional<Empresa> optional = empresaRepository.findById(id);
        Empresa empresa = null;
        if (optional.isPresent()) {
            empresa = optional.get();
        } else {
            throw new RuntimeException(" Empresa not found for id :: " + id);
        }
        return empresa;
    }
    @Override
    public void deleteEmpresa(Long id) {
        this.empresaRepository.deleteById(id);
    }
}