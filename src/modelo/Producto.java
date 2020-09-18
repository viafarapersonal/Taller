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
public class Producto implements Serializable{
    // Definición de atributos
    @Id
    private int codigo;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false)
    private int costo;

    // Constructores
    public Producto(){
    }
    
    public Producto(int codigo, String nombre, int costo) throws Exception{
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
            throw new Exception("El Código del PRODUCTO debe ser ENTERO POSITIVO");
        }
        this.codigo = codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre) throws Exception{
        nombre = nombre.trim();
        if(nombre == null || "".equals(nombre)){
            throw new Exception("El Nombre del PRODUCTO NO debe ser valor null o cadena vacía");
        }
        this.nombre = nombre;
    }
    
    public int getCosto(){
        return costo;
    }
    
    public void setCosto(int costo) throws Exception{
        if(costo <= 0){
            throw new Exception("El COSTO del PRODUCTO debe ser ENTERO POSITIVO");
        }
        this.costo = costo;
    }
}