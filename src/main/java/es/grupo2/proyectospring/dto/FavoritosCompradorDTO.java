package es.grupo2.proyectospring.dto;

import es.grupo2.proyectospring.entity.FavoritosComprador;

public class FavoritosCompradorDTO {


    private Integer compradorId;
    private Integer productoId;

    public Integer getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(Integer compradorId) {
        this.compradorId = compradorId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public FavoritosCompradorDTO(){

    }

}
