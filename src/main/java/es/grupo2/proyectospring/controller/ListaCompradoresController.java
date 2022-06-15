package es.grupo2.proyectospring.controller;

import es.grupo2.proyectospring.dto.ListaDTO;
import es.grupo2.proyectospring.dto.MarketingDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.entity.ListaUsuarios;
import es.grupo2.proyectospring.entity.Marketing;
import es.grupo2.proyectospring.entity.Usuario;
import es.grupo2.proyectospring.repository.ListaUsuariosRepository;
import es.grupo2.proyectospring.repository.MarketingRepository;
import es.grupo2.proyectospring.service.ListaService;
import es.grupo2.proyectospring.service.ListaUsuariosService;
import es.grupo2.proyectospring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
    AUTHOR: Jesús Antona Espejo
*/
@Controller
public class ListaCompradoresController {
    private UsuarioService usuarioService;
    private ListaService listaService;
    private MarketingRepository marketingRepository;
    private ListaUsuariosRepository listaUsuariosRepository;
    private ListaUsuariosService listaUsuariosService;

    @Autowired
    public void setListaUsuariosService(ListaUsuariosService listaUsuariosService) {
        this.listaUsuariosService = listaUsuariosService;
    }

    @Autowired
    public void setListaUsuariosRepository(ListaUsuariosRepository listaUsuariosRepository) {
        this.listaUsuariosRepository = listaUsuariosRepository;
    }

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

    @RequestMapping("/marketing/editar/{id}")
    public String editarListaCompradores(Model model, @PathVariable("id") int idLista){
        ListaDTO lista = this.listaService.buscarLista(idLista);
        model.addAttribute("lista",lista);

        List<ListaUsuarios> lu = this.listaUsuariosRepository.findListaUsuariosByIDlista(idLista);
        List<UsuarioDTO> users = new ArrayList<>();
        for(ListaUsuarios u : lu){
            users.add(this.usuarioService.buscarUsuario(u.getUsuarioId()));
        }

        model.addAttribute("usuarios",users);

        return "DatosListaCompradores";

    }

    @RequestMapping ("/marketing/listaUsuariosADD")
    public String addUsuariosListaCompradores(Model model, @RequestParam(value = "idLista") int idLista,@RequestParam(value = "ciudad",required = false) String ciudad,
                                              @RequestParam(value = "sexo",required = false) String sexo,@RequestParam(value = "edadMin",required = false) String edadMin,
                                              @RequestParam(value = "edadMax",required = false) String edadMax){
        List<ListaUsuarios> lista = this.listaUsuariosRepository.findListaUsuariosByIDlista(idLista);
        List<UsuarioDTO> listaU = null;

        if(!"".equals(sexo) || sexo == null){
            listaU = this.usuarioService.findBySexo(sexo);
        }
        if(!"".equals(ciudad) || ciudad == null){
            if(listaU == null || !listaU.isEmpty()){
                listaU = this.usuarioService.findByCiudad(ciudad);
            }else{
                List<UsuarioDTO> nueva = this.usuarioService.findByCiudad(ciudad);
                listaU.stream().filter(nueva :: contains).collect(Collectors.toList());
            }
        }
        if((!"".equals(edadMin) && !"".equals(edadMax))){ //||(edadMax == "" && edadMin == ""
            if(listaU == null || !listaU.isEmpty()){
                listaU = this.usuarioService.findByEdadMinMax(Integer.parseInt(edadMin), Integer.parseInt(edadMax));
            }else{
                List<UsuarioDTO> nueva = this.usuarioService.findByEdadMinMax(Integer.parseInt(edadMin),Integer.parseInt(edadMax));
                listaU.stream().filter(nueva :: contains).collect(Collectors.toList());
            }

        }else if(!"".equals(edadMin)){ // || edadMin == ""
            if(listaU == null || !listaU.isEmpty()){
                listaU = this.usuarioService.findByEdadMin(Integer.parseInt(edadMin));
            }else{
                List<UsuarioDTO> nueva = this.usuarioService.findByEdadMin(Integer.parseInt(edadMin));
                listaU.stream().filter(nueva :: contains).collect(Collectors.toList());
            }

        }else if(!"".equals(edadMax)){ // || edadMax == ""
            if(listaU == null || !listaU.isEmpty()){
                listaU =this.usuarioService.findByEdadMax(Integer.parseInt(edadMax));
            }else{
                List<UsuarioDTO> nueva = this.usuarioService.findByEdadMax(Integer.parseInt(edadMax));
                listaU.stream().filter(nueva :: contains).collect(Collectors.toList());
            }

        }

        for(UsuarioDTO user: listaU){
            if(!lista.contains(user)){
                this.listaUsuariosService.crearListaUsuarios(idLista, Math.toIntExact(user.getId()));
            }
        }


        return "redirect:/marketing/editar/"+idLista;

    }

    @RequestMapping("/marketing/UsuarioListaBorrar/{id}/{u}")
    public String borrarUsuarioLista(Model model, @PathVariable("id") int idLista,@PathVariable("u") int idUsuario){
        List<ListaDTO> lista = this.listaService.listarListas();
        model.addAttribute("listas",lista);

        this.listaUsuariosService.borrarUsuarioLista(idLista,idUsuario);

        return "redirect:/marketing/editar/"+idLista;

    }

}
