package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.dto.ListaDTO;
import es.grupo2.proyectospring.dto.ProductoDTO;
import es.grupo2.proyectospring.entity.Lista;
import es.grupo2.proyectospring.entity.Producto;
import es.grupo2.proyectospring.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {


    private ProductoRepository productoRepository;

    @Autowired
    public void setProductoRepository(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    public List<ProductoDTO> listarProductos(){
        List<Producto> productoList = this.productoRepository.findAll();
        System.out.println(productoList.toString());
        List<ProductoDTO> productoDTOS = null;

        if (productoList != null) {
            productoDTOS = new ArrayList<>();
            for (Producto p:productoList) {
                productoDTOS.add(p.toDTO());
            }
        }

        return productoDTOS;
    }

    protected List<ProductoDTO> convertirAListaDTO (List<Producto> lista){
        if (lista != null) {
            List<ProductoDTO> listaDTO = new ArrayList<ProductoDTO>();
            for (Producto pr:lista) {
                listaDTO.add(pr.toDTO());
            }
            return listaDTO;
        } else {
            return null;
        }
    }

    public List<ProductoDTO> listarProductos (String filtroNombre) {
        List<Producto> lista;

        if ((filtroNombre != null && filtroNombre.length()>0 )) {
            lista = this.productoRepository.findByTitulo(filtroNombre);
        } else {  // Quiero mostrar todos
            lista = this.productoRepository.findAll();
        }
        return this.convertirAListaDTO(lista);
    }

    public List<ProductoDTO> listarProductosVacio () {
        return this.listarProductos(null);
    }

    public void borrarProducto (Integer id) {
        Producto pr = this.productoRepository.findById(id).orElse(null);
        this.productoRepository.delete(pr);
    }

    public ProductoDTO buscarProducto (Integer id) {
        Producto pr = this.productoRepository.findById(id).orElse(null);
        if (pr != null) {
            return pr.toDTO();
        } else {
            return null;
        }
    }

    public void guardarProducto(ProductoDTO dto){
        Producto us= new Producto();
        us.setId(dto.getId());
        us.setCategoriaProducto(dto.getCategoriaProducto());
        us.setDescripcion(dto.getDescripcion());
        us.setPrecioSalida(dto.getPrecioSalida());
        us.setTitulo(dto.getTitulo());
        us.setUrlFoto(dto.getUrlFoto());
        this.productoRepository.save(us);
    }



}
