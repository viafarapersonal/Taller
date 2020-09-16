package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
@Entity
public class Servicio implements Serializable{
    // Definición de atributos
    @Id
    private int codigo;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int costo;

    // Constructores
    public Servicio(){
    }
    
    public Servicio(int codigo, String nombre, int costo) throws Exception {
        setCodigo(codigo);
        setNombre(nombre);
        setCosto(costo);
    }
    
    // Definición de los métodos
    // Implementación de validación de valores en los metodos Set
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo) throws Exception{
        if(codigo <= 0){
            throw new Exception("El Código del SERVICIO debe ser ENTERO POSITIVO");
        }
        this.codigo = codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre) throws Exception{
        nombre = nombre.trim();
        if(nombre == null || "".equals(nombre)){
            throw new Exception("El Nombre del SERVICIO NO debe ser valor null o cadena vacía");
        }
        this.nombre = nombre;
    }
    
    public int getCosto(){
        return costo;
    }
    
    public void setCosto(int costo) throws Exception{
        if(costo <= 0){
            throw new Exception("El COSTO del SERVICIO debe ser ENTERO POSITIVO");
        }
        this.costo = costo;
    }

    @Override
    public String toString(){
        return "Servicio: " + nombre + ", costo(" + costo + ')';
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
        final Servicio other = (Servicio) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
}
