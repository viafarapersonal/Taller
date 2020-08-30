package modelo;
import vista.PrincipalUI;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Taller tall = new Taller(111, "F&F Car WorkShop");
        
        tall.agregarServico(new Servicio(1, "Cambio de Aceite", 10000));
        
        tall.agregarVehiculo(new Vehiculo("123123", MarcaVehiculo.BMW, "Mainkra",
            2021, TipoVehiculo.DEPORTIVO, 
            new Persona(1231231L, "Sr a", "Prueba", 1231231231L)));
        
        PrincipalUI ventPrincipal = new PrincipalUI(tall);
        ventPrincipal.setVisible(true);
    }
}