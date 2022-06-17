/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.grupo2.proyectospring.dto;

/**
 *
 * @author ruben
 */
public class CategoriaDTO {
    private int id;
    private String titulo, descripcion;
    
    public CategoriaDTO() {
    }

    public CategoriaDTO(int id) {
        this.id = id;
    }

    public CategoriaDTO(int id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
