package com.grupo_10.grupo_10.controller;

import com.grupo_10.grupo_10.model.Movimiento;
import com.grupo_10.grupo_10.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;


    @RequestMapping("/movimientos")
    public String viewHomePage (Model model){
        model.addAttribute("ListaMovimientos", movimientoService.getAllMovimientos());
        Long TotalEmpresa = movimientoService.SumaMontos();
        model.addAttribute("totalmovimientos", TotalEmpresa);
        return "movimientos";
    }

    @GetMapping("/nuevomovimiento")
    public String newMovimiento(Model model) {
        Movimiento movimiento = new Movimiento();
        model.addAttribute("movimiento", movimiento);
        return "new_movimiento";
    }

   @PostMapping("/guardarmovimiento")
    public String saveMovimiento (@ModelAttribute("movimiento") Movimiento movimiento){
        movimientoService.saveMovimiento(movimiento);
        return "redirect:/movimientos";
   }
    @GetMapping("/actualizarmovimiento/{id_movimiento}")
   public String updateMovimiento(@PathVariable (value = "id_movimiento") Long id_movimiento, Model model){
        Movimiento movimiento = movimientoService.getMovimientoId(id_movimiento);
        model.addAttribute("movimiento", movimiento);
       return "update_movimiento";
   }

    @GetMapping("/eliminarmovimiento/{id_movimiento}")
    public String deleteMovimiento (@PathVariable (value = "id_movimiento") Long id_movimiento, Model model){
        this.movimientoService.deleteMovimiento(id_movimiento);
        return "redirect:/movimientos";
    }

    @RequestMapping("/movimientosempleado/{id}") //Consultar movimientos por id del empleado
    public String movimientosPorEmpleado(@PathVariable("id") Integer id, Model model){
        model.addAttribute("ListaMovimientos", movimientoService.obtenerPorEmpleado(id));
        return "movimientos";
    }

    @RequestMapping("/movimientosempresa/{id}") //Consultar movimientos que pertenecen a una empresa por el id de la empresa
    public String movimientosPorEmpresa(@PathVariable("id") Integer id, Model model){
        model.addAttribute("ListaMovimientos", movimientoService.obtenerPorEmpresa(id));
        Long TotalEmpresa = movimientoService.SumaMontosEmpresa(id);
        model.addAttribute("totalmovimientos", TotalEmpresa);
        return "movimientos";
    }



}