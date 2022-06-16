package es.grupo2.proyectospring.service;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
    AUTHOR: Jesús Antona Espejo
*/

import es.grupo2.proyectospring.entity.*;
import es.grupo2.proyectospring.repository.*;

import es.grupo2.proyectospring.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<UsuarioDTO> usuarioEntityADTO (List<Usuario> lista) {
        List<UsuarioDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Usuario u:lista) {
                listaDTO.add(u.toDTO());
            }
        }
        return listaDTO;
    }

    public List<UsuarioDTO> listarListas () {
        List<Usuario> lista = this.usuarioRepository.findAll();

        return this.usuarioEntityADTO(lista);
    }
    public List<UsuarioDTO> findBySexo(String sexo) {
        List<UsuarioDTO> listaDTO = usuarioEntityADTO(this.usuarioRepository.findBySexo(sexo));
        return listaDTO;
    }

    public List<UsuarioDTO> findByCiudad(String ciudad) {
        List<UsuarioDTO> listaDTO = usuarioEntityADTO(this.usuarioRepository.findByCiudad(ciudad));

        return listaDTO;
    }

    public List<UsuarioDTO> findByCiudadSexo(String ciudad,String x) {
        List<UsuarioDTO> listaDTO = usuarioEntityADTO(this.usuarioRepository.findByCiudadSexo(ciudad,x));

        return listaDTO;
    }


    public List<UsuarioDTO> findByEdadMinMax(int min,int max) {
        List<UsuarioDTO> listaDTO =
                usuarioEntityADTO(this.usuarioRepository.findByEdadMinMax(min, max));
        return listaDTO;
    }
/*
    public List<UsuarioDTO> findByEdadMinMaxSex(int min,int max,String x) {
        List<UsuarioDTO> listaDTO =
                usuarioEntityADTO(this.usuarioRepository.findByEdadMinMaxSexo(min, max,x));
        return listaDTO;
    }

    public List<UsuarioDTO> findByEdadMinMaxCiudad(int min,int max,String ciudad) {
        List<UsuarioDTO> listaDTO =
                usuarioEntityADTO(this.usuarioRepository.findByEdadMinMaxCiudad(min, max,ciudad));
        return listaDTO;
    }

    public List<UsuarioDTO> findByEdadMinMaxSexoCiudad(int min,int max,String x,String ciudad) {
        List<UsuarioDTO> listaDTO =
                usuarioEntityADTO(this.usuarioRepository.findByEdadMinMaxSexoCiudad(min, max,x,ciudad));
        return listaDTO;
    }

 */

    public List<UsuarioDTO> findByEdadMin(int min) {
        List<UsuarioDTO> listaDTO = usuarioEntityADTO(this.usuarioRepository.findByEdadMin(min));
        return listaDTO;
    }

    public List<UsuarioDTO> findByEdadMax(int max) {
        List<UsuarioDTO> listaDTO = usuarioEntityADTO(this.usuarioRepository.findByEdadMax(max));
        return listaDTO;
    }


    public UsuarioDTO buscarUsuario (long id) {
        Usuario u = this.usuarioRepository.findById((int) id).orElse(null);
        return u.toDTO();
    }

    public void borrarUsuario (long id) {
        Usuario u = this.usuarioRepository.findById((int) id).orElse(null);
        this.usuarioRepository.delete(u);
    }


    private void rellenarUsuario (Usuario u, String nombre, String apellidos, String domicilio, String ciudad,
                                  int edad, List<Lista> listaList, Marketing marketing, Administrador administrador,
                                  Vendedor vendedor, Analista analista, Comprador comprador) {
        u.setAdministrador(administrador);
        u.setAnalista(analista);
        u.setApellidos(apellidos);
        u.setCiudad(ciudad);
        u.setComprador(comprador);
        u.setDomicilio(domicilio);
        u.setEdad(edad);
        //u.setListaList(listaList);
        u.setMarketing(marketing);
        u.setNombre(nombre);
        u.setSexo(ciudad);
        u.setVendedor(vendedor);
        this.usuarioRepository.save(u);
    }

    public void crearUsuario (String nombre,String apellidos,String domicilio,String ciudad,
                              int edad,List<Lista> listaList,Marketing marketing,Administrador administrador,
                              Vendedor vendedor,Analista analista,Comprador comprador) {
        Usuario u = new Usuario();

        this.rellenarUsuario(u,nombre,apellidos,domicilio,ciudad,
                edad,listaList,marketing,administrador,
                vendedor,analista,comprador);

        this.usuarioRepository.save(u);
    }

    public void modificarUsuario(long id,String nombre,String apellidos,String domicilio,String ciudad,
                                 int edad,List<Lista> listaList,Marketing marketing,Administrador administrador,
                                 Vendedor vendedor,Analista analista,Comprador comprador) {
        Usuario u = this.usuarioRepository.findById((int) id).orElse(null);

        this.rellenarUsuario(u , nombre, apellidos, domicilio, ciudad, edad, listaList, marketing, administrador, vendedor, analista, comprador);

        this.usuarioRepository.save(u);
    }



}


