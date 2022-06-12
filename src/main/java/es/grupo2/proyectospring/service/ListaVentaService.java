package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.dto.ListaVentaDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.entity.Lista;
import es.grupo2.proyectospring.entity.ListaVenta;
import es.grupo2.proyectospring.entity.ListaVentaPK;
import es.grupo2.proyectospring.entity.Marketing;
import es.grupo2.proyectospring.repository.ListaVentaRepository;
import es.grupo2.proyectospring.repository.ProductoRepository;
import es.grupo2.proyectospring.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaVentaService {

    private ListaVentaRepository listaVentaRepository;
    private VendedorRepository vendedorRepository;
    private ProductoRepository productoRepository;

    @Autowired
    public void setProductoRepository(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @Autowired
    public void setVendedorRepository(VendedorRepository vendedorRepository){
        this.vendedorRepository = vendedorRepository;
    }

    @Autowired
    public void setListaVentaRepository(ListaVentaRepository listaVentaRepository){
        this.listaVentaRepository=listaVentaRepository;
    }



    public void rellenarListaVenta (ListaVentaDTO listaVentaDTO, ListaVenta listaVenta){
        listaVenta.setFecha(listaVentaDTO.getFecha());
        listaVenta.setCompradorId(listaVentaDTO.getCompradorId());
        listaVenta.setVendedorId(listaVentaDTO.getVendedorId());
        listaVenta.setPreciopuja(listaVentaDTO.getPreciopuja());
        listaVenta.setProducto(listaVentaDTO.getProducto());

        listaVenta.setVendedor(vendedorRepository.findById(listaVenta.getVendedorId()).orElse(null));
        listaVenta.setProducto1(productoRepository.findById(listaVenta.getProducto()).orElse(null));

    }


    public void modificarListaVenta (ListaVentaDTO listaVentaDTO) {
        ListaVenta lista = null;
        lista = this.listaVentaRepository.findByVendedorAndProducto(listaVentaDTO.getVendedorId(), listaVentaDTO.getProducto());
        if(lista == null){
            lista = new ListaVenta();
        }
        this.rellenarListaVenta(listaVentaDTO,lista);

        this.listaVentaRepository.save(lista);
    }

    public ListaVentaDTO buscarVenta(int vendedorId, int productoId){
        return this.listaVentaRepository.findByVendedorAndProducto(vendedorId, productoId).toDTO();
    }

}
