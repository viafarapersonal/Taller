/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author aleswise
 */
public class Consumo {
    
    private int cantidad;
    private Producto producto;
    private Servicio servicio;

    public Consumo(int cantidad, Producto producto, Servicio servicio) throws Exception {
        
        if (cantidad < 0) {
            throw new Exception("Rellena el campo correctamente");
        }
        
        this.cantidad = cantidad;
        this.producto = producto;
        this.servicio = servicio;
        
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
}
