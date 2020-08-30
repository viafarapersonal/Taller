package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.Taller;
/*  Author:  Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
public class PrincipalUI extends javax.swing.JFrame{
    //Atributos
    private Taller taller;
    //Constructor de la ventana PrincipalUI
    public PrincipalUI(Taller taller){
        this.taller = taller;
        initComponents();
        this.setTitle("Auto Workshop");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        miIngresoVehiculo.addActionListener(new IngresoVehiculoListener());
        miAsigMecanic.addActionListener(new AisignaMecanicoListener());
        miRegisProducto.addActionListener(new RegisProductoListener());
        miFacturacion.addActionListener(new FacturaciónListener());
        miServicios.addActionListener(new ServiciosListener());
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mSolicitudes = new javax.swing.JMenu();
        miIngresoVehiculo = new javax.swing.JMenuItem();
        mMantenimiento = new javax.swing.JMenu();
        miAsigMecanic = new javax.swing.JMenuItem();
        mFacturación = new javax.swing.JMenu();
        miRegisProducto = new javax.swing.JMenuItem();
        miFacturacion = new javax.swing.JMenuItem();
        mAyuda = new javax.swing.JMenu();
        miServicios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        mSolicitudes.setText("Solicitudes");

        miIngresoVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miIngresoVehiculo.setText("Ingreso de Vehículo");
        mSolicitudes.add(miIngresoVehiculo);

        jMenuBar1.add(mSolicitudes);

        mMantenimiento.setText("Mantenimiento");

        miAsigMecanic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miAsigMecanic.setText("Asignación de Mecánico");
        mMantenimiento.add(miAsigMecanic);

        jMenuBar1.add(mMantenimiento);

        mFacturación.setText("Facturacion");

        miRegisProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miRegisProducto.setText("Registro Productos");
        mFacturación.add(miRegisProducto);

        miFacturacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miFacturacion.setText("Facturación");
        mFacturación.add(miFacturacion);

        jMenuBar1.add(mFacturación);

        mAyuda.setText("Ayuda");

        miServicios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miServicios.setText("Ver servicios solicitados y facturados");
        mAyuda.add(miServicios);

        jMenuBar1.add(mAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenu mFacturación;
    private javax.swing.JMenu mMantenimiento;
    private javax.swing.JMenu mSolicitudes;
    private javax.swing.JMenuItem miAsigMecanic;
    private javax.swing.JMenuItem miFacturacion;
    private javax.swing.JMenuItem miIngresoVehiculo;
    private javax.swing.JMenuItem miRegisProducto;
    private javax.swing.JMenuItem miServicios;
    // End of variables declaration//GEN-END:variables

    public class IngresoVehiculoListener implements ActionListener {
        private IngresoUI ingreso = null;
        @Override
        public void actionPerformed(ActionEvent e){
            if (this.ingreso == null){
                this.ingreso = new IngresoUI(taller);
                jDesktopPane1.add(ingreso);
            }
            ingreso.setVisible(true);
        }
    }

    public class AisignaMecanicoListener implements ActionListener{
        private AsignacionUI asign = null;
        @Override
        public void actionPerformed(ActionEvent e){
            if (this.asign == null){
                this.asign = new AsignacionUI();
                jDesktopPane1.add(asign);
            }
            asign.setVisible(true);
        }
    }

    public class RegisProductoListener implements ActionListener{
        private RegistroUI regist = null;
        @Override
        public void actionPerformed(ActionEvent e){
            if (this.regist == null){
                this.regist = new RegistroUI();
                jDesktopPane1.add(regist);
            }
            regist.setVisible(true);
        }
    }
    
    public class FacturaciónListener implements ActionListener{
        private FacturacionUI factu = null;
        @Override
        public void actionPerformed(ActionEvent e){
            if (this.factu == null){
                this.factu = new FacturacionUI();
                jDesktopPane1.add(factu);
            }
            factu.setVisible(true);
        }
    }

    public class ServiciosListener implements ActionListener{
        private ServiciosUI servicios = null;
        @Override
        public void actionPerformed(ActionEvent e){
            if (this.servicios == null){
                this.servicios = new ServiciosUI(taller);
                jDesktopPane1.add(servicios);
            }
            servicios.setVisible(true);
        }
    }
}