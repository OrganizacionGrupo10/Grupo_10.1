package com.grupo_10.grupo_10.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;


//Anotacion que me permite crear una entidad a base de una clase
@Entity
//Anotcion que permite declarar una tabla a nivel de base de datos
@Table(name="Empresa")
public class Empresa {
    //atributos
    //Anotacion que me permite señalar que el atributo es la llave primaria
    @Id
    //Anotacion que me permite generar un valor al atributo de la llave primaria
    @GeneratedValue(Strategy = GenerationType.AUTO)
    private long id;

    //Representacion llaves foraneas (TRANSACCIONES)
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private ArrayList<Empleado> usuarios;//Mas llaves foraneas?

    //CONSTRUCTORES
    public Empresa(){}

    public Empresa(long id, ArrayList<Empleado> usuarios, String nombreEmpresa, String direccionEmpresa, String telefonoEmpresa, String nitEmpresa) {
        this.id = id;
        this.usuarios = usuarios;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.nitEmpresa = nitEmpresa;
    }

    //METODOS U OPERACIONES getters and setter


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Empleado> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Empleado> usuarios) {
        this.usuarios = usuarios;
    }

    private String nombreEmpresa;
    private String direccionEmpresa;
    private String telefonoEmpresa;
    private String nitEmpresa;

    public Empresa(String nombreEmpresa, String direccionEmpresa, String telefonoEmpresa, String nitEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }
}
