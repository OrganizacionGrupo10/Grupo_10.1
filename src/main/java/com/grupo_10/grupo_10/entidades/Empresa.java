package com.grupo_10.grupo_10.entidades;

import javax.persistence.*;

@Entity
@Table(name = "empresas")

public class Empresa {

        //atributos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
        @Column(name = "nombre", nullable = false, length = 50)     private String nombre;
        @Column(name = "nit", nullable = false, length = 50)     private String nit;
        @Column(name = "telefono", nullable = false, length = 50)     private String telefono;
        @Column(name = "direccion", nullable = false, length = 50)     private String direccion;

        public Empresa() {
        }

        public Empresa(long id, String nombre, String nit, String telefono, String direccion) {
                this.id = id;
                this.nombre = nombre;
                this.nit = nit;
                this.telefono = telefono;
                this.direccion = direccion;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
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
}