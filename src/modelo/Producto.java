package modelo;
/*  Author:  Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: July 2020
 */

public class Producto{
    // Definición de atributos
    private int codigo;
    private String nombre;
    private int costo;

    // Constructores
    public Producto(){
    }
    
    public Producto(int codigo, String nombre, int costo) throws Exception{
        setCodigo(codigo);
        setNombre(nombre);
        setCosto(costo);
    }

    // Definición de los métodos
    // Implementación de validación de valores en los metodos Set
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo) throws Exception{
        if(codigo <= 0){
            throw new Exception("El Código del PRODUCTO debe ser ENTERO POSITIVO");
        }
        this.codigo = codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre) throws Exception{
        nombre = nombre.trim();
        if(nombre == null || "".equals(nombre)){
            throw new Exception("El Nombre del PRODUCTO NO debe ser valor null o cadena vacía");
        }
        this.nombre = nombre;
    }
    
    public int getCosto(){
        return costo;
    }
    
    public void setCosto(int costo) throws Exception{
        if(costo <= 0){
            throw new Exception("El COSTO del PRODUCTO debe ser ENTERO POSITIVO");
        }
        this.costo = costo;
    }
}