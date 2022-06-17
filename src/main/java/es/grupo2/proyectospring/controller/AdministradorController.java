package es.grupo2.proyectospring.controller;


import es.grupo2.proyectospring.repository.AnalistaRepository;
import es.grupo2.proyectospring.dto.*;
import es.grupo2.proyectospring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
    private UsuarioService usuarioService;
    private ProductoService productoService;
    private CategoriaService categoriaService;
    private MarketingService marketingService;
    private AnalistaService analistaService;

    public UsuarioService getUsuarioService(){return usuarioService;}
    @Autowired
    public void setUsuarioService(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public ProductoService getProductoService(){return productoService;}
    @Autowired
    public void setProductoService(ProductoService productoService){
        this.productoService = productoService;
    }

    public CategoriaService getCategoriaService(){return categoriaService;}
    @Autowired
    public void setCategoriaService(CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }

    public MarketingService getMarketingService(){return marketingService;}
    @Autowired
    public void setMarketingService(MarketingService marketingService){
        this.marketingService=marketingService;
    }

    public AnalistaService getAnalistaService(){return analistaService;}
    @Autowired
    public void setAnalistaService(AnalistaService analistaService){
        this.analistaService = analistaService;
    }

    @GetMapping("")
    public String getInfo(Model model){
        List<UsuarioDTO> listaUs = this.usuarioService.listarUsuarios(null);
        List<ProductoDTO> listaPr = this.productoService.listarProductos();
        List<CategoriaDTO> listaCa = this.categoriaService.listarCategorias();
        List<UsuarioDTO> listaMa = this.marketingService.listarMarketing();
        List<UsuarioDTO> listaAn = this.analistaService.listarAnalistas();
        model.addAttribute("productos",listaPr);
        model.addAttribute("usuarios",listaUs);
        model.addAttribute("categorias",listaCa);
        model.addAttribute("marketing",listaMa);
        model.addAttribute("analistas",listaAn);
        return "administrador";
    }

    @PostMapping("")
    public String getFiltros(Model model, @RequestParam("filtroUs") String filtroUs, @RequestParam("filtroCategoria") String filtroCa,
                             @RequestParam("filtroProducto") String filtroPr){
        List<UsuarioDTO> listaUs = this.usuarioService.listarUsuarios(filtroUs);
        List<ProductoDTO> listaPr = this.productoService.listarProductos(filtroPr);
        List<CategoriaDTO> listaCa = this.categoriaService.listarCategorias(filtroCa);
        List<UsuarioDTO> listaMa = this.marketingService.listarMarketing();
        List<UsuarioDTO> listaAn = this.analistaService.listarAnalistas();
        model.addAttribute("productos",listaPr);
        model.addAttribute("usuarios",listaUs);
        model.addAttribute("categorias",listaCa);
        model.addAttribute("marketing",listaMa);
        model.addAttribute("analistas",listaAn);
        return "administrador";
    }

    @GetMapping("/borrarUs/{id}")
    public String borrarUs(Model model, @PathVariable("id") Integer id){
        this.usuarioService.borrarUsuario(id);
        return "redirect:/administrador";
    }

    @GetMapping("/nuevoUs")
    public String nuevoUs(Model model){
        UsuarioDTO us = new UsuarioDTO();
        model.addAttribute("usuario",us);
        return "usuario";
    }

    @PostMapping("/nuevoUs")
    public String crearUs(@ModelAttribute("usuario") UsuarioDTO us){
        this.usuarioService.guardarUsuario(us);
        return "redirect:/administrador";
    }

    @GetMapping("/editarUs/{id}")
    public String editarUs(Model model, @PathVariable("id") Integer id){
        UsuarioDTO us = this.usuarioService.buscarUsuario(id);
        model.addAttribute("usuario", us);
        return "usuario";
    }

    @PostMapping("/editarUs/{id}")
    public String guardarUs(Model model, @RequestParam("usuario") UsuarioDTO us){
        this.usuarioService.guardarUsuario(us);
        return "redirect:/administrador";
    }

    @GetMapping("/borrarPr/{id}")
    public String borrarPr(Model model, @PathVariable("id") Integer id){
        this.productoService.borrarProducto(id);
        return "redirect:/administrador";
    }

    @GetMapping("/nuevoPr")
    public String nuevoPr(Model model){
        ProductoDTO pr = new ProductoDTO();
        model.addAttribute("producto",pr);
        return "producto";
    }

    @PostMapping("/nuevoPr")
    public String crearPr(@ModelAttribute("producto") ProductoDTO pr){
        this.productoService.guardarProducto(pr);
        return "redirect:/administrador";
    }

    @GetMapping("/editarPr/{id}")
    public String editarPr(Model model, @PathVariable("id") Integer id){
        ProductoDTO pr = this.productoService.buscarProducto(id);
        model.addAttribute("producto", pr);
        return "producto";
    }

    @PostMapping("/editarPr/{id}")
    public String guardarPr(Model model, @RequestParam("producto") ProductoDTO pr){
        this.productoService.guardarProducto(pr);
        return "redirect:/administrador";
    }

    @GetMapping("/borrarCa/{id}")
    public String borrarCA(Model model, @PathVariable("id") Integer id){
        this.categoriaService.borrarCategoria(id);
        return "redirect:/administrador";
    }

    @GetMapping("/nuevoCa")
    public String nuevoCa(Model model){
        CategoriaDTO ca = new CategoriaDTO();
        model.addAttribute("categoria",ca);
        return "categoria";
    }

    @PostMapping("/nuevoCa")
    public String crearCa(@ModelAttribute("categoria") CategoriaDTO ca){
        this.categoriaService.guardarCategoria(ca);
        return "redirect:/administrador";
    }

    @GetMapping("/editarCa/{id}")
    public String editarCa(Model model, @PathVariable("id") Integer id){
        CategoriaDTO ca = this.categoriaService.buscarCategoria(id);
        model.addAttribute("categoria", ca);
        return "categoria";
    }

    @PostMapping("/editarCa/{id}")
    public String guardarCa(Model model, @RequestParam("categoria") CategoriaDTO ca){
        this.categoriaService.guardarCategoria(ca);
        return "redirect:/administrador";
    }

    @GetMapping("/borrarAn/{id}")
    public String borrarAn(Model model, @PathVariable("id") Integer id){
        this.analistaService.borrarAnalista(id);
        return "redirect:/administrador";
    }

    @GetMapping("/nuevoAn")
    public String nuevoAn(Model model){
        List<UsuarioDTO> listaAn = this.analistaService.listarNOAnalistas();
        model.addAttribute("listaAn",listaAn);
        return "analista";
    }

    @GetMapping("/nuevoAn/{id}")
    public String guardarAn(Model model, @PathVariable("id") Integer id){
        AnalistaDTO an = new AnalistaDTO();
        an.setUsuarioId(id);
        this.analistaService.guardarAnalista(an);
        return "redirect:/administrador";
    }

    @GetMapping("/borrarMa/{id}")
    public String borrarMa(Model model, @PathVariable("id") Integer id){
        this.marketingService.borrarMarketing(id);
        return "redirect:/administrador";
    }

    @GetMapping("/nuevoMa")
    public String nuevoMa(Model model){
        List<UsuarioDTO> listaAn = this.marketingService.listarNOMarketing();
        model.addAttribute("listaMa",listaAn);
        return "marketing";
    }

    @GetMapping("/nuevoMa/{id}")
    public String guardarMa(Model model, @PathVariable("id") Integer id){
        MarketingDTO an = new MarketingDTO();
        this.marketingService.guardarMarketing(id);
        return "redirect:/administrador";
    }
}
