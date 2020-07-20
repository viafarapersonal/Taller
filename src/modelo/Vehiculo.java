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
public class Vehiculo {
    
    private String placa;
    private String marca;
    private String linea;
    private short año;
    private TipoVehiculo tipoVehiculo;
    private Persona persona;

    public Vehiculo(String placa, String marca, String linea, short año, TipoVehiculo tipoVehiculo, Persona persona) throws Exception {
        
        if (placa == null || placa.equals("".trim())) {
            throw new Exception("Rellena el campo correctamente");
        }
        
        if (marca == null || marca.equals("".trim())) {
            throw new Exception("Rellena el campo correctamente");
        }
        
        if (linea == null || linea.equals("".trim())) {
            throw new Exception("Rellena el campo correctamente");
        }
        
        if (año < 1800) {
            throw new Exception("Rellena el campo correctamente");
        }
        
        this.placa = placa;
        this.marca = marca;
        this.linea = linea;
        this.año = año;
        this.tipoVehiculo = tipoVehiculo;
        this.persona = persona;
        
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public short getAño() {
        return año;
    }

    public void setAño(short año) {
        this.año = año;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
