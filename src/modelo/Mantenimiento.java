/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author aleswise
 */
public class Mantenimiento {
    
    private Date date;
    private Persona persona;
    private Vehiculo vehiculo;
    private LinkedList<Servicio> servicios;
    private LinkedList<Consumo> consumos;

    public Mantenimiento(Date date, Persona persona, Vehiculo vehiculo) {
        this.date = date;
        this.persona = persona;
        this.vehiculo = vehiculo;
        this.servicios = new LinkedList<>();
        this.consumos = new LinkedList<>();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LinkedList<Servicio> getServicios() {
        return servicios;
    }

    public LinkedList<Consumo> getConsumos() {
        return consumos;
    }
    
}
