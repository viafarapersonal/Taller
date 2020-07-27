package modelo;
/*  Author:  aleswise
    <>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: July 2020
 */
import java.util.regex.Pattern;
///////////////////////////////////////////////////////////////////////////////
public class Persona {
    // Definición de atributos
    private long nuip;
    private String nombre;
    private String apellido;
    private long telefono;
    
    // Constructores
    public Persona(){
    }
    public Persona(long nuip, String nombre, String apellido, Long telefono) throws Exception{
        setNuip(nuip);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
    }

    // Definición de los métodos
    // Implementación de validación de valores en los metodos Set
    public long getNuip(){
        return nuip;
    }
    public void setNuip(long nuip) throws Exception{
        if(!((nuip>=1000000L && nuip<=99999999L) || nuip>=1000000000L && nuip<=9999999999L)){
            throw new Exception("La identificación debe ser entre 7, 8 o 10 números");
        }
        this.nuip = nuip;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) throws Exception{
        nombre = nombre.trim();
        if(nombre == null || "".equals(nombre)){
            throw new Exception("El Nombre de la PERSONA NO debe ser valor null o cadena vacía");
        }
        if(!Pattern.matches("[a-zA-Z ]*", nombre)){
            throw new Exception("El Nombre de la PERSONA NO debe contener números ni caracteres especiales");
        }
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido) throws Exception{
        apellido = apellido.trim();
        if(apellido == null || "".equals(apellido)){
            throw new Exception("El Apellido NO debe ser valor null o cadena vacía");
        }
        if(!Pattern.matches("[a-zA-Z ]*", apellido)){
            throw new Exception("El Apellido NO debe contener números ni caracteres especiales");
        }
        this.apellido = apellido;
    }
    public long getTelefono(){
        return telefono;
    }
    public void setTelefono(long telefono) throws Exception{
        if(!(telefono>=1000000000L && telefono<=9999999999L)){
            throw new Exception("El número telefónico debe ser de 10 números, si es número fijo incluya el indicativo");
        }
        this.telefono = telefono;
    }
}