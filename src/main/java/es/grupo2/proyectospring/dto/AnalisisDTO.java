/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.grupo2.proyectospring.dto;
/**
 *
 * @author anton
 */

public class AnalisisDTO{

    
    private Integer id;
    private String nombre;
    private String descripcion;
    private String busqueda;

    public AnalisisDTO() {
    }

    public AnalisisDTO(Integer id) {
        this.id = id;
    }

    public AnalisisDTO(Integer id, String nombre, String busqueda) {
        this.id = id;
        this.nombre = nombre;
        this.busqueda = busqueda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }
}
