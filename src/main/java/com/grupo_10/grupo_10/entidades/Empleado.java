package com.grupo_10.grupo_10.entidades;

import javax.persistence.*;

@Entity
@Table(name = "empleados")

public class Empleado {

        //atributos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
        @Column(name = "nombre", nullable = false, length = 50)     private String nombre;
        @Column(name = "email", nullable = false, length = 50)     private String email;
        @Column(name = "identificacion", nullable = false, length = 50)     private String identificacion;
        @Column(name = "telefono", nullable = false, length = 50)     private String telefono;
        @Column(name = "EmpresaEmpleado", nullable = false)    private int empresa_empleado;
        @Column(name = "RolEmpleado", nullable = false )    private boolean rol_empleado;

        public Empleado() {
        }

        public Empleado(long id, String nombre, String email, String identificacion, String telefono, int empresa_empleado, boolean rol_empleado) {
                this.id = id;
                this.nombre = nombre;
                this.email = email;
                this.identificacion = identificacion;
                this.telefono = telefono;
                this.empresa_empleado = empresa_empleado;
                this.rol_empleado = rol_empleado;
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

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getIdentificacion() {
                return identificacion;
        }

        public void setIdentificacion(String identificacion) {
                this.identificacion = identificacion;
        }

        public String getTelefono() {
                return telefono;
        }

        public void setTelefono(String telefono) {
                this.telefono = telefono;
        }

        public int getEmpresa_empleado() {
                return empresa_empleado;
        }

        public void setEmpresa_empleado(int empresa_empleado) {
                this.empresa_empleado = empresa_empleado;
        }

        public boolean isRol_empleado() {
                return rol_empleado;
        }

        public void setRol_empleado(boolean rol_empleado) {
                this.rol_empleado = rol_empleado;
        }
}