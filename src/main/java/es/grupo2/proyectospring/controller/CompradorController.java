package es.grupo2.proyectospring.controller;


import es.grupo2.proyectospring.dto.CompradorDTO;
import es.grupo2.proyectospring.dto.ListaVentaDTO;
import es.grupo2.proyectospring.dto.ProductoDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.entity.*;
import es.grupo2.proyectospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CompradorController {


    private ListaVentaRepository listaVentaRepository;
    private CompradorRepository compradorRepository;
    private FavoritosRepository favoritosRepository;
    private ProductoRepository productoRepository;

    private UsuarioRepository usuarioRepository;

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    @Autowired
    private void setProductoRepository(ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
    }

    @Autowired
    private void setListaVentaRepository(ListaVentaRepository listaVentaRepository){
        this.listaVentaRepository=listaVentaRepository;
    }

    @Autowired
    private void setCompradorRepository(CompradorRepository compradorRepository){
        this.compradorRepository=compradorRepository;
    }

    @Autowired
    private void setFavoritosRepository(FavoritosRepository favoritosRepository){
        this.favoritosRepository=favoritosRepository;
    }



    @RequestMapping("/comprador/{id}")
    public String doMostrarProductosComprador(Model model, @PathVariable("id") int id){

        List<ListaVenta> listaVentaList = this.listaVentaRepository.findAll();
        List<ListaVentaDTO> listaVenta=new ArrayList<>();
        for(ListaVenta lv : listaVentaList){
            listaVenta.add(lv.toDTO());
        }
        Comprador c=this.compradorRepository.findByIDComprador(id);
        CompradorDTO comprador=c.toDTO();

        List<FavoritosComprador> f=this.favoritosRepository.favoritos(id);
        List<ProductoDTO> favoritos=new ArrayList<>();
        for(FavoritosComprador fv: f){
            int i=fv.getProductoId();
            Producto p= this.productoRepository.findByIdP(i);
            ProductoDTO pdto=p.toDTO();
            favoritos.add(pdto);
        }
        model.addAttribute("favoritos",favoritos);
        model.addAttribute("comprador",comprador);
        model.addAttribute("listaVentaDTO", listaVenta);
        return "Productos";

    }

    @RequestMapping("/inicioSesion")
    public String doMain(Model model){

        return "InicioSesion";
    }

    @RequestMapping("/inicioSesionCompleted")
    public String doIniciarSesion(Model model,@RequestParam(value = "usuario",required = true) String usuario,
                                  @RequestParam(value = "password",required = true) String password){
        String ruta="InicioSesion";
        Usuario u = usuarioRepository.findByNombreUsuario(usuario);
        UsuarioDTO usuarioDTO=u.toDTO();
        if(usuarioDTO!=null){
            ruta="redirect:/comprador/"+usuarioDTO.getId().intValue();
        }

        return ruta;
    }

    @RequestMapping("/registrar")
    public String doRegistrarCompradorView(Model model){
        return "Registrar";
    }



    @RequestMapping("/registrarCompleted")
    public String doRegistrarComprador(Model model,@RequestParam(value = "nombre",required = true) String nombre,
                                       @RequestParam(value = "apellidos",required = true) String apellidos,
                                       @RequestParam(value = "domicilio",required = true) String domicilio,
                                       @RequestParam(value = "ciudad",required = true) String ciudad,
                                       @RequestParam(value = "edad",required = true) int edad,
                                       @RequestParam(value = "sexo",required = true) String sexo,
                                       @RequestParam(value = "categoria",required = true) String categoria,
                                       @RequestParam(value = "password",required = true) String password){

        UsuarioDTO usuarioDTO=new UsuarioDTO();
        usuarioDTO.setNombre(nombre);
        usuarioDTO.setApellidos(apellidos);
        usuarioDTO.setDomicilio(domicilio);
        usuarioDTO.setCiudad(ciudad);
        usuarioDTO.setEdad(edad);
        usuarioDTO.setSexo(sexo);
        usuarioDTO.setContraseña(password);
        usuarioRepository.save(usuarioDTO.toNormal());
        CompradorDTO compradorDTO=new CompradorDTO();
        compradorDTO.setUsuario(usuarioDTO.toNormal());
        compradorDTO.setCategoriaPreferida(categoria);
        compradorDTO.setUsuarioId(usuarioDTO.getId().intValue());
        compradorRepository.save(compradorDTO.toNormal());

        return "InicioSesion";
    }

    @RequestMapping("/Favoritos/{id}")
    public String doFavoritos(Model model, @PathVariable("id") int id){
        Comprador c=this.compradorRepository.findByIDComprador(id);
        CompradorDTO comprador=c.toDTO();
        List<FavoritosComprador> f=this.favoritosRepository.favoritos(id);
        List<ProductoDTO> favoritos=new ArrayList<>();
        for(FavoritosComprador fv: f){
            int i=fv.getProductoId();
            Producto p= this.productoRepository.findByIdP(i);
            ProductoDTO pdto=p.toDTO();
            favoritos.add(pdto);
        }
        model.addAttribute("favoritos",favoritos);
        model.addAttribute("comprador",comprador);
        return "Favoritos";
    }

    @RequestMapping("comprador/AnadirFavorito/comprador/{idc}/Productoid/{idp}")
    public String doAnadirFavorito(Model model,@PathVariable("idc") int idc, @PathVariable("idp") int idp){

        FavoritosComprador fav=new FavoritosComprador();
        fav.setCompradorId(idc);
        fav.setProductoId(idp);
        favoritosRepository.save(fav);
        String res="redirect:/comprador/"+idc;
        return res;
    }

    @RequestMapping("Favoritos/EliminarFavorito/comprador/{idc}/Productoid/{idp}")
    public String doEliminarFavorito(Model model,@PathVariable("idc") int idc, @PathVariable("idp") int idp){

        FavoritosComprador fav=this.favoritosRepository.findByIDC(idc,idp);
        favoritosRepository.delete(fav);
        String res="redirect:/Favoritos/"+idc;
        return res;
    }


    @RequestMapping("/Puja/comprador/{idc}/Productoid/{idp}")
    public String doPujar(Model model, @PathVariable("idc") int idc, @PathVariable("idp") int idp, @RequestParam(value = "puja",required = false) double puja){

        ListaVenta lv=listaVentaRepository.findListaVentaByProductoId(idp);
        double preciopuja= lv.getPreciopuja();
        if(puja>preciopuja) {
            lv.setPreciopuja(puja);
            listaVentaRepository.save(lv);
        }
        String res="redirect:/comprador/"+idc;
        return res;
    }

    @RequestMapping("Filtro/{idc}")
    public String doFiltro(Model model,@PathVariable("idc") int idc){


        boolean filtro=true;
        String res="redirect:/comprador/"+idc;
        return res;
    }

}
