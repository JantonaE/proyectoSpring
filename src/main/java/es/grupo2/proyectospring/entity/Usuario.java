package es.grupo2.proyectospring.entity;

import es.grupo2.proyectospring.dto.ListaDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/*
    AUTHOR: Jesús Antona Espejo
*/
@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;
    @Basic
    @Column(name = "domicilio", nullable = false, length = 50)
    private String domicilio;
    @Basic
    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;
    @Basic
    @Column(name = "edad", nullable = false)
    private Integer edad;
    @Basic
    @Column(name = "sexo", nullable = false)
    private String sexo;
    @Basic
    @Column(name = "contraseña", nullable = false, length = 50)
    private String contraseña;

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(domicilio, usuario.domicilio) && Objects.equals(ciudad, usuario.ciudad) && Objects.equals(edad, usuario.edad) && Objects.equals(sexo, usuario.sexo) && Objects.equals(contraseña, usuario.contraseña);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, domicilio, ciudad, edad, sexo, contraseña);
    }

    public UsuarioDTO toDTO() {
        UsuarioDTO dto = new UsuarioDTO();
        //dto.setAdministrador(administrador.toDTO());
        //dto.setAnalista(analista.toDTO());
        dto.setApellidos(apellidos);
        dto.setCiudad(ciudad);
        //dto.setComprador(comprador.toDTO());
        dto.setDomicilio(domicilio);
        dto.setEdad(edad);
        dto.setId(Long.valueOf(id));
        dto.setContraseña(contraseña);
        //dto.setListaList(listaEntityADTO(listaList));
        //dto.setMarketing(marketing.toDTO());
        dto.setNombre(nombre);
        dto.setSexo(sexo);
        //dto.setVendedor(vendedor.toDTO());
        return dto;
    }

    public List<ListaDTO> listaEntityADTO (List<Lista> lista) {
        List<ListaDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Lista l:lista) {
                listaDTO.add(l.toDTO());
            }
        }
        return listaDTO;
    }


    public void setAdministrador(Administrador administrador) {
    }

    public void setAnalista(Analista analista) {
    }

    public void setComprador(Comprador comprador) {
    }

    public void setVendedor(Vendedor vendedor) {
    }

    public void setMarketing(Marketing marketing) {
    }
}
