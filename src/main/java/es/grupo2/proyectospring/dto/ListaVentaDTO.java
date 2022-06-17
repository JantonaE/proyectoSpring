package es.grupo2.proyectospring.dto;

import es.grupo2.proyectospring.entity.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ListaVentaDTO {


    private Integer vendedorId;
    private Integer producto;
    private Integer compradorId;
    private Date fecha;
    private Double preciopuja;
    private Vendedor vendedor;
    private Producto producto1;
    private Comprador comprador;

    public ListaVentaDTO(){}

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

    public Integer getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(Integer compradorId) {
        this.compradorId = compradorId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPreciopuja() {
        return preciopuja;
    }

    public void setPreciopuja(Double preciopuja) {
        this.preciopuja = preciopuja;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }


    public ListaVenta toNormal(){
        ListaVenta l=new ListaVenta();
        l.setVendedorId(this.vendedorId);
        l.setVendedor(this.vendedor);
        l.setComprador(this.comprador);
        l.setPreciopuja(this.preciopuja);
        l.setCompradorId(this.compradorId);
        l.setFecha(this.fecha);
        l.setProducto(this.producto);
        l.setProducto1(this.producto1);

        return l;
    }

}
