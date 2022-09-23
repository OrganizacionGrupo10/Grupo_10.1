package com.grupo_10.grupo_10.model;

import javax.persistence.*;

@Entity
@Table (name = "usuarios")
public class Usuarios {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id_empleado;
    @Column (name="name", unique = true) private String name;
    @Column (name="email", unique = true) private String email;
    @Column (name="imagen") private String imagen;
    @Column (name="auth0_id", unique = true) private String auth0_id;

    public Usuarios() {
    }

    public Usuarios(String name, String email, String imagen, String auth0_id) {
        this.name = name;
        this.email = email;
        this.imagen = imagen;
        this.auth0_id = auth0_id;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAuth0_id() {
        return auth0_id;
    }

    public void setAuth0_id(String auth0_id) {
        this.auth0_id = auth0_id;
    }
}