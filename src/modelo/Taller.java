package modelo;
import java.util.LinkedList;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
public class Taller{
    // Definición de atributos
    private long nit;
    private String nombre;
    private LinkedList<Persona> mecanicos;
    private LinkedList<Producto> productos;
    private LinkedList<Servicio> servicios;
    private LinkedList<Mantenimiento> manteRealizados;
    private LinkedList<Mantenimiento> mantePendientes;
    private LinkedList<Vehiculo> vehiculos;

    // Constructores
    public Taller(){
        this.mecanicos = new LinkedList<>();
        this.productos = new LinkedList<>();
        this.servicios = new LinkedList<>();
        this.manteRealizados = new LinkedList<>();
        this.mantePendientes = new LinkedList<>();
        this.vehiculos = new LinkedList<>();
    }
    
    public Taller(long nit, String nombre) throws Exception{
        setNit(nit);
        setNombre(nombre);
        this.mecanicos = new LinkedList<>();
        this.productos = new LinkedList<>();
        this.servicios = new LinkedList<>();
        this.manteRealizados = new LinkedList<>();
        this.mantePendientes = new LinkedList<>();
        this.vehiculos = new LinkedList<>();
    }
    
    // Definición de los métodos
    // Implementación de validación de valores en los metodos Set
    public long getNit(){
        return nit;
    }
    
    public void setNit(long nit) throws Exception{
        if (nit <= 0){
            throw new ClassNotFoundException("El NIT DEBE ser un ENTERO POSITIVO");
        }
        this.nit = nit;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre) throws Exception{
        nombre = nombre.trim();
        if(nombre == null || "".equals(nombre)){
            throw new ClassNotFoundException("El Nombre del TALLER NO debe ser valor null o cadena vacía");
        }
        this.nombre = nombre;
    }
    
    public LinkedList<Persona> getMecanicos(){
        return mecanicos;
    }
    
    public LinkedList<Persona> getMecanicosLibres(){
        LinkedList<Persona> mecanicosLibres = new LinkedList<>();
        for (Persona mecanico : mecanicos){
            for (Mantenimiento mantnimiento : mantePendientes){
                if(mecanico.getNuip() != mantnimiento.getMecanico().getNuip()){
                mecanicosLibres.add(mecanico);
                }
            }
        }
        return mecanicosLibres;
    }
    
    public LinkedList<Producto> getProductos(){
        return productos;
    }
    
    public LinkedList<Servicio> getServicios(){
        return servicios;
    }
    
    public LinkedList<Mantenimiento> getManteRealizados(){
        return manteRealizados;
    }
    
    public LinkedList<Mantenimiento> getMantePendientes(){
        return mantePendientes;
    }
    
    public Mantenimiento getMantenimientoPlaca(String placa) throws Exception{
        for (Mantenimiento mantenimientoL : mantePendientes) {
            if(mantenimientoL.getVehiculo().getPlaca() == placa){
                return mantenimientoL;
            }
        }
        throw new ClassNotFoundException("No se ha encontrado el MANTENIMIENTO "
                + "PENDIENTE con la PLACA: "+placa);
    }
    
    public LinkedList<Mantenimiento> getPendientesNoMecanico(){
        LinkedList<Mantenimiento> noMecanicos = new LinkedList<>();
        for (Mantenimiento mantemimiento : mantePendientes){
            if(mantemimiento.getMecanico() != null){
                noMecanicos.add(mantemimiento);
            }
        }
        return noMecanicos;
    }
    
    public LinkedList<Vehiculo> getVehiculos(){
        return vehiculos;
    }
    
    public void agregarMecanico (Persona newMecanico) throws Exception{
        for (Persona personaL : mecanicos) {
            if (personaL.equals(newMecanico)){
                throw new ClassNotFoundException("El(la) MECANICO(A) que intenta añadir ya se encuentra registrado(a)");
            }
        }
        mecanicos.add(newMecanico);
    }

    public void eliminarMecanico (Persona mecanico){
        mecanicos.remove(mecanico);
    }

    public void agregarProducto (Producto newproducto) throws Exception{
        for (Producto productoL : productos) {
            if (productoL.equals(newproducto)){
                throw new ClassNotFoundException("El PRODUCTO que intenta añadir ya se encuentra registrado");
            }
        }
        productos.add(newproducto);
    }

    public void eliminarProducto (Producto producto){
        productos.remove(producto);
    }

    public void agregarServico (Servicio newservicio) throws Exception{
        for (Servicio servicioL : servicios) {
            if (servicioL.equals(newservicio)){
                throw new ClassNotFoundException("El SERVICIO que intenta añadir"
                        + " al TALLER ya se encuentra registrado");
            }
        }
        servicios.add(newservicio);
    }

    public void eliminarServico (Servicio servicio){
        servicios.remove(servicio);
    }
    
    public void agregarRealizado (Mantenimiento newrealizado) throws Exception{
        for (Mantenimiento realizadoL : manteRealizados) {
            if (realizadoL.equals(newrealizado)){
                throw new ClassNotFoundException("El MANTENIMIENTO REALIZADO que intenta añadir ya se encuentra registrado");
            }
        }
        manteRealizados.add(newrealizado);
    }
    
    public void eliminarRealizado (Mantenimiento realizado){
        manteRealizados.remove(realizado);
    }
    
    public void agregarPendiente (Mantenimiento newpendiente) throws Exception{
        for (Mantenimiento pendienteL : mantePendientes) {
            if (pendienteL.equals(newpendiente)){
                throw new ClassNotFoundException("El MANTENIMIENTO PENDIENTE que intenta añadir ya se encuentra registrado");
            }
        }
        mantePendientes.add(newpendiente);
    }
    
    public void eliminarPendiente (Mantenimiento pendiente){
        mantePendientes.remove(pendiente);
    }
    
    public void agregarVehiculo (Vehiculo newvehiculo) throws Exception{
        for (Vehiculo vehiculoL : vehiculos){
            if (vehiculoL.equals(newvehiculo)){
                throw new ClassNotFoundException("El VEHÍCULO con placa: ["
                    +newvehiculo.getPlaca()+"] ya se encuentra registrado");
            }
        }
        this.vehiculos.add(newvehiculo);
    }
    
    public void eliminarVehiculo (Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }
    
    public Vehiculo buscarVehiculoPlaca(String placa) throws Exception{
        placa = placa.trim();
        placa = placa.toUpperCase();
        if (!(placa.length() == 6)){
            throw new ClassNotFoundException("La PLACA ingresada NO es válida (6 caracteres)");
        }
        for (Vehiculo vehiculoL : vehiculos){
            if(vehiculoL.getPlaca().equals(placa)){
                return vehiculoL;
            }
        }
        throw new ClassNotFoundException("El VEHÍCULO con placa: "
                    +placa+" NO SE ENCONTRÓ");
    }
}