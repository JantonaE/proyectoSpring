package es.grupo2.proyectospring.dto;

import java.math.BigDecimal;

public class ProductoDTO {

    private Integer id;

    private String titulo;

    private String descripcion;

    private BigDecimal precioSalida;

    private String urlFoto;

    private Integer categoriaProducto;

    public ProductoDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public BigDecimal getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(BigDecimal precioSalida) {
        this.precioSalida = precioSalida;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public Integer getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(Integer categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
