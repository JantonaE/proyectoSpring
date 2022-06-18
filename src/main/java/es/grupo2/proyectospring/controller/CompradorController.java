package es.grupo2.proyectospring.controller;


//import com.sun.org.apache.xpath.internal.operations.Bool;
import es.grupo2.proyectospring.dto.*;
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
    private MarketingRepository marketingRepository;

    private UsuarioRepository usuarioRepository;
    private VendedorRepository vendedorRepository;
    private List<ListaVentaDTO> listaVentaDTO =new ArrayList<>();

    @Autowired
    public void setVendedorRepository(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Autowired
    public void setMarketingRepository(MarketingRepository marketingRepository) {
        this.marketingRepository = marketingRepository;
    }

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


    @RequestMapping("/inicioSesion")
    public String doMain(Model model){

        return "InicioSesion";
    }

    @RequestMapping("/inicioSesionCompleted")
    public String doIniciarSesion(Model model,@RequestParam(value = "usuario",required = true) String usuario,
                                  @RequestParam(value = "password",required = true) String password){
        String ruta="InicioSesion";
        Usuario u = usuarioRepository.findByNombreUsuarioPass(usuario,password);
        if(u == null) return "Registrar";
        UsuarioDTO usuarioDTO=u.toDTO();
        int idUser = u.getId();
        VendedorDTO vendedorDTO = null;
        //MarketingDTO marketingDTO = this.marketingRepository.findById(idUser).orElse(null).toDTO();
        //if(marketingDTO.equals(null)){
        //    vendedorDTO = this.vendedorRepository.findById(idUser).orElse(null).toDTO();
        //}


        if(usuario.equals("Jesus") && password.equals("Prueba000")){
            ruta="redirect:/marketing/"+usuarioDTO.getId();
        }else if(usuario.equals("admin") && password.equals("admin")) {
            ruta="redirect:/administrador";
        }else if(!vendedorDTO.equals(null)){
            ruta="redirect:/vendedor/"+vendedorDTO.getUsuarioId();
        }else if(usuarioDTO!=null){
            ruta="redirect:/comprador/"+usuarioDTO.getId().intValue()+"/false";
        }

       // System.out.println("Ruta:"+ruta);
        //System.out.println("Marketing:"+marketing.getUsuarioId());
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
                                       @RequestParam(value = "cat",required = true) String cat,
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

        //Usuario u= usuarioRepository.findByNombreUsuario(nombre);
        Usuario u=usuarioDTO.toNormal();
        CompradorDTO compradorDTO=new CompradorDTO();
        compradorDTO.setCategoriaPreferida(cat);
        compradorDTO.setUsuarioId(u.getId());
        u.setComprador(compradorDTO.toNormal());
        compradorDTO.setUsuario(usuarioDTO.toNormal());
        compradorRepository.save(compradorDTO.toNormal());

        return "InicioSesion";
    }

    @RequestMapping("/Favoritos/{id}/{filtro}")
    public String doFavoritos(Model model, @PathVariable("id") int id,@PathVariable("filtro") Boolean filtro){
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
        model.addAttribute("filtro",filtro);
        model.addAttribute("favoritos",favoritos);
        model.addAttribute("comprador",comprador);
        return "Favoritos";
    }

    @RequestMapping("AnadirFavorito/comprador/{idc}/Productoid/{idp}/{filtro}")
    public String doAnadirFavorito(Model model,@PathVariable("idc") int idc, @PathVariable("idp") int idp,@PathVariable("filtro") Boolean filtro){

        FavoritosComprador fav=new FavoritosComprador();
        fav.setCompradorId(idc);
        fav.setProductoId(idp);
        favoritosRepository.save(fav);
        String res="redirect:/comprador/"+idc+"/"+filtro;
        return res;
    }

    @RequestMapping("EliminarFavorito/comprador/{idc}/Productoid/{idp}/{filtro}")
    public String doEliminarFavorito(Model model,@PathVariable("idc") int idc, @PathVariable("idp") int idp,@PathVariable("filtro") Boolean filtro){

        FavoritosComprador fav=this.favoritosRepository.findByIDC(idc,idp);
        favoritosRepository.delete(fav);
        String res="redirect:/Favoritos/"+idc+"/"+filtro;
        return res;
    }


    @RequestMapping("/Puja/comprador/{idc}/Productoid/{idp}/{filtro}")
    public String doPujar(Model model, @PathVariable("idc") int idc, @PathVariable("idp") int idp, @PathVariable("filtro")Boolean filtro, @RequestParam(value = "puja",required = false) double puja){

        ListaVenta lv=listaVentaRepository.findListaVentaByProductoId(idp);
        double preciopuja= lv.getPreciopuja();
        if(puja>preciopuja) {
            lv.setPreciopuja(puja);
            listaVentaRepository.save(lv);
        }
        String res="redirect:/comprador/"+idc+"/"+filtro;
        return res;
    }

    @RequestMapping("Filtrar/{idc}")
    public String doFiltro(Model model,@PathVariable("idc") int idc,
                           @RequestParam(value = "tituloF",required = false) String tituloF,
                           @RequestParam(value = "descF",required = false) String descF,
                           @RequestParam(value = "precioF",required = false) String precioF,
                           @RequestParam(value = "categoriaF",required = false) String categoriaF){


        Boolean filtro=false;
        if(categoriaF.equals(null)){
            categoriaF="";
        }
        if(tituloF.equals("") && descF.equals("") && precioF.equals("") && categoriaF.equals("")){
            List<ListaVenta> listaVentaList = this.listaVentaRepository.findAll();
            List<ListaVentaDTO> listaVenta=new ArrayList<>();
            for(ListaVenta lv : listaVentaList){
                listaVenta.add(lv.toDTO());
            }
            model.addAttribute("listaVentaDTO", listaVenta);
            listaVentaDTO=listaVenta;
        }
        if(!tituloF.equals("")){
            List<ListaVenta> listaVentaList=this.listaVentaRepository.findByNombre(tituloF);
            List<ListaVentaDTO> listaVenta=new ArrayList<>();
            for(ListaVenta lv : listaVentaList){
                listaVenta.add(lv.toDTO());
            }
            filtro=true;
            model.addAttribute("filtro",filtro);
            model.addAttribute("listaVentaDTO", listaVenta);
            listaVentaDTO=listaVenta;
        }

        if(!descF.equals("")){
            List<ListaVenta>  listaVentaList=this.listaVentaRepository.findByDescripcion(descF);
            List<ListaVentaDTO> listaVenta=new ArrayList<>();
            for(ListaVenta lv : listaVentaList){
                listaVenta.add(lv.toDTO());
            }
            filtro=true;
            model.addAttribute("filtro",filtro);
            model.addAttribute("listaVentaDTO", listaVenta);
            listaVentaDTO=listaVenta;
        }

        if(!precioF.equals("")){
            List<ListaVenta>  listaVentaList=this.listaVentaRepository.findByPrecio(Double.parseDouble(precioF));
            List<ListaVentaDTO> listaVenta=new ArrayList<>();
            for(ListaVenta lv : listaVentaList){
                listaVenta.add(lv.toDTO());
            }
            filtro=true;
            model.addAttribute("filtro",filtro);
            model.addAttribute("listaVentaDTO", listaVenta);
            listaVentaDTO=listaVenta;
        }

        if(!categoriaF.equals("")){
            int res;
            if(categoriaF.equals("Ocio")){
                res=1;
            }else if(categoriaF.equals("Deportes")){
                res=2;
            }else if(categoriaF.equals("Ropa")){
                res=3;
            }else if(categoriaF.equals("Muebles")){
                res=4;
            }else{
                res=5;
            }
            List<ListaVenta>  listaVentaList=this.listaVentaRepository.findByCategoria(res);
            List<ListaVentaDTO> listaVenta=new ArrayList<>();
            for(ListaVenta lv : listaVentaList){
                listaVenta.add(lv.toDTO());
            }
            filtro=true;
            model.addAttribute("filtro",filtro);
            model.addAttribute("listaVentaDTO", listaVenta);
            listaVentaDTO=listaVenta;
        }



        String res="redirect:/comprador/"+idc+"/"+filtro;
        return res;
    }

    @RequestMapping("/comprador/{id}/{filtro}")
    public String doMostrarProductosComprador(Model model, @PathVariable("id") int id,@PathVariable("filtro") Boolean filtro){

        List<ListaVenta> listaVentaList = new ArrayList<>();
        //Boolean filtro= (Boolean) model.getAttribute("filtro");
        if(filtro==null){
            filtro=false;
        }
        if(!filtro) {
            listaVentaList = this.listaVentaRepository.findAll();
            /*for(ListaVenta l:listaVentaList){
                listaVentaDTO.add(l.toDTO());
            }*/
        }else{
            for(ListaVentaDTO l :listaVentaDTO){
                listaVentaList.add(l.toNormal());
            }

        }
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

}
