package modelo;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistence.MantenimientoJpaController;
import persistence.PersonaJpaController;
import persistence.ProductoJpaController;
import persistence.ServicioJpaController;
import persistence.VehiculoJpaController;
import persistence.exceptions.NonexistentEntityException;
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
    
//Atributos con relación a Muchos
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("750085M-Calvache-Viafara-ProyectoTallerMecanicoPU");
    
//    private LinkedList<Persona> mecanicos;
    private PersonaJpaController MecanicoJpaController = new PersonaJpaController(factory);
//    private LinkedList<Producto> productos;
    private ProductoJpaController ProductoJpaController = new ProductoJpaController(factory);
//    private LinkedList<Servicio> servicios;
    private ServicioJpaController ServicioJpaController = new ServicioJpaController(factory);
    
//    private LinkedList<Mantenimiento> manteRealizados;
    private MantenimientoJpaController mantenimientoJpaController = new MantenimientoJpaController(factory);
//    private LinkedList<Mantenimiento> mantePendientes;
//    private MantenimientoJpaController mantePendientesJpaControllerP = new MantenimientoJpaController(factory);
//    private LinkedList<Vehiculo> vehiculos;
    private VehiculoJpaController VehiculoJpaController = new VehiculoJpaController(factory);

    // Constructores
    public Taller(){
//        this.mecanicos = new LinkedList<>();
//        this.productos = new LinkedList<>();
//        this.servicios = new LinkedList<>();
//        this.manteRealizados = new LinkedList<>();
//        this.mantePendientes = new LinkedList<>();
//        this.vehiculos = new LinkedList<>();
    }
    
    public Taller(long nit, String nombre) throws Exception{
        setNit(nit);
        setNombre(nombre);
//        this.mecanicos = new LinkedList<>();
//        this.productos = new LinkedList<>();
//        this.servicios = new LinkedList<>();
//        this.manteRealizados = new LinkedList<>();
//        this.mantePendientes = new LinkedList<>();
//        this.vehiculos = new LinkedList<>();
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
    
    public List<Persona> getMecanicos(){
//        return mecanicos;
        return MecanicoJpaController.findPersonaEntities();
    }
    
    public List<Persona> getMecanicosLibres(){
        List<Persona> mecanicosLibres = new LinkedList<>();
        boolean disp;
        for(Persona mecanico : MecanicoJpaController.findPersonaEntities()){
            disp = true;
            for(Mantenimiento mantenimiento : mantenimientoJpaController.findMantenimientoEntities()){
                if(mecanico.equals(mantenimiento.getMecanico())){
                    disp = false;
                }
            }
            if(disp){
                mecanicosLibres.add(mecanico);
            }
        }
        return mecanicosLibres;
    }
    
    public List<Producto> getProductos(){
//        return productos;
        return ProductoJpaController.findProductoEntities();
    }
    
    public List<Servicio> getServicios(){
//        return servicios;
        return ServicioJpaController.findServicioEntities();
    }
    
    public List<Mantenimiento> getManteRealizados(){
        List<Mantenimiento> mantenimientosRealizados = new LinkedList<>();
        for (Mantenimiento mantenimientoRealizado : mantenimientoJpaController.findMantenimientoEntities()) {
            if (mantenimientoRealizado.isState()) {
                mantenimientosRealizados.add(mantenimientoRealizado);
            }
        }
        return mantenimientosRealizados;
    }

    public List<Mantenimiento> getMantePendientes(){
        List<Mantenimiento> mantenimientosPendientes = new LinkedList<>();
        for (Mantenimiento mantenimientoPendientes : mantenimientoJpaController.findMantenimientoEntities()) {
            if (!mantenimientoPendientes.isState()) {
                mantenimientosPendientes.add(mantenimientoPendientes);
            }
        }
        return mantenimientosPendientes;
    }
    
    private List<Mantenimiento> mantenimientos = this.getMantePendientes();
    //Esto fue lo ultimo que hice.
    
    public List<Mantenimiento> getPendientesNoMecanico(){
        List<Mantenimiento> noMecanicos = new LinkedList<>();
        for(Mantenimiento mantemimiento : mantenimientos){
            if(mantemimiento.getMecanico() == null){
                noMecanicos.add(mantemimiento);
            }
        }
        return noMecanicos;
    }
    
    public List<Vehiculo> getVehiculos(){
        return VehiculoJpaController.findVehiculoEntities();
    }
    
    //METODOS PARA AGREGAR O ELIMINAR DE LAS LISTAS
    public void agregarMecanico (Persona newMecanico) throws Exception{
//        for (Persona personaL : mecanicos) {
//            if (personaL.equals(newMecanico)){
//                throw new ClassNotFoundException("El(la) MECANICO(A) que intenta añadir ya se encuentra registrado(a)");
//            }
//        }
//        mecanicos.add(newMecanico);
        MecanicoJpaController.create(newMecanico);
    }

    public void eliminarMecanico (Persona mecanico){
//        mecanicos.remove(mecanico);
        try{
            this.MecanicoJpaController.destroy(mecanico.getNuip());
        }catch(NonexistentEntityException ex){
            Logger.getLogger(Taller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarProducto (Producto newproducto) throws Exception{
//        for (Producto productoL : productos) {
//            if (productoL.equals(newproducto)){
//                throw new ClassNotFoundException("El PRODUCTO que intenta añadir ya se encuentra registrado");
//            }
//        }
//        productos.add(newproducto);
        ProductoJpaController.create(newproducto);
    }

    public void eliminarProducto (Producto producto){
            //        productos.remove(producto);
        try{
            MecanicoJpaController.destroy(producto.getCodigo());
        }catch(NonexistentEntityException ex) {
            Logger.getLogger(Taller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarServico (Servicio newservicio) throws Exception{
//        for (Servicio servicioL : servicios) {
//            if (servicioL.equals(newservicio)){
//                throw new ClassNotFoundException("El SERVICIO que intenta añadir"
//                        + " al TALLER ya se encuentra registrado");
//            }
//        }
//        servicios.add(newservicio);
        ServicioJpaController.create(newservicio);
    }

    public void eliminarServico (Servicio servicio){
//        servicios.remove(servicio);
        try{
            this.ServicioJpaController.destroy(servicio.getCodigo());
        }catch(NonexistentEntityException ex){
            Logger.getLogger(Taller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarRealizado (Mantenimiento newrealizado) throws Exception{
//        for (Mantenimiento realizadoL : manteRealizados) {
//            if (realizadoL.equals(newrealizado)){
//                throw new ClassNotFoundException("El MANTENIMIENTO REALIZADO que intenta añadir ya se encuentra registrado");
//            }
//        }
//        manteRealizados.add(newrealizado);
        mantenimientoJpaController.create(newrealizado);
    }
    
    public void eliminarRealizado (Mantenimiento realizado){
//        manteRealizados.remove(realizado);
        try{
            mantenimientoJpaController.destroy(nit);
        }catch(NonexistentEntityException ex){
            Logger.getLogger(Taller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarPendiente (Mantenimiento newpendiente) throws Exception{
//        for (Mantenimiento pendienteL : mantePendientes) {
//            if (pendienteL.equals(newpendiente)){
//                throw new ClassNotFoundException("El MANTENIMIENTO PENDIENTE que intenta añadir ya se encuentra registrado");
//            }
//        }
//        mantePendientes.add(newpendiente);
        mantenimientoJpaController.create(newpendiente);
    }
    
    public void eliminarPendiente (Mantenimiento pendiente){
//        mantePendientes.remove(pendiente);
        try {
            mantenimientoJpaController.destroy(nit);
        }catch(NonexistentEntityException ex){
            Logger.getLogger(Taller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarVehiculo (Vehiculo newvehiculo) throws Exception{
//        for (Vehiculo vehiculoL : VehiculoJpaController.findVehiculoEntities()){
//            if (vehiculoL.equals(newvehiculo)){
//                throw new ClassNotFoundException("El VEHÍCULO con placa: ["
//                    +newvehiculo.getPlaca()+"] ya se encuentra registrado");
//            }
//        }
        VehiculoJpaController.create(newvehiculo);
    }
    
    public void eliminarVehiculo (Vehiculo vehiculo){
        try{
            VehiculoJpaController.destroy(nombre);
        }catch(NonexistentEntityException ex){
            Logger.getLogger(Taller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // METODOS DE BUSQUEDA
    public Mantenimiento buscarMantenimientoPlaca(String placa) throws Exception{
        placa = placa.trim();
        placa = placa.toUpperCase();
        for (Mantenimiento mantenimientoL : mantenimientoJpaController.findMantenimientoEntities()){
            if(mantenimientoL.getVehiculo().getPlaca().equals(placa)){
                return mantenimientoJpaController.findMantenimiento(nit);
            }
        }
        throw new ClassNotFoundException("No se ha encontrado el MANTENIMIENTO "
                + "PENDIENTE con la PLACA: "+placa);
    }
    
    public Vehiculo buscarVehiculoPlaca(String placa) throws Exception{
        placa = placa.trim();
        placa = placa.toUpperCase();
        if (!(placa.length() == 6)){
            throw new ClassNotFoundException("La PLACA ingresada NO es válida (6 caracteres)");
        }
        for (Vehiculo vehiculoL : VehiculoJpaController.findVehiculoEntities()){
            if(vehiculoL.getPlaca().equals(placa)){
                return VehiculoJpaController.findVehiculo(placa);
            }
        }
        throw new ClassNotFoundException("El VEHÍCULO con placa: "
                    +placa+" NO SE ENCONTRÓ");
    }
    
    public Producto buscarProducto(int codigo) throws Exception{
        for (Producto productoL : ProductoJpaController.findProductoEntities()){
            if(productoL.getCodigo() == codigo){
                return ProductoJpaController.findProducto(codigo);
            }
        }
        throw new ClassNotFoundException("No se ha encontrado el PRODUCTO "
                + "del codigo: "+codigo);
    }
}