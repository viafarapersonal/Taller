package vista;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import modelo.Consumo;
import modelo.Mantenimiento;
import modelo.Taller;
import modelo.MarcaVehiculo;
import modelo.Persona;
import modelo.Producto;
import modelo.Servicio;
import modelo.TipoVehiculo;
import modelo.Vehiculo;
/*  Author: Alexander Viafara 
    <viafarapersonal@gmail.com>
    Author: Didier Stevenson Calvache Grajales
    <didiermaxilo3@gmail.com>
    Date: August 2020
 */
public class IngresoUI extends javax.swing.JInternalFrame{
    //Atributos
    private Taller taller;
    private Mantenimiento mantenimientoVehiculo;
    //Constructor de la ventana Ingreso
    public IngresoUI(Taller tall){
        this.taller = tall;
        this.mantenimientoVehiculo = new Mantenimiento();
        initComponents();
        setTitle("Ingreso de Vehículo");
        txfPlaca.addActionListener(new BuscarVehiculoListener());
        btnRegisVehiculo.addActionListener(new RegistrarVehiculoListener());
        btnAgregServicio.addActionListener(new AgregarServicioListener());
        btnIngreVehiculo.addActionListener(new IngresarVehiculoListener());
        btnCancelar.addActionListener(new CancelarListener());
        
        this.cboxServicios.setModel(new ComboBoxModel<Servicio>(){
            private Servicio servicioSeleccionado;
            @Override
            public void setSelectedItem(Object anItem){
                this.servicioSeleccionado = (Servicio)anItem;
                cboxServicios.updateUI();
            }
            @Override
            public Object getSelectedItem(){
                return this.servicioSeleccionado;
            }
            @Override
            public int getSize(){
                return taller.getServicios().size();
            }
            @Override
            public Servicio getElementAt(int index){
                return taller.getServicios().get(index);
            }
            @Override
            public void addListDataListener(ListDataListener l){}
            @Override
            public void removeListDataListener(ListDataListener l){}
            });
        this.jlServicios.setModel(new ListModel<Servicio>(){
            @Override
            public int getSize(){
                return mantenimientoVehiculo.getServicios().size();
            }

            @Override
            public Servicio getElementAt(int index){
                return mantenimientoVehiculo.getServicios().get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l){}
            @Override
            public void removeListDataListener(ListDataListener l){}
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txfPlaca = new javax.swing.JTextField();
        cboxMarca = new javax.swing.JComboBox(MarcaVehiculo.values());
        cboxTipo = new javax.swing.JComboBox(TipoVehiculo.values());
        txfLinea = new javax.swing.JTextField();
        txfModelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txfNuip = new javax.swing.JTextField();
        txfNombre = new javax.swing.JTextField();
        txfApellido = new javax.swing.JTextField();
        txfTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnRegisVehiculo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cboxServicios = new javax.swing.JComboBox<>();
        btnAgregServicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlServicios = new javax.swing.JList<>();
        btnIngreVehiculo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingreso de vehiculos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehiculo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Placa:");

        txfPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfPlaca.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cboxMarca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboxMarca.setMaximumRowCount(20);

        cboxTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txfLinea.setEditable(false);
        txfLinea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfLinea.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txfModelo.setEditable(false);
        txfModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Marca:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tipo:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Linea:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Modelo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfModelo)
                    .addComponent(txfLinea)
                    .addComponent(cboxTipo, 0, 150, Short.MAX_VALUE)
                    .addComponent(cboxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfPlaca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cboxMarca.getAccessibleContext().setAccessibleParent(this);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Propietario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Nuip:");

        txfNuip.setEditable(false);
        txfNuip.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfNuip.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txfNombre.setEditable(false);
        txfNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txfApellido.setEditable(false);
        txfApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txfTelefono.setEditable(false);
        txfTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Nombre(s):");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Apellido(s):");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Telefono:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txfApellido)
                    .addComponent(txfNombre)
                    .addComponent(txfNuip))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txfNuip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegisVehiculo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegisVehiculo.setText("Registrar Vehiculo");
        btnRegisVehiculo.setEnabled(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Servicio(s) Solicitado(s)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        cboxServicios.setModel(new javax.swing.DefaultComboBoxModel<Servicio>());

        btnAgregServicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregServicio.setText("Agregar");

        jlServicios.setModel(new javax.swing.DefaultListModel<Servicio>());
        jScrollPane1.setViewportView(jlServicios);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cboxServicios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboxServicios)
                    .addComponent(btnAgregServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cboxServicios.getAccessibleContext().setAccessibleParent(this);

        btnIngreVehiculo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIngreVehiculo.setText("Ingresar Vehiculo");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegisVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnIngreVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegisVehiculo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnIngreVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregServicio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngreVehiculo;
    private javax.swing.JButton btnRegisVehiculo;
    private javax.swing.JComboBox<MarcaVehiculo> cboxMarca;
    private javax.swing.JComboBox<Servicio> cboxServicios;
    private javax.swing.JComboBox<TipoVehiculo> cboxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Servicio> jlServicios;
    private javax.swing.JTextField txfApellido;
    private javax.swing.JTextField txfLinea;
    private javax.swing.JTextField txfModelo;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfNuip;
    private javax.swing.JTextField txfPlaca;
    private javax.swing.JTextField txfTelefono;
    // End of variables declaration//GEN-END:variables

    public class BuscarVehiculoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                mantenimientoVehiculo = new Mantenimiento();
                jlServicios.updateUI();
                Vehiculo vehi = taller.buscarVehiculoPlaca(txfPlaca.getText());
                for(Mantenimiento mantenimientoL : taller.getMantePendientes()){
                    if(mantenimientoL.getVehiculo().equals(vehi)){
                        throw new IllegalAccessException("EL vehículo "
                            + "YA SE ENCUENTRA EN MANTENIMIENTO");
                    }
                }
                mantenimientoVehiculo.setVehiculo(vehi);
                cboxMarca.setSelectedItem(vehi.getMarca());
                cboxTipo.setSelectedItem(vehi.getTipoVehiculo());
                txfLinea.setText(vehi.getLinea());
                txfModelo.setText(String.valueOf(vehi.getModelo()));
                txfNuip.setText(vehi.getPersonaPropietaria().getNuip().toString());
                txfNombre.setText(vehi.getPersonaPropietaria().getNombre());
                txfApellido.setText(vehi.getPersonaPropietaria().getApellido());
                txfTelefono.setText(vehi.getPersonaPropietaria().getTelefono().toString());
            }catch(ClassNotFoundException exe){
                int op = JOptionPane.showConfirmDialog(IngresoUI.this, 
                    exe.getMessage()+", ¿Desea Registrar el Vehículo?",
                    "Vehiculo no Econtrado", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                if (op==JOptionPane.YES_OPTION){
                    habilitarCamposBtn(true);
                }
            }catch(IllegalAccessException exe){
                JOptionPane.showMessageDialog(IngresoUI.this,exe.getMessage());
            }catch(Exception exe){
                JOptionPane.showMessageDialog(IngresoUI.this, 
                    "Error inesperado (PONERSE EN CONTACTO CON PROVEEDORES)\n"
                    +exe.getMessage());
            }
        }
    }
    
    public class RegistrarVehiculoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                Vehiculo v = new Vehiculo(txfPlaca.getText(), 
                    (MarcaVehiculo)cboxMarca.getSelectedItem(), 
                    txfLinea.getText(), Short.parseShort(txfModelo.getText()), 
                    (TipoVehiculo)cboxTipo.getSelectedItem(),
                        new Persona(Long.parseLong(txfNuip.getText()), 
                        txfNombre.getText(), txfApellido.getText(), 
                        Long.parseLong(txfTelefono.getText()))
                    );
                taller.agregarVehiculo(v);
                JOptionPane.showMessageDialog(IngresoUI.this, 
                        "REGISTRO EXITOSO");
                habilitarCamposBtn(false);
                mantenimientoVehiculo.setVehiculo(v);
            }catch(NumberFormatException exe){
                JOptionPane.showMessageDialog(IngresoUI.this, 
                        "Formato incorrecto en algún campo que requiere números");
            }catch(ClassNotFoundException exe){
                JOptionPane.showMessageDialog(IngresoUI.this, exe.getMessage());
            }catch(Exception exe){
                JOptionPane.showMessageDialog(IngresoUI.this, 
                    "Error inesperado (PONERSE EN CONTACTO CON PROVEEDORES)\n"
                    +exe.getMessage());
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, exe);
            }
        }
    }

    public class AgregarServicioListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                for(Servicio servicioL : mantenimientoVehiculo.getServicios()){
                    if(servicioL.equals((Servicio)cboxServicios.getSelectedItem())){
                        throw new ClassNotFoundException("El servicio al vehículo"
                                + " YA SE ENCUENTRA AGREGADO");
                    }
                }
                if (cboxServicios.getSelectedItem() == null) {
                    throw new ClassNotFoundException("NO ha seleccionado"
                            + " un SERVICIO");
                }
                mantenimientoVehiculo.getServicios().add(
                    (Servicio)cboxServicios.getSelectedItem());
                jlServicios.updateUI();
            }catch(ClassNotFoundException exe){
                JOptionPane.showMessageDialog(IngresoUI.this, exe.getMessage());
            }catch(Exception exe){
                JOptionPane.showMessageDialog(IngresoUI.this, 
                    "Error inesperado (PONERSE EN CONTACTO CON PROVEEDORES)\n"
                    +exe.getMessage());
            }
        }
    }

    public class IngresarVehiculoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                if(mantenimientoVehiculo.getServicios().isEmpty()){
                    throw new ClassNotFoundException("No ha ingresado Servicios "
                        + "para el vehiculo");
                }else if(mantenimientoVehiculo.getVehiculo() == null){
                    throw new ClassNotFoundException("No ha ingresado un Vehiculo");
                }
                throw new InterruptedException("¿Seguro(a) desea ingresar"
                    +" a mantenimiento el vehiculo con placa: "
                    +mantenimientoVehiculo.getVehiculo().getPlaca()+"?");
            }catch(InterruptedException exe){
                int op = JOptionPane.showConfirmDialog(IngresoUI.this, exe.getMessage(),
                        "Confirmación de Ingreso",JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(op==JOptionPane.YES_OPTION){
                    taller.getMantePendientes().add(mantenimientoVehiculo);
                    limpiarCampos();
                    mantenimientoVehiculo = new Mantenimiento();
                    jlServicios.updateUI();
                    JOptionPane.showMessageDialog(IngresoUI.this, 
                            "Vehiculo INGRESADO SATISFACTORIAMENTE");
                }
            }catch(ClassNotFoundException exe){
                JOptionPane.showMessageDialog(IngresoUI.this, exe.getMessage());
            }catch(Exception exe){
                JOptionPane.showMessageDialog(IngresoUI.this, 
                    "Error inesperado (PONERSE EN CONTACTO CON PROVEEDORES)\n"
                    +exe.getMessage());
            }
        }
    }

    public class CancelarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            IngresoUI.this.setVisible(false);
        }
    }
    public void limpiarCampos(){
        txfPlaca.setText("");
        txfLinea.setText("");
        txfModelo.setText("");
        txfNuip.setText("");
        txfNombre.setText("");
        txfApellido.setText("");
        txfTelefono.setText("");
    }
    public void habilitarCamposBtn(boolean aFlag){
        txfLinea.setEditable(aFlag);
        txfModelo.setEditable(aFlag);
        txfNuip.setEditable(aFlag);
        txfNombre.setEditable(aFlag);
        txfApellido.setEditable(aFlag);
        txfTelefono.setEditable(aFlag);
        btnRegisVehiculo.setEnabled(aFlag);
    }

    @Override
    public void setVisible(boolean aFlag){
        if (aFlag != isVisible()){
            super.setVisible(aFlag);
            if (aFlag){
                Container parent = getParent();
                if (parent != null){
                    Rectangle r = getBounds();
                    parent.repaint(r.x, r.y, r.width, r.height);
                }
                revalidate();
            }
        }
        if(aFlag){
            habilitarCamposBtn(false);
            limpiarCampos();
            mantenimientoVehiculo.getServicios().clear();
        }
    }
}