package es.grupo2.proyectospring.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.grupo2.proyectospring.entity.Usuario;

import java.util.List;



/**
 *
 * @author Jesús Antona Espejo
 */
public class UsuarioDTO {

    private Long id;

    private String nombre;

    private String apellidos;

    private String domicilio;

    private String ciudad;

    private int edad;

    private String sexo;

    private List<ListaDTO> listaList;

    private MarketingDTO marketing;
    private String contraseña;


//private AdministradorDTO administrador;

    //private VendedorDTO vendedor;

    //private AnalistaDTO analista;

    //private CompradorDTO comprador;

    public UsuarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<ListaDTO> getListaList() {
        return listaList;
    }

    public void setListaList(List<ListaDTO> listaList) {
        this.listaList = listaList;
    }

    public MarketingDTO getMarketing() {
        return marketing;
    }

    public void setMarketing(MarketingDTO marketing) {
        this.marketing = marketing;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario toNormal(){
        Usuario u= new Usuario();
        u.setNombre(this.nombre);
        u.setApellidos(this.apellidos);
        u.setDomicilio(this.domicilio);
        u.setCiudad(this.ciudad);
        u.setEdad(this.edad);
        u.setSexo(this.sexo);
        u.setContraseña(this.contraseña);

        return u;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioDTO)) {
            return false;
        }
        UsuarioDTO other = (UsuarioDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tawebay.dto.UsuarioDTO[ id=" + id + " ]";
    }



}
