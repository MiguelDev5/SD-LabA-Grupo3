package com.ocho.miguel.models;

public class Departamento {

    private int idDpto;
    private String nombre;
    private String descripcion;
    private String telefono;
    private String fax;

    public Departamento(int idDpto, String nombre, String descripcion, String telefono, String fax) {
        this.idDpto = idDpto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.fax = fax;
    }

    public int getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(int idDpto) {
        this.idDpto = idDpto;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
