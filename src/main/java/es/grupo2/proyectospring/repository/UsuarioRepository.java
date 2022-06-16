package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
    AUTHOR: Jesús Antona Espejo
*/
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    public List<Usuario> findBySexo(String str);

    @Query ("select u from Usuario u where u.ciudad like :str")
    public List<Usuario> findByCiudad(String str);

    @Query ("select u from Usuario u where u.ciudad like :str and u.sexo like :x")
    public List<Usuario> findByCiudadSexo(String str,String x);

    @Query ("select u from Usuario u where u.edad >= :str")
    public List<Usuario> findByEdadMin(int str);

    @Query ("select u from Usuario u where u.edad <= :str")
    public List<Usuario> findByEdadMax(int str);

    @Query ("select u from Usuario u where u.edad <= :str2 and u.edad >= :str1")
    public List<Usuario> findByEdadMinMax(int str1,int str2);

    @Query ("select u from Usuario u where u.edad <= :str2 and u.edad >= :str1 and u.ciudad like :c and u.sexo like :x")
    public List<Usuario> findByEdadMinMaxSexoCiudad(int str1,int str2,String x,String c);

    @Query ("select u from Usuario u where u.edad <= :str2 and u.edad >= :str1 and u.sexo like :x")
    public List<Usuario> findByEdadMinMaxSexo(int str1,int str2,String x);

    @Query ("select u from Usuario u where u.edad <= :str2 and u.edad >= :str1 and u.ciudad like :c")
    public List<Usuario> findByEdadMinMaxCiudad(int str1,int str2,String c);



    @Query ("select u from Usuario u where u.nombre like:nombre")
    public Usuario findByNombreUsuario(String nombre);

    @Query ("select u from Usuario u where u.nombre like :nombre and u.contraseña like :pass")
    public Usuario findByNombreUsuarioPass(String nombre,String pass);

}