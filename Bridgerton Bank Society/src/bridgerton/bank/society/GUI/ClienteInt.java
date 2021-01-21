
package bridgerton.bank.society.GUI;

import bridgerton.bank.society.Cliente;
import bridgerton.bank.society.Cliente.Cuenta;
import bridgerton.bank.society.GUI_Cajero.Cajero;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import static java.nio.file.Files.delete;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class ClienteInt extends javax.swing.JFrame {
    private static ImageIcon icon = new ImageIcon();
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // Arraylist para manejar a nuestros clientes 
    private static ArrayList<Cliente.Cuenta> cuentas = new ArrayList<Cliente.Cuenta>(); // Arraylist para manejar a nuestros clientes 
    
// Herramientas para calcular la posición de la ventana
    private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    // Variable para tener el idc
    public static int idc = 0;
    // Herramienta para el icono
    
    
    public ClienteInt(int idc) {
        imageDataReader(idc);
        
        this.idc = idc;
        setLocation(ancho/2-375, 10);
        initComponents();    
        clienteReader(idc);
        tabla_cuentas();
        
        //lblNombre.setText(c.getNombre());
    }
    
    public void agregarCuenta(Cliente.Cuenta cta) {
        clienteWriter(idc, cta);
        //cuentas.add(cta);
        tabla_cuentas();        
    }
    
    public boolean clienteWriter(int idc, Cuenta cta){ // Para meter las cuentas a cliente una vez creadas todas
        File file = new File(".\\src\\Files\\Clientes.txt"); // dirección del archivo
        
        try {
            if(file.exists()){ // Primero leemos
                // Creamos los flujos de lectura del archivo con tipo objeto
                FileInputStream fin = new FileInputStream(file);                
                ObjectInputStream oin = new ObjectInputStream(fin);
                clientes = (ArrayList<Cliente>) oin.readObject(); // Leemos el objeto del archivo y lo cargamos en clientes con su cast a ArrayList tipo clientes
                // Cerramos flujos de lectura y devolvemos true porque fue exitoso
                
                for(Cliente c: clientes){
                    if(c.getIDC() == idc){
                        cuentas = c.getCuentas();
                        cuentas.add(cta); // Para actualizar la tabla
                        c.agregarCuenta(cta); // Agregar a cliente y archivo
                        
                        break;
                    }
                }
                 // Creamos los flujos de lectura del archivo con tipo objeto
                FileOutputStream fout = new FileOutputStream(file);                
                ObjectOutputStream out = new ObjectOutputStream(fout);
                out.writeObject(clientes); // Leemos el objeto del archivo y lo cargamos en clientes con su cast a ArrayList tipo clientes
                // Cerramos flujos de lectura y devolvemos true porque fue exitoso
                
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
    
    // Función correctora de location 1
    private String toRelative(String name){
        URI p1 = null; // Variable de apoyo
        String directory =".\\src\\Files\\FotosClientes\\"; 
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
                icon = new ImageIcon(p2);
                return archivos[i].getPath();
            }
        }
        return "";
    }
    
    // Lectura de la imagen
    private boolean imageDataReader(int idc){
        File file = new File(".\\src\\Files\\Clientes.txt"); // dirección del archivo
        
        try {
            if(file.exists()){ // Primero leemos
                // Creamos los flujos de lectura del archivo con tipo objeto
                FileInputStream fin = new FileInputStream(file);                
                ObjectInputStream oin = new ObjectInputStream(fin);
                clientes = (ArrayList<Cliente>) oin.readObject(); // Leemos el objeto del archivo y lo cargamos en clientes con su cast a ArrayList tipo clientes
                
                for(Cliente c: clientes){
                    if(c.getIDC() == idc){
                        String name = c.getFotoCliente().getName();
                        toRelative(name);
                        cuentas = c.getCuentas();
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
    
    public boolean clienteReader(int idc){
        File file = new File(".\\src\\Files\\Clientes.txt"); // dirección del archivo
        
        try {
            if(file.exists()){ // Primero leemos
                // Creamos los flujos de lectura del archivo con tipo objeto
                FileInputStream fin = new FileInputStream(file);                
                ObjectInputStream oin = new ObjectInputStream(fin);
                clientes = (ArrayList<Cliente>) oin.readObject(); // Leemos el objeto del archivo y lo cargamos en clientes con su cast a ArrayList tipo clientes
                
                for(Cliente c: clientes){
                    if(c.getIDC() == idc){
                        lblNombre.setText(c.getNombre());
                        lblIDE.setText(String.valueOf(c.getIDC()));
                        lblCURP.setText(c.getCurp());
                        lblFecha.setText(String.valueOf(c.getFechaN()));
                        lblDir.setText(c.getDirec());
                        lblFechI.setText(String.valueOf(c.getFechaI()));
                        lblCel.setText(String.valueOf(c.getCelular()));
                        lblTel.setText(String.valueOf(c.getTelefono()));
                        cuentas = c.getCuentas();
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
        
    public void tabla_cuentas(){ // Regenera las tablas a partir de las nuevas creadas
        String[] tipos = {"Débito", "Crédito Bronce", "Crédito plata", "Crédito oro"};
        // Para la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy"); // formateamos la fecha para que se ingrese en número
        Date fecha = new Date();
        
        DefaultTableModel model=(DefaultTableModel) tCuentas.getModel(); // Crea el modelo de la tabla a partir del actual
        
        // Borra la tabla anterior
        int index = 0;
        while(index < model.getRowCount()){
            model.removeRow(index); 
        } 
        
        for(Cliente.Cuenta cuenta: cuentas)
        {
            Object[] fila = new Object[8]; // Crea el objeto de celdas para agregar
            fila[0] = ""+cuenta.getCuenta(); // Número de cuenta
            fila[1] = ""+cuenta.getTarjeta(); // Número de tarjeta
            fila[2] = tipos[cuenta.getTipo()-1]; // Tipo de cuenta 
            fila[3] = ""+cuenta.getClabe(); // Clabe interbancaria
            fila[4] = ""+sdf.format(cuenta.getApertura()); // Fecha de apertura
            fila[5] = ""+cuenta.getSaldo(); // Saldo positivo de la cuenta
            fila[6] = ""+cuenta.getCVV(); // cvv de la tarjeta
            fila[7] = ""+cuenta.getClaveseg(); //clave de seguridad
            model.addRow(fila); // Agrega la fila al modelo de la tabla
            tCuentas.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos        
        }
        
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFoto = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblIDE = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCURP = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDir = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblFechI = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCuentas = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblCel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        btnVer = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cliente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblFoto.setIcon(icon);
        lblFoto.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        lblNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("IDE:");

        lblIDE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblIDE.setText("ide");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("CURP:");

        lblCURP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCURP.setText("curp");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Fecha de nacimiento:");

        lblFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFecha.setText("fecha");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Dirección:");

        lblDir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDir.setText("direccion");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Fecha de incorporación:");

        lblFechI.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFechI.setText("fecha_inco");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("CUENTAS");

        tCuentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.Cuenta", "No. Tarjeta", "Tipo de Cuenta", "CLABE", "Fecha de Apertura", "Saldo", "CVV", "Clave"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tCuentas);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Celular:");

        lblCel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCel.setText("cel");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Teléfono:");

        lblTel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTel.setText("tel");

        btnVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVer.setText("Ver transacciones");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAgregar.setText("Agregar Cuenta");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lblDir, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                                    .addComponent(lblIDE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblCURP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblFechI, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10)))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCel, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(lblTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(81, 81, 81))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(569, 569, 569)
                                        .addComponent(btnVer))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(365, 365, 365)
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblIDE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblCURP)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblCel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblTel))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblFecha))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblDir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblFechI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addGap(22, 22, 22)
                .addComponent(btnVer)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Cliente cliente = new Cliente();
        AgregarCuenta ac = new AgregarCuenta(cliente, null, this, true);
        ac.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Si se cierra, abre la ventana de ListaClientes
        BancoListaClientes bcts= new BancoListaClientes();
        bcts.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(ClienteInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteInt(-1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCURP;
    private javax.swing.JLabel lblCel;
    private javax.swing.JLabel lblDir;
    private javax.swing.JLabel lblFechI;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblIDE;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTel;
    private javax.swing.JTable tCuentas;
    // End of variables declaration//GEN-END:variables

}
