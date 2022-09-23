package com.grupo_10.grupo_10.controller;

import com.grupo_10.grupo_10.model.Empleado;
import com.grupo_10.grupo_10.model.Empresa;
import com.grupo_10.grupo_10.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;


    @RequestMapping("/empleados")
    public String viewHomePage (Model model){
        model.addAttribute("ListaEmpleados", empleadoService.getAllEmpleados());
        return "empleados";
    }

    @GetMapping("/nuevoempleado")
    public String newempleado(Model model) {
        Empleado  empleado= new Empleado();
        model.addAttribute("empleado", empleado);
        return "new_empleado";
    }

   @PostMapping("/guardarempleado")
    public String saveEmpleado (@ModelAttribute("empleado") Empleado empleado){
        empleadoService.saveEmpleado(empleado);
        return "redirect:/empleados";
   }
    @GetMapping("/actualizarempleado/{id_empleado}")
   public String updateEmpleado(@PathVariable (value = "id_empleado") Long id_empleado, Model model){
        Empleado empleado = empleadoService.getEmpleadoId(id_empleado);
        model.addAttribute("empleado", empleado );
       return "update_empleado";
   }

    @GetMapping("/eliminarempleado/{id_empleado}")
    public String deleteEmpleado (@PathVariable (value = "id_empleado") Long id, Model model){
        this.empleadoService.deleteEmpleado(id);
        return "redirect:/empleados";
    }

    @RequestMapping("/empleadosempresa/{id}")// Consultar empleados por empresa
    public String EmpleadoPorEmpresa(@PathVariable("id") Integer id, Model model){
        model.addAttribute("ListaEmpleados", empleadoService.obtenerPorEmpresa(id));
        return "empleados";
    }

}