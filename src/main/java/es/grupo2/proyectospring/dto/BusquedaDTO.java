package es.grupo2.proyectospring.dto;


/**
 *
 * @author Antonio Sepúlveda Zorrilla
 */

public class BusquedaDTO {
    private String idAnalisis;
    private String idAnalista;
    private String nombreBusqueda;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private String ciudad;
    private String edad;
    private String sexo;
    private String orden;

    public BusquedaDTO(){}

    public BusquedaDTO(String idAnalista) {
        this.idAnalista = idAnalista;
        this.idAnalisis = "";
        this.nombreBusqueda = "";
        this.nombre = "";
        this.apellidos = "";
        this.domicilio = "";
        this.ciudad = "";
        this.edad = "";
        this.sexo = "";
        this.orden = "";
    }

    public String getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(String idAnalisis) {
        this.idAnalisis = idAnalisis;
    }

    public String getIdAnalista() {
        return idAnalista;
    }

    public void setIdAnalista(String idAnalista) {
        this.idAnalista = idAnalista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombreBusqueda() {
        return nombreBusqueda;
    }

    public void setNombreBusqueda(String nombreBusqueda) {
        this.nombreBusqueda = nombreBusqueda;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }
}
