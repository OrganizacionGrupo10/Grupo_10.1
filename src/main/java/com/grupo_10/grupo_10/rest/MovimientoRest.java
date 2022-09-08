package com.grupo_10.grupo_10.rest;


import com.grupo_10.grupo_10.dao.MovimientoDAO;
import com.grupo_10.grupo_10.entidades.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movements")
public class MovimientoRest {

    @Autowired
    private MovimientoDAO movimientoDAO;

    @GetMapping
    public ResponseEntity<List<Movimiento>> getMovimiento(){
        List<Movimiento> movimientos  = movimientoDAO.findAll();
        return ResponseEntity.ok(movimientos);
    }

    @GetMapping(value = "{movimientoid}")
    public ResponseEntity<Movimiento> getMovimientoByID(@PathVariable("movimientoid") Long movimientoid){
        Optional<Movimiento> optionalMovimiento = movimientoDAO.findById(movimientoid);
        if (((Optional<Movimiento>) optionalMovimiento).isPresent()) {
            return ResponseEntity.ok(((Optional<Movimiento>) optionalMovimiento).get());
        }else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Movimiento> crearmovimiento (@RequestBody Movimiento movement) {
        Movimiento newmovements = movimientoDAO.save(movement);
        return ResponseEntity.ok(newmovements);
    }

    @DeleteMapping(value="{movimientoid}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable("movimientoid") Long movimientoid){
        movimientoDAO.deleteById(movimientoid);
        return ResponseEntity.ok(null);
    }

    @PatchMapping (value="{movimientoid}")
        public ResponseEntity<Movimiento> updatemovimiento(@PathVariable("movimientoid") Long movimientoid, @RequestBody Movimiento movimiento){
            Optional<Movimiento> optionalMovimiento = movimientoDAO.findById(movimientoid);
            if(optionalMovimiento.isPresent()){
                Movimiento updateMovimiento = optionalMovimiento.get();
                updateMovimiento.setConcepto(movimiento.getConcepto());
                updateMovimiento.setMonto(movimiento.getMonto());
                updateMovimiento.setEmpleado(movimiento.getEmpleado());
                updateMovimiento.setEmpresa(movimiento.getEmpresa());
                movimientoDAO.save(updateMovimiento);
                return ResponseEntity.ok(updateMovimiento);
            }else
                return ResponseEntity.notFound().build();
            }

}