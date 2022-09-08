package com.grupo_10.grupo_10.rest;

import com.grupo_10.grupo_10.dao.EmpresaDAO;
import com.grupo_10.grupo_10.entidades.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enterprises")
public class EmpresaRest {

    @Autowired
    private EmpresaDAO empresaDAO;

    @GetMapping
    public ResponseEntity<List<Empresa>> getEmpresa(){
        List<Empresa> empresas  = empresaDAO.findAll();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping(value = "{empresaid}")
    public ResponseEntity<Empresa> getEmpresaByID(@PathVariable("empresaid") Long empresaid){
        Optional<Empresa> optionalEmpresa = empresaDAO.findById(empresaid);
        if (((Optional<Empresa>) optionalEmpresa).isPresent()) {
            return ResponseEntity.ok(((Optional<Empresa>) optionalEmpresa).get());
        }else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Empresa> crearempresa (@RequestBody Empresa empresa) {
        Empresa newempresa = empresaDAO.save(empresa);
        return ResponseEntity.ok(newempresa);
    }

    @DeleteMapping(value="{empresaid}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable("empresaid") Long empresaid){
        empresaDAO.deleteById(empresaid);
        return ResponseEntity.ok(null);
    }

    @PatchMapping (value="{empresaid}")
        public ResponseEntity<Empresa> updateEmpleado(@PathVariable("empresaid") Long empresaid, @RequestBody Empresa empresa){
            Optional<Empresa> optionalEmpresa = empresaDAO.findById(empresaid);
            if(optionalEmpresa.isPresent()){
                Empresa updateEmpresa = optionalEmpresa.get();
                updateEmpresa.setNombre(empresa.getNombre());
                updateEmpresa.setDireccion(empresa.getDireccion());
                updateEmpresa.setNit(empresa.getNit());
                updateEmpresa.setTelefono(empresa.getTelefono());
                empresaDAO.save(updateEmpresa);
                return ResponseEntity.ok(updateEmpresa);
            }else
                return ResponseEntity.notFound().build();
            }

}