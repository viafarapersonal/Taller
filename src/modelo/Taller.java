/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;

/**
 *
 * @author aleswise
 */
public class Taller {
    
    private long nit;
    private String nombre;
    private LinkedList<Persona> personas;
    private LinkedList<Producto> productos;
    private LinkedList<Servicio> servicios;
    private LinkedList<Mantenimiento> realizados;
    private LinkedList<Mantenimiento> pendientes;
    private LinkedList<Vehiculo> vehiculos;

    public Taller(long nit, String nombre) throws Exception {
        
        if (nombre == null || nombre.equals("".trim())) {
            throw new Exception("Rellena el campo correctamente");
        }
        
        this.nit = nit;
        this.nombre = nombre;
        this.personas = new LinkedList<>();
        this.productos = new LinkedList<>();
        this.servicios = new LinkedList<>();
        this.realizados = new LinkedList<>();
        this.pendientes = new LinkedList<>();
        this.vehiculos = new LinkedList<>();
        
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Persona> getPersonas() {
        return personas;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public LinkedList<Servicio> getServicios() {
        return servicios;
    }

    public LinkedList<Mantenimiento> getRealizados() {
        return realizados;
    }

    public LinkedList<Mantenimiento> getPendientes() {
        return pendientes;
    }

    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public void agregarPersona (Persona persona) {
        personas.add(persona);
    }
    
    public void eliminarPersona (Persona persona) {
        personas.remove(persona);
    }
    
    public void agregarProducto (Producto producto) {
        productos.add(producto);
    }
    
    public void eliminarProducto (Producto producto) {
        productos.remove(producto);
    }
    
    public void agregarServico (Servicio servicio) {
        servicios.add(servicio);
    }
    
    public void eliminarServico (Servicio servicio) {
        servicios.remove(servicio);
    }
    
    public void agregarRealizado (Mantenimiento realizado) {
        realizados.add(realizado);
    }
    
    public void eliminarRealizado (Mantenimiento realizado) {
        realizados.remove(realizado);
    }
    
    public void agregarPendiente (Mantenimiento pendiente) {
        pendientes.add(pendiente);
    }
    
    public void eliminarPendiente (Mantenimiento pendiente) {
        pendientes.remove(pendiente);
    }
    
    public void agregarVehiculo (Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }
    
    public void eliminarVehiculo (Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }
    
}
