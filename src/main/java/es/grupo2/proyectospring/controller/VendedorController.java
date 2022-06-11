package es.grupo2.proyectospring.controller;


import es.grupo2.proyectospring.entity.ListaVenta;
import es.grupo2.proyectospring.repository.ListaVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VendedorController {



    private ListaVentaRepository listaVentaRepository;


    @Autowired
    public void setListaVentaRepository(ListaVentaRepository listaVentaRepository) {
        this.listaVentaRepository = listaVentaRepository;
    }


    @RequestMapping("/vendedor/{id}")
    public String doMostrarProductosVendedor(Model model, @PathVariable("id") int id){

        List<ListaVenta> listaVentaList = this.listaVentaRepository.findListaVentaByVendedorId(id);

        model.addAttribute("listaventa", listaVentaList);


        return "listaventa";

    }


}
