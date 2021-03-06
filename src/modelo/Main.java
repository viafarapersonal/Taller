package modelo;
import java.time.LocalDate;
import vista.PrincipalUI;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
public class Main{
    public static void main(String[] args) throws Exception{
        Taller tall = new Taller(111L, "F&F Car WorkShop");
        
        Servicio s1 = new Servicio(1, "Cambio de Aceite", 10000);
        tall.agregarServico(s1);
        tall.agregarServico(new Servicio(2, "Balanceo", 65500));
        tall.agregarServico(new Servicio(3, "Limpieza Interior", 18000));
        
        tall.agregarProducto(new Producto(1, "Aceite", 25000));
        tall.agregarProducto(new Producto(2, "Brillador", 5000));
        tall.agregarProducto(new Producto(3, "Llantas x4", 180000));
        
        tall.agregarVehiculo(new Vehiculo("abc123", MarcaVehiculo.MINI, "Anda",
            1999, TipoVehiculo.EJECUTIVO, 
            new Propietario(3211237L, "Ananai", "Jija", 1233211231L)));
        
        Propietario p1 = new Propietario(1231231L, "Sr a", "Prueba", 1231231231L);
        Vehiculo vh1 = new Vehiculo("123123", MarcaVehiculo.BMW, "Mainkra",
            2021, TipoVehiculo.DEPORTIVO, p1);
        tall.agregarVehiculo(vh1);
        
        Mecanico mecanic1 = new Mecanico(1111111111L, "Juan", "Uno", 1010101010L);
        Mecanico mecanic2 = new Mecanico(1111111112L, "Pedro", "Dos", 1010101010L);
        Mecanico mecanic3 = new Mecanico(1111111113L, "Tirdht", "Tres", 1010101010L);
        
        tall.agregarMecanico(mecanic1);
        tall.agregarMecanico(mecanic2);
        tall.agregarMecanico(mecanic3);
        
        Mantenimiento m1 = new Mantenimiento(LocalDate.now(), mecanic1, vh1);
        m1.agregarServico(s1);
        tall.agregarPendiente(m1);
        
        PrincipalUI ventPrincipal = new PrincipalUI(tall);
        ventPrincipal.setVisible(true);
    }
}