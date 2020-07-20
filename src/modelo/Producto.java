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
public class Producto {
    
    private int codigo;
    private String nombre;
    private int costo;

    public Producto(int codigo, String nombre, int costo) throws Exception {
        
        if (nombre == null || nombre.equals("".trim())) {
            throw new Exception("Rellena el campo correctamente");
        }
        
        if (costo < 0) {
            throw new Exception("Rellena el campo correctamente");
        }
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
}
