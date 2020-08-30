package modelo;

import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */

public class Vehiculo{
    // Definición de atributos
    private String placa;
    private String marca;
    private String linea;
    private int modelo;
    private TipoVehiculo tipoVehiculo;
    private Persona personaPropietaria;

    // Constructores
    public Vehiculo(){
    }
    
    public Vehiculo(String placa, String marca, String linea, int modelo, TipoVehiculo tipoVehiculo, Persona persona) throws Exception{
        setPlaca(placa);
        setMarca(marca);
        setLinea(linea);
        setModelo(modelo);
        setTipoVehiculo(tipoVehiculo);
        setPersonaPropietaria(persona);
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
            throw new Exception("Debe ingresar una PLACA");
        }
        if (!(placa.length() == 6)){
            throw new Exception("La PLACA ingresada NO es válida (6 caracteres");
        }
        this.placa = placa;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca) throws Exception{
        marca = marca.trim();
        if (marca == null || "".equals(marca)){
            throw new Exception("Debe ingresar una MARCA del Vehículo");
        }
        this.marca = marca;
    }
    
    public String getLinea(){
        return linea;
    }
    
    public void setLinea(String linea) throws Exception{
        linea = linea.trim();
        if (linea == null || "".equals(linea)){
            throw new Exception("Debe ingresar una LINEA del Vehículo");
        }
        this.linea = linea;
    }
    
    public int getModelo(){
        return modelo;
    }
    
    public void setModelo(int modelo) throws Exception{
        if (modelo < 1900 || modelo > (Year.now().getValue()+1)){
            throw new Exception("El AÑO ingresado NO es válido "
                    + "(sólo se aceptan de 1900 en adelante");
        }
        this.modelo = modelo;
    }
    
    public TipoVehiculo getTipoVehiculo(){
        return tipoVehiculo;
    }
    
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo)throws Exception{
        if (tipoVehiculo == null){
            throw new Exception("Debe ingresar un TIPO de Vehículo");
        }
        this.tipoVehiculo = tipoVehiculo;
    }
    
    public Persona getPersonaPropietaria(){
        return personaPropietaria;
    }
    
    public void setPersonaPropietaria(Persona personaPropietaria) throws Exception{
        if (personaPropietaria == null){
            throw new Exception("Debe ingresar un CLIENTE/DUEÑO del vehículo");
        }
        this.personaPropietaria = personaPropietaria;
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
        if (!Objects.equals(this.placa.toUpperCase(), other.placa.toUpperCase())) {
            return false;
        }
        return true;
    }
    
}