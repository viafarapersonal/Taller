package modelo;
/*  Author:  Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: July 2020
 */

import java.time.LocalDate;
import java.util.LinkedList;

public class Mantenimiento{
    // Definición de atributos
    private LocalDate date;
    private Persona persona;
    private Vehiculo vehiculo;
    private LinkedList<Servicio> servicios;
    private LinkedList<Consumo> consumos;

    // Constructores
    public Mantenimiento(){
        this.servicios = new LinkedList<>();
        this.consumos = new LinkedList<>();
    }
    
    public Mantenimiento(LocalDate date, Persona persona, Vehiculo vehiculo) throws Exception{
        this.date = date;
        setPersona(persona);
        setVehiculo(vehiculo);
        this.servicios = new LinkedList<>();
        this.consumos = new LinkedList<>();
    }
    
    // Definición de los métodos
    // Implementación de validación de valores en los metodos Set
    public LocalDate getDate(){
        return date;
    }
    
    public void setDate(LocalDate date){
        this.date = date;
    }
    
    public Persona getPersona(){
        return persona;
    }
    
    public void setPersona(Persona persona) throws Exception{
        if (persona == null){
            throw new Exception("Debe ingresar un Mecánico");
        }
        this.persona = persona;
    }
    
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo)throws Exception{
        if (vehiculo == null){
            throw new Exception("Debe ingresar un vehículo");
        }
        this.vehiculo = vehiculo;
    }
    
    public LinkedList<Servicio> getServicios(){
        return servicios;
    }
    
    public LinkedList<Consumo> getConsumos(){
        return consumos;
    }
}