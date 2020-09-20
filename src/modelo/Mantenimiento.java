package modelo;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Mantenimiento implements Serializable{
    // Definición de atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;
    @OneToOne
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private LocalDate date;
    @OneToOne(cascade = CascadeType.ALL)
    private Persona mecanico;
    @OneToOne
    private Vehiculo vehiculo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Servicio> servicios;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Consumo> consumos;

    // Constructores
    public Mantenimiento(){
        this.servicios = new ArrayList<>();
        this.consumos = new ArrayList<>();
    }
    
    public Mantenimiento(LocalDate date, Vehiculo vehiculo) throws Exception{
        this.date = date;
        setVehiculo(vehiculo);
        this.servicios = new ArrayList<>();
        this.consumos = new ArrayList<>();
    }
    
    public Mantenimiento(LocalDate date, Persona mecanico, Vehiculo vehiculo) throws Exception{
        this.date = date;
        setMecanico(mecanico);
        setVehiculo(vehiculo);
        this.servicios = new ArrayList<>();
        this.consumos = new ArrayList<>();
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
    
    public List<Servicio> getServicios(){
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }
    
    public List<Consumo> getConsumos(){
        return consumos;
    }
    
    public Float valorConsumos(){
        float valorConsumo=0.0F;
        valorConsumo += valorManoObra();
        valorConsumo += valorProductos();
        return valorConsumo;
    }
    
    public Float valorConsumosEIva(){
        float valorConsumo=0.0F;
        valorConsumo += valorManoObra();
        for(Consumo consumoL : this.consumos){
            valorConsumo += consumoL.getProducto().getCosto()
        *consumoL.getCantidad();
        }
        return valorConsumo+ivaValorConsumos();
    }
    
    public Float ivaValorConsumos(){
        return (valorConsumos()*0.16F);
    }
    
    public Float valorManoObra(){
        float valorManoObra=0.0F;
        for(Servicio servicio : servicios){
            valorManoObra += servicio.getCosto();
        }
        return valorManoObra;
    }
    
    public Float valorProductos(){
        float valorProductos=0.0F;
        for(Consumo consumoL : this.consumos){
            valorProductos += consumoL.getProducto().getCosto()
            *consumoL.getCantidad();
        }
        return valorProductos;
    }

    @Override
    public String toString(){
        return "mecanico: "+mecanico+", vehiculo: "+ vehiculo.getPlaca() + 
                ", Valor: " +valorConsumosEIva();
    }
    
    public void agregarServico(Servicio servicio){
        servicios.add(servicio);
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }
}