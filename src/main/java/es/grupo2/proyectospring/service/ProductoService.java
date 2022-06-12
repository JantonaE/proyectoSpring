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
}
