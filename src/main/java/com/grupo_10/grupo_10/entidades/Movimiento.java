package com.grupo_10.grupo_10.entidades;

import javax.persistence.*;

@Entity
@Table(name = "transacciones")

public class Movimiento {

        //atributos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
        @Column(name = "concepto", nullable = false, length = 50)     private String concepto;
        @Column(name = "monto", nullable = false, length = 50)     private double monto;
        @Column(name = "empleado", nullable = false)     private int empleado;
        @Column(name = "empresa", nullable = false)     private int empresa;

        public Movimiento() {
        }

        public Movimiento(long id, String concepto, double monto, int empleado, int empresa) {
                this.id = id;
                this.concepto = concepto;
                this.monto = monto;
                this.empleado = empleado;
                this.empresa = empresa;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
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

        public int getEmpleado() {
                return empleado;
        }

        public void setEmpleado(int empleado) {
                this.empleado = empleado;
        }

        public int getEmpresa() {
                return empresa;
        }

        public void setEmpresa(int empresa) {
                this.empresa = empresa;
        }
}