package es.grupo2.proyectospring.controller;


import es.grupo2.proyectospring.dto.ListaVentaDTO;
import es.grupo2.proyectospring.dto.ProductoDTO;
import es.grupo2.proyectospring.dto.VendedorDTO;
import es.grupo2.proyectospring.entity.ListaVenta;
import es.grupo2.proyectospring.repository.ListaVentaRepository;
import es.grupo2.proyectospring.repository.ProductoRepository;
import es.grupo2.proyectospring.service.ListaVentaService;
import es.grupo2.proyectospring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VendedorController {



    private ListaVentaRepository listaVentaRepository;
    private ProductoRepository productoRepository;

    private ListaVentaService listaVentaService;

    private ProductoService productoService;

    @Autowired
    public void setListaVentaService(ListaVentaService listaVentaService){
        this.listaVentaService = listaVentaService;
    }

    @Autowired
    public void setProductoService(ProductoService productoService){
        this.productoService = productoService;
    }

    @Autowired
    public void setProductoRepository(ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
    }

    @Autowired
    public void setListaVentaRepository(ListaVentaRepository listaVentaRepository) {
        this.listaVentaRepository = listaVentaRepository;
    }


    @RequestMapping("/vendedor/{id}")
    public String doMostrarProductosVendedor(Model model, @PathVariable("id") int id){

        List<ListaVentaDTO> listaVentaDTOList = this.listaVentaService.findListaVentaByVendedorId(id);
        for(ListaVentaDTO lv : listaVentaDTOList){
            System.out.println(lv.getProducto());
        }

        model.addAttribute("vendedor", id);
        model.addAttribute("listaventa", listaVentaDTOList);
        return "listaventa";

    }

    @PostMapping("/vendedor/filtrar")
    public String doMostrarProductosVendedorFiltrado(Model model, @RequestParam("producto") String producto,
                                                     @RequestParam("comprador") String comprador,
                                                     @RequestParam("precio") int precio,
                                                     @RequestParam("vendedor") int vendedor){
        if(precio == 0)precio = Integer.MAX_VALUE;
        List<ListaVentaDTO> listaVentaDTOS = new ArrayList<>();
        if(producto != null){
            listaVentaDTOS = this.listaVentaService.filtroProducto(precio,producto);
            if(listaVentaDTOS.isEmpty()) return "redirect:/vendedor/"  + vendedor;
        }else if(comprador == ""){
            comprador = null;
        }


        listaVentaDTOS = this.listaVentaService.filtrar(precio,comprador,producto);
        if(listaVentaDTOS.isEmpty()) return "redirect:/vendedor/"  + vendedor;
        model.addAttribute("listaventa", listaVentaDTOS);
        model.addAttribute("vendedor", vendedor);

        return "listaventa";

    }

    private void anadirProductosPrincipal (Model model) {
        List<ProductoDTO> productoDTOS = productoService.listarProductos();
        model.addAttribute("productos", productoDTOS);
    }


    @GetMapping("/vendedor/{id}/nuevo")
    public String doCrearNuevaVenta(Model model, @PathVariable("id") int id){

        ListaVentaDTO listaVentaDTO = new ListaVentaDTO();
        model.addAttribute("listaVentaDTO", listaVentaDTO);
        listaVentaDTO.setVendedorId(id);
        this.anadirProductosPrincipal(model);
        return "listaventaNuevo";
    }

    @GetMapping("/vendedor/{vendedorId}/{productoId}/edit")
    public String doEditar (@PathVariable("vendedorId") int vendedorId,@PathVariable("productoId") int productoId,
                            Model model) {
        ListaVentaDTO listaVentaDTO = this.listaVentaService.buscarVenta(vendedorId, productoId);
        model.addAttribute("listaVentaDTO", listaVentaDTO);
        this.anadirProductosPrincipal(model);
        return "listaventaNuevo";
    }


    @PostMapping("/vendedor/guardar")
    public String doGuardar (@ModelAttribute("listaVentaDTO") ListaVentaDTO listaVentaDTO) {
        this.listaVentaService.modificarListaVenta(listaVentaDTO);

        return "redirect:/vendedor/"  + listaVentaDTO.getVendedorId();
    }
}
