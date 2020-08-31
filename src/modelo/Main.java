package modelo;
import java.time.LocalDate;
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
        
        Servicio s1 = new Servicio(1, "Cambio de Aceite", 10000);
        tall.agregarServico(s1);
        tall.agregarServico(new Servicio(2, "Balanceo", 65500));
        tall.agregarServico(new Servicio(3, "Limpieza Interior", 18000));
        
        tall.agregarProducto(new Producto(1, "Aceite", 25000));
        tall.agregarProducto(new Producto(2, "Brillador", 5000));
        tall.agregarProducto(new Producto(3, "Llantas x4", 180000));
        
        Persona p1 = new Persona(1231231L, "Sr a", "Prueba", 1231231231L);
        Vehiculo vh1 = new Vehiculo("123123", MarcaVehiculo.BMW, "Mainkra",
            2021, TipoVehiculo.DEPORTIVO, p1);
        
        tall.agregarVehiculo(vh1);
        
        Persona mecanic1 = new Persona(1111111111L, "Juan", "Uno", 1010101010L);
        
        tall.agregarVehiculo(new Vehiculo("abc123", MarcaVehiculo.MINI, "Anda",
            1999, TipoVehiculo.EJECUTIVO, 
            new Persona(3211237L, "Ananai", "Jija", 1233211231L)));
        Mantenimiento m1 = new Mantenimiento(LocalDate.MAX, mecanic1, vh1);
        m1.agregarServico(s1);
        tall.agregarPendiente(m1);
        
        Persona mecanic2 = new Persona(1111111112L, "Pedro", "Dos", 1010101010L);
        Persona mecanic3 = new Persona(1111111113L, "Tirdht", "Tres", 1010101010L);
        
        tall.agregarMecanico(mecanic1);
        tall.agregarMecanico(mecanic2);
        tall.agregarMecanico(mecanic3);
        
        PrincipalUI ventPrincipal = new PrincipalUI(tall);
        ventPrincipal.setVisible(true);
    }
}