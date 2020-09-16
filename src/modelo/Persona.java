package modelo;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona implements Serializable{
    // Definición de atributos
    @Id
    private Long nuip;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellido;
    @Column(nullable = false, length = 10)
    private Long telefono;
    
    // Constructores
    public Persona(){
    }
    
    public Persona(Long nuip, String nombre, String apellido, Long telefono) throws Exception{
        setNuip(nuip);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
    }

    // Definición de los métodos
    // Implementación de validación de valores en los metodos Set
    public Long getNuip(){
        return nuip;
    }
    
    public void setNuip(long nuip) throws Exception{
        if(!((nuip >= 1000000L && nuip <= 99999999L) || nuip >= 1000000000L && nuip <= 9999999999L)){
            throw new ClassNotFoundException("La identificación debe ser entre 7, 8 o 10 números");
        }
        this.nuip = nuip;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre) throws Exception{
        nombre = nombre.trim();
        if(nombre == null || "".equals(nombre)){
            throw new ClassNotFoundException("El Nombre de la PERSONA NO debe ser valor null o cadena vacía");
        }
        if(!Pattern.matches("[a-zA-Z ]*", nombre)){
            throw new ClassNotFoundException("El Nombre de la PERSONA NO debe contener números ni caracteres especiales");
        }
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido) throws Exception{
        apellido = apellido.trim();
        if(apellido == null || "".equals(apellido)){
            throw new ClassNotFoundException("El Apellido NO debe ser valor null o cadena vacía");
        }
        if(!Pattern.matches("[a-zA-Z ]*", apellido)){
            throw new ClassNotFoundException("El Apellido NO debe contener números ni caracteres especiales");
        }
        this.apellido = apellido;
    }
    
    public Long getTelefono(){
        return telefono;
    }
    
    public void setTelefono(long telefono) throws Exception{
        if(!(telefono >= 1000000000L && telefono <= 9999999999L)){
            throw new ClassNotFoundException("El número telefónico debe ser de 10 números, si es número fijo incluya el indicativo");
        }
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return "Documento: "+ nuip + ", nombre: " + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nuip, other.nuip)) {
            return false;
        }
        return true;
    }
}