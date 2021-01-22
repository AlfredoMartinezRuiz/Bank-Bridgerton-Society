/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgerton.bank.society.GUI;

import static bridgerton.bank.society.BridgertonBankSociety.clientes;
import bridgerton.bank.society.Cliente;
import bridgerton.bank.society.GUI_Cajero.Cajero;
import bridgerton.bank.society.GUI_Cajero.Transferencia;
import bridgerton.bank.society.Transaccion;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

public class BancoListaTransacciones extends javax.swing.JFrame {
    // Array para la lista de transacciones
    private static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    
    // Herramientas para las fechas de filtro
    private static Date desde = new Date();
    private static Date hasta = new Date();
    private static boolean con_fecha = false;
    private static ImageIcon header = null;
    
    // Variables de ayuda para la posición de las ventanas
    private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    public BancoListaTransacciones() {
        toRelative("Header.jpg"); // lectura del header
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        fecha_label.setText("Fecha: " + new Date()); // Fecha actual
        timer.start();
        trans_timer.start();
    }
    
    // Función correctora de location 1
    private String toRelative(String name){
        URI p1 = null; // Variable de apoyo
        String directory =".\\src\\Files"; 
        File file = new File(directory);
        File[] archivos = file.listFiles();
        
        for(int i = 0; i<archivos.length; i++){
            if(archivos[i].getName().equals(name)){
                p1 = archivos[i].toURI(); // Cambia a URI primero
                URL p2 = null;
                
                try {
                    p2 = p1.toURL(); // Después cambia a URL
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
                }        
                header = new ImageIcon(p2);
                return archivos[i].getPath();
            }
        }
        return "";
    }
    
    private void transaccionesReader(){
        
        File file = new File(".\\src\\Files\\Transacciones.txt"); // Direccion del archivo de los clientes
        
        try {
            if(file.exists()){ 
                // Primero leemos si no está vacío
                if(file.length() > 0){
                   // Flujos y lectura de archivos
                    FileInputStream fin = new FileInputStream(file);
                    ObjectInputStream oin = new ObjectInputStream(fin);
                    transacciones = (ArrayList<Transaccion>) oin.readObject();
                    
                    oin.close();
                    fin.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }    
    }
    
    private void tabla(){ // Muestra la tabla normal
        DefaultTableModel model=(DefaultTableModel) tablaTransacciones.getModel();
        Date fecha_dato = new Date();
        
        // Borra la tabla anterior
        int index = 0;
        while(index < model.getRowCount()){
                model.removeRow(index); 
        }
        
        for(Transaccion t: transacciones){ // Recorre todas las transacciones
            if(con_fecha){ // Hay filtro de fecha
                fecha_dato = t.getFecha();
                
                if(fecha_dato.compareTo(desde) >= 0 && fecha_dato.compareTo(hasta) <= 0){ // Si es el mismo día o despúes de la fecha
                    model=(DefaultTableModel) tablaTransacciones.getModel(); // Crea el modelo de la tabla a partir del actual

                    Object[] fila = new Object[8]; // Crea el objeto de celdas para agregar
                    fila[0] = t.getTrans();
                    fila[1] = t.getFecha();
                    fila[2] = t.getTipo();
                    fila[3] = t.getMotivo();
                    fila[4] = t.getEmisora();
                    fila[5] = t.getDestino();
                    fila[6] = "" + t.getMonto();
                    model.addRow(fila); // Agrega la fila al modelo de la tabla
                    tablaTransacciones.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 
                }                
            }
            else{
                    model=(DefaultTableModel) tablaTransacciones.getModel(); // Crea el modelo de la tabla a partir del actual

                    Object[] fila = new Object[8]; // Crea el objeto de celdas para agregar
                    fila[0] = t.getTrans();
                    fila[1] = t.getFecha();
                    fila[2] = t.getTipo();
                    fila[3] = t.getMotivo();
                    fila[4] = t.getEmisora();
                    fila[5] = t.getDestino();
                    fila[6] = "" + t.getMonto();
                    model.addRow(fila); // Agrega la fila al modelo de la tabla
                    tablaTransacciones.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos
            }
        } 
    }
    
    private void tabla(Date desde, Date hasta){
        DefaultTableModel model=(DefaultTableModel) tablaTransacciones.getModel();
        
        // Borra la tabla anterior
        int index = 0;
        while(index < model.getRowCount()){
                model.removeRow(index); 
        }
        
        for(Transaccion t: transacciones){ // Recorre todos las transacciones
                      
        } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Confirmacion = new javax.swing.JDialog();
        message = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        Error = new javax.swing.JDialog();
        messageError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnLClientes = new javax.swing.JButton();
        btnLTrans = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fecha_label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDesde = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHasta = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTransacciones = new javax.swing.JTable();
        btn_elfilltro = new javax.swing.JButton();

        Confirmacion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Confirmacion.setMinimumSize(new java.awt.Dimension(0, 150));
        Confirmacion.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ConfirmacionWindowClosing(evt);
            }
        });

        message.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        message.setForeground(new java.awt.Color(255, 0, 0));
        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message.setText("¿Está seguro?");

        btnSi.setText("SÍ");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });

        btnNo.setText("NO");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConfirmacionLayout = new javax.swing.GroupLayout(Confirmacion.getContentPane());
        Confirmacion.getContentPane().setLayout(ConfirmacionLayout);
        ConfirmacionLayout.setHorizontalGroup(
            ConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConfirmacionLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        ConfirmacionLayout.setVerticalGroup(
            ConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmacionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNo)
                    .addComponent(btnSi))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        Error.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Error.setAlwaysOnTop(true);
        Error.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Error.setResizable(false);
        Error.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ErrorWindowClosing(evt);
            }
        });

        messageError.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        messageError.setForeground(new java.awt.Color(255, 0, 0));
        messageError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ErrorLayout = new javax.swing.GroupLayout(Error.getContentPane());
        Error.getContentPane().setLayout(ErrorLayout);
        ErrorLayout.setHorizontalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageError, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        ErrorLayout.setVerticalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(messageError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BancoListaTransacciones");
        setBackground(new java.awt.Color(206, 147, 216));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setIcon(header);

        btnLClientes.setBackground(new java.awt.Color(77, 182, 172));
        btnLClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLClientes.setText("Listado de clientes");
        btnLClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLClientesActionPerformed(evt);
            }
        });

        btnLTrans.setBackground(new java.awt.Color(77, 182, 172));
        btnLTrans.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLTrans.setText("Listado de transacciones en tiempo real");
        btnLTrans.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLTransActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Listado de Transacciones");

        fecha_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fecha_label.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(532, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(528, 528, 528))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(fecha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fecha_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Desde (dd-mm-yy):");

        txtDesde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yy"))));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Hasta (dd-mm-yy):");

        txtHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yy"))));
        txtHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHastaActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaTransacciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Transacción", "Fecha", "Tipo", "Motivo", "No. Cuenta", "No. Cuenta (destino)", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTransacciones.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaTransacciones);

        btn_elfilltro.setText("Eliminar filtro");
        btn_elfilltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elfilltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1379, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_elfilltro))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnLTrans, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btn_elfilltro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLClientesActionPerformed
        // Botón para ir a la lista de clientes
        BancoListaClientes bcts = new BancoListaClientes();
        bcts.setVisible(true);
        timer.stop();
        trans_timer.stop();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnLClientesActionPerformed

    private void btnLTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLTransActionPerformed
        // Botón para actualizar la ventana de transacciones
        BancoListaTransacciones blts= new BancoListaTransacciones();
        blts.setVisible(true);
        timer.stop();
        trans_timer.stop();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnLTransActionPerformed

    private void txtHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHastaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy"); // formateamos la fecha para que se ingrese en número
        boolean errors = false; // auxiliar para detectar errores en la captura
        
        try { // FECHA DESDE
            if(txtDesde.getText().equals("") == true){
                messageError.setText("Falta Fecha desde o está mal");
                errors = true;
            }
            else
            desde = sdf.parse(txtDesde.getText()); // Convierte el String de la casilla a fecha simple 
            
        } catch (ParseException ex) {
            messageError.setText("Falta Fecha desde o está mal");
            errors = true;
            Logger.getLogger(AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try { // FECHA HASTA
            if(txtHasta.getText().equals("") == true){
                messageError.setText("Falta Fecha hasta o está mal");
                errors = true;
            }
            else
            hasta = sdf.parse(txtHasta.getText()); // Convierte el String de la casilla a fecha simple 
            
        } catch (ParseException ex) {
            messageError.setText("Falta Fecha hasta o está mal");
            errors = true;
            Logger.getLogger(AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(errors){ // Si hay algún error, mostrará la ventana con el error antes asignado
            Error.setVisible(true);
            Error.setSize(310, 90);
            Error.setLocation(ancho/2 - 160, alto/2 - 45);
        }
        else{
            // Botón para abrir la lista de transacciones con filtro
            con_fecha = true;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        // Si se confirma, entonces se cerrará todo
        Confirmacion.setVisible(false);
        Confirmacion.dispose();
        timer.stop();
        trans_timer.stop();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSiActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        // Si se aprieta que no, ventana de confirmación entonces reaparecerá ListaClientes
        this.setVisible(true);
        Confirmacion.setVisible(false);
        Confirmacion.dispose();
    }//GEN-LAST:event_btnNoActionPerformed

    private void ConfirmacionWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ConfirmacionWindowClosing
        // Si se cierra la ventana de confirmación entonces reaparecerá ListaClientes
        this.setVisible(true);
        Confirmacion.setVisible(false);
        Confirmacion.dispose();
    }//GEN-LAST:event_ConfirmacionWindowClosing

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Si se cierra mostrará el mensaje de confirmación
        Confirmacion.setVisible(true);
        Confirmacion.setSize(310, 90);
        Confirmacion.setLocation(ancho/2 - 160, alto/2 - 45);
    }//GEN-LAST:event_formWindowClosing

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
        Error.dispose();
    }//GEN-LAST:event_ErrorWindowClosing

    private void btn_elfilltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elfilltroActionPerformed
        con_fecha = false;
    }//GEN-LAST:event_btn_elfilltroActionPerformed
    Timer timer = new Timer (1000, new ActionListener (){ // Encargado de actualizar la hora
            public void actionPerformed(ActionEvent e) {
               fecha_label.setText("Fecha: " + new Date());
            }           
    });
    
    Timer trans_timer = new Timer (100, new ActionListener (){ // Encargado de mostrar la tabla normal
            public void actionPerformed(ActionEvent e) {
               transaccionesReader();
               tabla();
            }           
    });
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BancoListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BancoListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BancoListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BancoListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BancoListaTransacciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Confirmacion;
    private javax.swing.JDialog Error;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLClientes;
    private javax.swing.JButton btnLTrans;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JButton btn_elfilltro;
    private javax.swing.JLabel fecha_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel message;
    private javax.swing.JLabel messageError;
    private javax.swing.JTable tablaTransacciones;
    private javax.swing.JFormattedTextField txtDesde;
    private javax.swing.JFormattedTextField txtHasta;
    // End of variables declaration//GEN-END:variables
}
