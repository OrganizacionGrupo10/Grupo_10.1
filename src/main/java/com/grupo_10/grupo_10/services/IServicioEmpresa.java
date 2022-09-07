package com.grupo_10.grupo_10.services;

import java.util.List;

public interface IServicioEmpresa {
    //definimos mensajes(metodos sin cuerpo)
    //get
    public abstract List<Empresa> getAll();

    //post
    public Empresa create (Empresa empresa);

    //get
    public Empresa getById(long id);

    //patch (public boolean puede ser)
    public Empresa update(long id, Empresa empresa);
}
