package es.grupo2.proyectospring.dto;

public class ListaVentaPKDTO {


    private Integer vendedorId;
    private Integer producto;

    public Integer getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Integer vendedorId) {
        this.vendedorId = vendedorId;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }
}
