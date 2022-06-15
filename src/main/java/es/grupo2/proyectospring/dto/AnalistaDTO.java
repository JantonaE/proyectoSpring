/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.grupo2.proyectospring.dto;

import java.util.List;

/**
 *
 * @author ruben
 */
public class AnalistaDTO {
    private Integer usuarioId;
    private List<AnalisisDTO> analisisList;
    
    public AnalistaDTO() {
    }

    public AnalistaDTO(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public List<AnalisisDTO> getAnalisisList() {
        return analisisList;
    }

    public void setAnalisisList(List<AnalisisDTO> analisisList) {
        this.analisisList = analisisList;
    }
}
