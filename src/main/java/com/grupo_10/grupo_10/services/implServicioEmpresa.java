package com.grupo_10.grupo_10.services;

import com.grupo_10.grupo_10.entities.Empresa;
import com.grupo_10.grupo_10.repositories.IRepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class implServicioEmpresa implements IServicioEmpresa{
    //Inyecta dependencias
    @Autowired
    IRepositoryEmpresa repositoryEmpresa;
    @Override
    public List<Empresa> getAll() {
        return (List<Empresa>) repositoryEmpresa.findAll();
    }

    @Override
    public Empresa create(Empresa empresa) {
        Empresa auxEmpresa=empresa;
        return repositoryEmpresa.save(auxEmpresa);
    }

    @Override
    public Empresa getById(long id) {
        Empresa empresa = repositoryEmpresa.findById(id).orElse(null);
        return empresa;

    }

    @Override
    public Empresa update(long id, Empresa empresa) {
        Empresa auxempresa=repositoryEmpresa.findById(id).orElse(null);
        auxempresa.SetId(empresa.getId());
        auxempresa.setNit(empresa.getNit());
        auxempresa.SetUsuarios(empresa.getUsuarios());
        repositoryEmpresa.save(auxEmpresa);
        return auxempresa;

    }
    @Override
    public boolean deleat (long id) {
        Empresa auxempresa=repositoryEmpresa.findById(id).orElse(null);
        boolean bandera=true;
        if (!auxempresa==null){
            bandera=false;


        }
        repositoryEmpresa.deleteById(id);
        return bandera;
    }
}
