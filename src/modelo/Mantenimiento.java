package modelo;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
import java.time.LocalDate;
import java.util.LinkedList;

public class Mantenimiento{
    // Definición de atributos
    private LocalDate date;
    private Persona mecanico;
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
        setMecanico(persona);
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
    
    public Persona getMecanico(){
        return mecanico;
    }
    
    public void setMecanico(Persona mecanico) throws Exception{
        if (mecanico == null){
            throw new Exception("Debe ingresar un Mecánico");
        }
        this.mecanico = mecanico;
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
    
    public Float valorConsumos(){
        float valorConsumo=0.0F;
        for(Consumo consumoL : this.consumos){
            valorConsumo += consumoL.getProducto().getCosto();
            valorConsumo += consumoL.getServicio().getCosto();
        }
        return valorConsumo;
    }

    @Override
    public String toString(){
        return "mecanico: "+mecanico+", vehiculo="+ vehiculo.getPlaca() + 
                ", Valor: " +valorConsumos();
    }
}