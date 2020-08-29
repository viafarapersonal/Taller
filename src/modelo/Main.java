package modelo;
import vista.PrincipalUI;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
public class Main {
    public static void main(String[] args) {
        Taller tall = new Taller();
        
        PrincipalUI ventPrincipal = new PrincipalUI(tall);
        ventPrincipal.setVisible(true);
    }
}