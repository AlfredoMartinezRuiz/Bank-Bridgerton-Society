
package bridgerton.bank.society.GUI;

import bridgerton.bank.society.Cliente;
import bridgerton.bank.society.Cliente.Cuenta;
import bridgerton.bank.society.Transaccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class ClienteTrans extends javax.swing.JFrame {
    // Array para la lista de transacciones
    private static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    private static ArrayList<Cliente.Cuenta> cuentas = new ArrayList<Cliente.Cuenta>();
    
    // Herramientas para las fechas de filtro
    private static Date desde = new Date();
    private static Date hasta = new Date();
    private static boolean con_fecha = false;
    
    
    // Variables de ayuda para la posición de las ventanas
    private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    private static int idc;
    private static ClienteInt cint = null;
    
    public ClienteTrans(int idc, ClienteInt cint) {
        this.idc = idc;
        this.cint = cint;
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        trans_timer.start();
    }
    private void transaccionesReader(){
        ArrayList<Transaccion> trans = new ArrayList<Transaccion>();
        File file = new File(".\\src\\Files\\Transacciones.txt"); // Direccion del archivo de los clientes
        
        try {
            if(file.exists()){ 
                // Primero leemos si no está vacío
                if(file.length() > 0){
                   // Flujos y lectura de archivos
                    FileInputStream fin = new FileInputStream(file);
                    ObjectInputStream oin = new ObjectInputStream(fin);
                    trans = (ArrayList<Transaccion>) oin.readObject();
                    cuentaReader(idc);
                    transacciones =  new ArrayList<Transaccion>();
                    int id_ant = -1;
                    for(Transaccion t: trans){
                        if(isInCuentas(t.getDestino())){ // Comprobando si el destino está
                            if(t.getTrans() != id_ant){
                                id_ant = t.getTrans();
                                transacciones.add(t);
                            }                                
                            continue;
                        }
                        if(isInCuentas(t.getEmisora())){ // Comprobando si el destino está
                            if(t.getTrans() != id_ant){
                                id_ant = t.getTrans();
                                transacciones.add(t);
                            }  
                        }
                    }
                    
                    oin.close();
                    fin.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }    
    }
    private boolean isInCuentas(String numero){
        for(Cuenta c: cuentas){
            if(numero.equals(c.getClabe())){ // Comprobando si está entre las clabes
                return true;
            }
            if(numero.equals(c.getTarjeta())){ // Comprobando si está entre las Tarjetas               
                return true;
            }            
            if(numero.equals(c.getCuenta())){ // Comprobando si está entre las cuentas
                return true;
            }
        }                
        return false;
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
    
    private boolean cuentaReader(int idc){
        File file = new File(".\\src\\Files\\Cuentas.txt"); // dirección del archivo
        ArrayList<Cliente.Cuenta> cuentascl = new ArrayList<Cliente.Cuenta>();
        try {
            if(file.exists()){ // Primero leemos
                // Creamos los flujos de lectura del archivo con tipo objeto
                FileInputStream fin = new FileInputStream(file);                
                ObjectInputStream oin = new ObjectInputStream(fin);
                cuentascl = (ArrayList<Cliente.Cuenta>) oin.readObject(); // Leemos el objeto del archivo y lo cargamos en clientes con su cast a ArrayList tipo clientes
                cuentas = new ArrayList<Cliente.Cuenta>();
                
                for(Cliente.Cuenta c: cuentascl){
                    if(c.getIdc() == idc){
                        cuentas.add(c);
                    }
                }

                oin.close();
                fin.close();
                return true;
            }
            else{
                return false;
            }
            
            } catch (Exception e) { // Manejo de la excepción de la lectura
                e.printStackTrace(); 
                return false;
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Error = new javax.swing.JDialog();
        messageError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTransacciones = new javax.swing.JTable();
        txtDesde = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHasta = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btn_elfilltro = new javax.swing.JButton();

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
        setTitle("ClienteTransferencias");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        txtDesde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yy"))));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Desde (dd-mm-yy):");

        txtHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yy"))));
        txtHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHastaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Hasta (dd-mm-yy):");

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btn_elfilltro.setText("Eliminar filtro");
        btn_elfilltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elfilltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_elfilltro)))
                .addContainerGap(843, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_elfilltro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)))
                .addContainerGap(633, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(170, 170, 170)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(171, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btn_elfilltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elfilltroActionPerformed
        con_fecha = false;
    }//GEN-LAST:event_btn_elfilltroActionPerformed

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
        Error.dispose();
    }//GEN-LAST:event_ErrorWindowClosing

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cint.setVisible(true);
        trans_timer.stop();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing
      
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
            java.util.logging.Logger.getLogger(ClienteTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteTrans(10, new ClienteInt(10)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Error;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btn_elfilltro;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageError;
    private javax.swing.JTable tablaTransacciones;
    private javax.swing.JFormattedTextField txtDesde;
    private javax.swing.JFormattedTextField txtHasta;
    // End of variables declaration//GEN-END:variables
}
