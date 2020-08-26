package modelo;
/*  Author:  Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: July 2020
 */

public class Consumo{
    // Definición de atributos
    private int cantidad;
    private Producto producto;
    private Servicio servicio;

    // Constructores
    public Consumo(){
    }
    
    public Consumo(int cantidad, Producto producto, Servicio servicio) throws Exception{
        setCantidad(cantidad);
        setProducto(producto);
        setServicio(servicio);
    }
    
    // Definición de los métodos
    // Implementación de validación de valores en los metodos Set
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad) throws Exception{
        if (cantidad <= 0){
            throw new Exception("La Cantidad debe ser ENTERO POSITIVO");
        }
        this.cantidad = cantidad;
    }
    
    public Producto getProducto(){
        return producto;
    }
    
    public void setProducto(Producto producto) throws Exception{
        if (producto == null){
            throw new Exception("Debe ingresar un Producto");
        }
        this.producto = producto;
    }
    
    public Servicio getServicio(){
        return servicio;
    }
    
    public void setServicio(Servicio servicio) throws Exception{
        if (servicio == null){
            throw new Exception("Debe ingresar un Servicio");
        }
        this.servicio = servicio;
    }
}