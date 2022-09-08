package com.grupo_10.grupo_10.controllers;

import com.grupo_10.grupo_10.entities.Empresa;
import com.grupo_10.grupo_10.services.IServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresas")
public class EmpresaControlador {
    @Autowired
    IServicioEmpresa servicioEmpresa;

    //GET
    @GetMapping(method = RequestMethod.GET, produces = "aplication/json")
    @ResponseBody
    public List<Empresa> findAll(){
        return(List<Empresa>) servicioEmpresa.getAll();
    }

    //POST
    @PostMapping(method = RequestMethod.POST, produces = "aplication/json")
    @ResponseBody
    public Empresa create(@RequestBody Empresa empresa){
        return servicioEmpresa.create(empresa);
    }

    //GET
    @PostMapping(value = "{id}", method = RequestMethod.GET, produces= "aplication/json")
    @ResponseBody
    public Empresa findById(@PathVariable long id){
        Empresa empresa = servicioEmpresa.(findById(id));
        return servicioEmpresa.getById();//revisar
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH, produces= "application/json")
    @ResponseBody
    public Empresa update(@RequestBody Empresa empresa, @PathVariable Lond id) {
        return servicioEmpresa.update(id, empresa);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces= "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id){
        servicioEmpresa.deleteById(id);
    }
