package com.grupo_10.grupo_10.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empleados")

public class Empleado {
        //atributos
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id_empleado;
        @Column(name = "nombre", nullable = false, length = 50) private String nombre;
        @Column(name = "email", nullable = false, length = 50) private String email;
        @Column(name = "identificacion", nullable = false, length = 50, unique = true) private Integer identificacion;
        @Column(name = "telefono", nullable = false, length = 50) private String telefono;
        @Column(name = "rol_empleado", nullable = false) private boolean rol_empleado;

        @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})  @JoinColumn(name = "id_empresa")  private Empresa empresa;

        @OneToMany (mappedBy = "empleado", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})  private List<Movimiento> movimientos;

        public Empleado() {
        }

        public Empleado(Long id_empleado, String nombre, String email, Integer identificacion, String telefono, boolean rol_empleado, Empresa empresa) {
                this.id_empleado = id_empleado;
                this.nombre = nombre;
                this.email = email;
                this.identificacion = identificacion;
                this.telefono = telefono;
                this.rol_empleado = rol_empleado;
                this.empresa = empresa;
        }

        public Long getId_empleado() {
                return id_empleado;
        }

        public void setId_empleado(Long id_empleado) {
                this.id_empleado = id_empleado;
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

        public Integer getIdentificacion() {
                return identificacion;
        }

        public void setIdentificacion(Integer identificacion) {
                this.identificacion = identificacion;
        }

        public String getTelefono() {
                return telefono;
        }

        public void setTelefono(String telefono) {
                this.telefono = telefono;
        }

        public boolean isRol_empleado() {
                return rol_empleado;
        }

        public void setRol_empleado(boolean rol_empleado) {
                this.rol_empleado = rol_empleado;
        }

        public Empresa getEmpresa() {
                return empresa;
        }

        public void setEmpresa(Empresa empresa) {
                this.empresa = empresa;
        }

        public List<Movimiento> getMovimientos() {
                return movimientos;
        }

        public void setMovimientos(List<Movimiento> movimientos) {
                this.movimientos = movimientos;
        }
}