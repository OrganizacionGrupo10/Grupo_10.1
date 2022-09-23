package com.grupo_10.grupo_10.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresas")

public class Empresa {

        //atributos
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id_empresa;
        @Column(name = "nombre", nullable = false, length = 50)     private String nombre;
        @Column(name = "nit", nullable = false, length = 50)     private String nit;
        @Column(name = "telefono", nullable = false, length = 50)     private String telefono;
        @Column(name = "direccion", nullable = false, length = 50)     private String direccion;
        @OneToMany (mappedBy = "empresa", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})  private List<Empleado> empleados;

        public Empresa() {
        }

        public Empresa(String nombre, String nit, String telefono, String direccion) {
                this.nombre = nombre;
                this.nit = nit;
                this.telefono = telefono;
                this.direccion = direccion;
        }

        public Long getId_empresa() {
                return id_empresa;
        }

        public void setId_empresa(Long id_empresa) {
                this.id_empresa = id_empresa;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getNit() {
                return nit;
        }

        public void setNit(String nit) {
                this.nit = nit;
        }

        public String getTelefono() {
                return telefono;
        }

        public void setTelefono(String telefono) {
                this.telefono = telefono;
        }

        public String getDireccion() {
                return direccion;
        }

        public void setDireccion(String direccion) {
                this.direccion = direccion;
        }

        public List<Empleado> getEmpleado() {
                return empleados;
        }

        public void setEmpleado(List<Empleado> empleado) {
                this.empleados = empleados;
        }


}