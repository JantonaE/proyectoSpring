package es.grupo2.proyectospring.controller;

import es.grupo2.proyectospring.dto.ListaDTO;
import es.grupo2.proyectospring.entity.ListaUsuarios;
import es.grupo2.proyectospring.entity.Marketing;
import es.grupo2.proyectospring.repository.MarketingRepository;
import es.grupo2.proyectospring.service.ListaService;
import es.grupo2.proyectospring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListaCompradoresController {
    private UsuarioService usuarioService;
    private ListaService listaService;
    private MarketingRepository marketingRepository;

    @Autowired
    public void setMarketingRepository(MarketingRepository marketingRepository) {
        this.marketingRepository = marketingRepository;
    }

    @Autowired
    public void setListaService(ListaService listaService) {
        this.listaService = listaService;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/marketing")
    public String showListaCompradores(Model model){
        List<ListaDTO> lista = this.listaService.listarListas();
        ListaDTO listaDTO = null;
        model.addAttribute("listas",lista);
        model.addAttribute("Lista",listaDTO);
        return "ListaUsuariosCompradores";

    }

    @RequestMapping("/marketing/borrar/{id}")
    public String borrarListaCompradores(Model model, @PathVariable("id") int idLista){
        List<ListaDTO> lista = this.listaService.listarListas();
        model.addAttribute("listas",lista);

        this.listaService.borrarLista(idLista);

        return "redirect:/marketing/";

    }

    @PostMapping("/marketing/crear")
    public String crearListaCompradores(@RequestParam("marketingId") int id,@RequestParam("descripcion")
                                        String descripcion,Model model){
        List<ListaDTO> lista = this.listaService.listarListas();
        model.addAttribute("listas",lista);
        Marketing m = this.marketingRepository.findById(id).orElse(null);
        this.listaService.crearLista(descripcion,m,null);
        return "redirect:/marketing/";

    }
}
