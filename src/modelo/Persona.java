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
public class Persona {
    
    private long nuip;
    private String nombre;
    private String apellido;
    private long telefono;

    public Persona(long nuip, String nombre, String apellido, long telefono) throws Exception {
        
        if (nombre == null || nombre.equals("".trim())) {
            throw new Exception("Rellena el campo correctamente");
        }
        
        if (apellido == null || apellido.equals("".trim())) {
            throw new Exception("Rellena el campo correctamente");
        }
        
        this.nuip = nuip;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        
    }

    public long getNuip() {
        return nuip;
    }

    public void setNuip(long nuip) {
        this.nuip = nuip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
}
