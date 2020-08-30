package vista;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import modelo.Mantenimiento;
import modelo.Taller;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
public class ServiciosUI extends javax.swing.JInternalFrame{
    //Atributos
    private Taller taller;
    //Constructor de la ventana Ingreso
    public ServiciosUI(Taller taller){
        this.taller = taller;
        setTitle("TOTALIDAD DE SERVICIOS");
        initComponents();
        setClosable(true);
        
//        this.jlPendientes.setModel(new ListModel<Mantenimiento>(){
//            @Override
//            public int getSize(){
//                return taller.getMantePendientes().size();
//            }
//
//            @Override
//            public Mantenimiento getElementAt(int index){
//                return taller.getMantePendientes().get(index);
//            }
//
//            @Override
//            public void addListDataListener(ListDataListener l){
//            }
//            @Override
//            public void removeListDataListener(ListDataListener l) {
//            }
//        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPendientes = new javax.swing.JButton();
        btnRealizados = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlRealizados = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlPendientes = new javax.swing.JList<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Servicios");

        btnPendientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPendientes.setText("PENDIENTES");

        btnRealizados.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRealizados.setText("REALIZADOS");

        jlRealizados.setModel(new javax.swing.DefaultComboBoxModel<Mantenimiento>());
        jScrollPane1.setViewportView(jlRealizados);

        jlPendientes.setModel(new javax.swing.DefaultListModel<Mantenimiento>());
        jlPendientes.setToolTipText("");
        jScrollPane2.setViewportView(jlPendientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnPendientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRealizados)
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPendientes)
                    .addComponent(btnRealizados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPendientes;
    private javax.swing.JButton btnRealizados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Mantenimiento> jlPendientes;
    private javax.swing.JList<Mantenimiento> jlRealizados;
    // End of variables declaration//GEN-END:variables
    
}