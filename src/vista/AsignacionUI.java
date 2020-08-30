package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;
import modelo.Mantenimiento;
import modelo.Persona;
import modelo.Taller;

/*  Author:  Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
public class AsignacionUI extends javax.swing.JInternalFrame {
    //Atributos
    private Taller taller;
    private LinkedList<Mantenimiento> mantenimientos = new LinkedList<>();
    private LinkedList<Persona> mecanicos = new LinkedList<>();
    //Constructor de la ventana Ingreso
    public AsignacionUI(Taller taller){
        this.taller = taller;
        initComponents();
        setTitle("Asignación de Mecánico");
        setClosable(true);
        
        mantenimientos = taller.getMantePendientes();
        mecanicos = taller.getMecanicosLibres();
        
        this.tbSolicitudes.setModel(new AbstractTableModel() {

            private String[] nombres = {"Placa", "Marca", "Servicios"};

            @Override
            public String getColumnName(int column) {
                return this.nombres[column];
            }

            @Override
            public int getRowCount() {
                return mantenimientos.size();
            }

            @Override
            public int getColumnCount() {
                return this.nombres.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Mantenimiento mantenimiento = mantenimientos.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return mantenimiento.getVehiculo().getPlaca();
                    case 1:
                        return mantenimiento.getVehiculo().getMarca();
                    case 2:
                        return mantenimiento.getServicios();
                }
                return null;
            }
        });
        
        this.cbMecanicos.setModel(new ComboBoxModel() {

            private Object selected = null;

            @Override
            public void setSelectedItem(Object anItem) {
                this.selected = anItem;
            }

            @Override
            public Object getSelectedItem() {
                return this.selected;
            }

            @Override
            public int getSize() {
                return mecanicos.size();
            }

            @Override
            public Object getElementAt(int index) {
                return mecanicos.get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l) {
            }

            @Override
            public void removeListDataListener(ListDataListener l) {
            }
        });
        
        this.cbMecanicos.setSelectedItem(null);
        
        this.btAsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Mantenimiento mantenimientoSeleccionado = null;
                    Persona mecanicoSeleccionado = null;
                    mantenimientoSeleccionado.setMecanico(mecanicoSeleccionado);
                    mantenimientos.remove(mantenimientoSeleccionado);
                    mecanicos.remove(mecanicoSeleccionado);
                    tbSolicitudes.updateUI();
                    cbMecanicos.updateUI();
                    cbMecanicos.setSelectedItem(null);
                } catch (Exception ex) {
                    Logger.getLogger(AsignacionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSolicitudes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cbMecanicos = new javax.swing.JComboBox<>();
        btAsignar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Asignación de Mecanico");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Solicitudes No Asignadas");

        tbSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tbSolicitudes);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mecanicos:");

        cbMecanicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btAsignar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btAsignar.setText("Asignar Mecanico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbMecanicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbMecanicos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAsignar;
    private javax.swing.JComboBox<String> cbMecanicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSolicitudes;
    // End of variables declaration//GEN-END:variables
}
