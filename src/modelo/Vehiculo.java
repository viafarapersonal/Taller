package modelo;
import java.io.Serializable;
import java.time.Year;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */

@Entity
public class Vehiculo implements Serializable{
    // Definición de atributos
    @Id
    private String placa;
    @Column(nullable = false, length = 50)
    private String linea;
    @Column(nullable = false)
    private int modelo;
    @Column(nullable = false)
    private MarcaVehiculo marca;
    @Column(nullable = false)
    private TipoVehiculo tipoVehiculo;
    @OneToOne(cascade = CascadeType.ALL)
    private Propietario propietario;

    // Constructores
    public Vehiculo(){
    }
    
    public Vehiculo(String placa, MarcaVehiculo marca, String linea, int modelo, TipoVehiculo tipoVehiculo, Propietario propietario) throws Exception{
        setPlaca(placa);
        setMarca(marca);
        setLinea(linea);
        setModelo(modelo);
        setTipoVehiculo(tipoVehiculo);
        setPersonaPropietaria(propietario);
    }
    
    // Definición de los métodos
    // Implementación de validación de valores en los metodos Set
    public String getPlaca(){
        return placa;
    }
    
    public void setPlaca(String placa) throws Exception{
        placa = placa.trim();
        placa = placa.toUpperCase();
        if (placa == null || "".equals(placa)){
            throw new ClassNotFoundException("Debe ingresar una PLACA");
        }
        if (!(placa.length() == 6)){
            throw new ClassNotFoundException("La PLACA ingresada NO es válida (6 caracteres)");
        }
        this.placa = placa;
    }
    
    public MarcaVehiculo getMarca(){
        return marca;
    }
    
    public void setMarca(MarcaVehiculo marca) throws Exception{
        if (marca == null){
            throw new ClassNotFoundException("Debe ingresar una MARCA del Vehículo");
        }
        this.marca = marca;
    }
    
    public String getLinea(){
        return linea;
    }
    
    public void setLinea(String linea) throws Exception{
        linea = linea.trim();
        if (linea == null || "".equals(linea)){
            throw new ClassNotFoundException("Debe ingresar una LINEA del Vehículo");
        }
        this.linea = linea;
    }
    
    public int getModelo(){
        return modelo;
    }
    
    public void setModelo(int modelo) throws Exception{
        if (modelo < 1900 || modelo > (Year.now().getValue()+1)){
            throw new ClassNotFoundException("El AÑO ingresado NO es válido "
                    + "(sólo se aceptan de 1900 en adelante");
        }
        this.modelo = modelo;
    }
    
    public TipoVehiculo getTipoVehiculo(){
        return tipoVehiculo;
    }
    
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo)throws Exception{
        if (tipoVehiculo == null){
            throw new ClassNotFoundException("Debe ingresar un TIPO de Vehículo");
        }
        this.tipoVehiculo = tipoVehiculo;
    }
    
    public Propietario getPropietario(){
        return propietario;
    }
    
    public void setPersonaPropietaria(Propietario propietario) throws Exception{
        if (propietario == null){
            throw new ClassNotFoundException("Debe ingresar un CLIENTE/DUEÑO del vehículo");
        }
        this.propietario = propietario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.placa, other.placa)){
            return false;
        }
        return true;
    }
}