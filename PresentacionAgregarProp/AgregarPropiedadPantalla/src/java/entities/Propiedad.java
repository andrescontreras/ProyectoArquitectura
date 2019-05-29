/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;

/**
 *
 * @author imroo
 */
public class Propiedad {
    private int id; //int?
    private String nombreOwner;
    private long cedulaOwner;
    private String nombre;
    private String descripcion;
    private String tipoCedula;
    private String tipo;
    private String direccion;
    private String localidad;
    private int numCuartos; //int?
    private int precio;
    private char rentada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_owner() {
        return nombreOwner;
    }

    public void setNombre_owner(String nombre_owner) {
        this.nombreOwner = nombre_owner;
    }

    public long getCedula_owner() {
        return cedulaOwner;
    }

    public void setCedula_owner(long cedula_owner) {
        this.cedulaOwner = cedula_owner;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_cedula() {
        return tipoCedula;
    }

    public void setTipo_cedula(String tipo_cedula) {
        this.tipoCedula = tipo_cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getNum_cuartos() {
        return numCuartos;
    }

    public void setNum_cuartos(int num_cuartos) {
        this.numCuartos = num_cuartos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public char getRentada() {
        return rentada;
    }

    public void setRentada(char rentada) {
        this.rentada = rentada;
    }
    
    
    @Override
    public String toString()
    {
        return "tipo: "+ this.getTipo() + " " + this.getNombre_owner();
    }
}

