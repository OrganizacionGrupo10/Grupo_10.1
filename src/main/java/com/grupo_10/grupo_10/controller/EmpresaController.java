package com.grupo_10.grupo_10.controller;

import com.grupo_10.grupo_10.model.Empresa;
import com.grupo_10.grupo_10.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;


    @RequestMapping("/empresas")
    public String viewHomePage (Model model){
        model.addAttribute("ListaEmpresas", empresaService.getAllEmpresas());
        return "empresas";
    }

    @GetMapping("/nuevaempresa")
    public String newempresa(Model model) {
        Empresa empresa = new Empresa();
        model.addAttribute("empresa", empresa);
        return "new_empresa";
    }

   @PostMapping("/guardarempresa")
    public String saveEmpresa (@ModelAttribute("empresa") Empresa empresa){
        empresaService.saveEmpresa(empresa);
        return "redirect:/empresas";
   }
    @GetMapping("/actualizarempresa/{id}")
   public String updateEmpresa(@PathVariable (value = "id") Long id, Model model){
        Empresa empresa = empresaService.getEmpresaId(id);
        model.addAttribute("empresa", empresa);
       return "update_empresa";
   }

    @GetMapping("/eliminarempresa/{id}")
    public String deleteEmpresa (@PathVariable (value = "id") Long id, Model model){
        this.empresaService.deleteEmpresa(id);
        return "redirect:/empresas";
    }

}