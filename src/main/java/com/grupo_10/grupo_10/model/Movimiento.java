package com.grupo_10.grupo_10.model;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "transacciones")

public class Movimiento {

        //atributos
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id_movimiento;
        @Column(name = "concepto", nullable = false, length = 50) private String concepto;
        @Column(name = "monto", nullable = false, length = 50) private double monto;
        @Column(name = "fecha") private Date fecha;
        @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})  @JoinColumn(name = "id_empleado")  private Empleado empleado;


        public Movimiento() {}

        public Movimiento(Long id, String concepto, double monto, Date fecha, Empleado empleados) {
                this.id_movimiento = id;
                this.concepto = concepto;
                this.monto = monto;
                this.fecha = fecha;
                this.empleado = empleado;
        }

        public Long getId_movimiento() {
                return id_movimiento;
        }

        public void setId_movimiento(Long id_movimiento) {
                this.id_movimiento = id_movimiento;
        }

        public String getConcepto() {
                return concepto;
        }

        public void setConcepto(String concepto) {
                this.concepto = concepto;
        }

        public double getMonto() {
                return monto;
        }

        public void setMonto(double monto) {
                this.monto = monto;
        }

        public Date getFecha() {
                return fecha;
        }

        public void setFecha(Date fecha) {
                this.fecha = fecha;
        }

        public Empleado getEmpleado() {
                return empleado;
        }

        public void setEmpleado(Empleado empleado) {
                this.empleado = empleado;
        }
}