package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
@Entity
public class Consumo implements Serializable{
    // Definición de atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;
    @Column(nullable = false)
    private int cantidad;
    @OneToOne
    private Producto producto;
    @OneToOne
    private Servicio servicio;

    // Constructores
    public Consumo(){
    }
    
    public Consumo(int cantidad, Producto producto, Servicio servicio) throws Exception{
        setCantidad(cantidad);
        setProducto(producto);
        setServicio(servicio);
    }
    
    public Long getPk(){
        return pk;
    }

    // Definición de los métodos
    // Implementación de validación de valores en los metodos Set
    public void setPk(Long pk) {
        this.pk = pk;
    }
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) throws Exception{
        if (cantidad <= 0){
            throw new ClassNotFoundException("La Cantidad debe ser ENTERO POSITIVO");
        }
        this.cantidad = cantidad;
    }
    
    public Producto getProducto(){
        return producto;
    }
    
    public void setProducto(Producto producto) throws Exception{
        if (producto == null){
            throw new ClassNotFoundException("Debe ingresar un Producto");
        }
        this.producto = producto;
    }
    
    public Servicio getServicio(){
        return servicio;
    }
    
    public void setServicio(Servicio servicio) throws Exception{
        if (servicio == null){
            throw new ClassNotFoundException("Debe ingresar un Servicio");
        }
        this.servicio = servicio;
    }
}