package modelo;
import java.io.Serializable;
import javax.persistence.Entity;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
@Entity
public class Propietario extends Persona implements Serializable{

    public Propietario() {
    }

    public Propietario(long nuip, String nombre, String apellido, Long telefono) throws Exception {
        super(nuip, nombre, apellido, telefono);
    }
}