/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgerton.bank.society.GUI;

import bridgerton.bank.society.BridgertonBankSociety;
import bridgerton.bank.society.Cliente;
import bridgerton.bank.society.Cliente.Cuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import bridgerton.bank.society.Cliente.Cuenta;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Aurora
 */
public class AgregarCuenta extends javax.swing.JFrame {
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // Lista de clientes para verificar que no haya curp
    //o idc repetidos
    
// Datos del usuario para manejo de los métodos
    private static String dato_cuenta = "";
    private static String dato_tarjeta = "";
    private static String dato_clabe = "";
    private static int cvv = 0;
    private static Cliente cliente = new Cliente(); // El cliente solo para crear una cuenta
    private static final Date fecha = new Date();
    private static AgregarCliente aclte = null; // Para la ventana que traemos de la invocación de agregar
    private static boolean invocador_cliente = false;
    private static ClienteInt clte = null; // Para la ventana que traemos de la invocación de cliente
    
    // Herramientas para calcular la posición de la ventana
    private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    /**
     * Creates new form AgregarCuenta
     */
    public AgregarCuenta(Cliente c, AgregarCliente a, ClienteInt cint, boolean invocador) {
        // Traemos la ventana anterior para abrirla de nuevo si es la de agregar cliente
        aclte = a;
        // Traemos la ventana anterior para abrirla de nuevo si es la de cliente
        clte = cint;
        // Definimos si viene de cliente o no
        invocador_cliente = invocador;
        
        initComponents();
        clienteReader();
        generadorCuentas();
    }
   
    public void generadorCuentas(){
        // Variables para omprobar que sean correctas antes de terminar con el método
        boolean clabe_correcta = false;
        boolean tarjeta_corecta = false;
        boolean cuenta_corecta = false;
        
        
        // Nos aseguramos que la clabe sea correcta
        while(clabe_correcta == false){ 
            String clabe = generadorCifras(18); // Generamos un número entero aleatorio de 18 cifras 
            
            if(isInCuentas(clabe) == false ){ // Comrpobamos que no esté en alguna cuenta de algún cliente
                dato_clabe = clabe;
                txtCLABE.setText(dato_clabe);
                clabe_correcta = true;
            }
            else clabe_correcta = false;
        }
        clabe_correcta = false;
        
        // Nos aseguramos que la tarjeta sea correcta
        while(clabe_correcta == false){ 
            String tarjeta = generadorCifras(16); // Generamos un número entero aleatorio de 16 cifras 
            
            if(isInCuentas(tarjeta) == false ){ // Comprobamos que no esté en alguna cuenta de algún cliente
                dato_tarjeta = tarjeta;
                txtNtarjeta.setText(dato_tarjeta);
                clabe_correcta = true;
            }
            else clabe_correcta = false;
        }
        clabe_correcta = false;
        
        // Nos aseguramos que la cuenta sea correcta
        while(clabe_correcta == false){ 
            String cuenta = generadorCifras(12); // Generamos un número entero aleatorio de 12 cifras 
            
            if(isInCuentas(cuenta) == false ){ // Comprobamos que no esté en alguna cuenta de algún cliente
                dato_cuenta = cuenta;
                txtNcuenta.setText(dato_cuenta);
                clabe_correcta = true;
            }
            else clabe_correcta = false;
        }
        // Generamos la cvv
        cvv = Integer.valueOf(generadorCifras(3));
        txtCVV.setText(""+cvv);
        // Colocamos la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // formateamos la fecha para que se ingrese en número
        fecha_label.setText(sdf.format(fecha));
        
    }
    
    public String generadorCifras(int n){
        // Genera número aleatorios con ayuda de la concatenación de n dígitos del 0 al 9
        String numero = "";
        Random r = new Random();
        int num = 0;
        for(int i=0; i < n; i++){
            num = r.nextInt(9);
            if(i == 0 && num == 0) num++;
            numero = numero + num;
        }
        
        return numero;
    }
    
    public boolean isInCuentas(String numero){
        
        for(Cliente c: clientes){
            switch(numero.length()){
                case 18:
                    if(c.buscadorClabe(numero)!= null) return true; // Si enontró la cuenta entonces retorna verdadero
                    else return false;
                case 16:
                    if(c.buscadorTarjeta(numero)!= null) return true; // Si enontró la cuenta entonces retorna verdadero
                    else return false;
                case 12:
                    if(c.buscadorCuenta(numero)!= null) return true; // Si enontró la cuenta entonces retorna verdadero
                    else return false;
            }
        }
        return false;
    }
    
    public boolean clienteReader(){ // Se encarga de leer los clientes del arhivo y cargarlos en memoria
        File file = new File(".\\src\\Files\\Clientes.txt"); // La tura del archivo de clientes
        
        try {
            if(file.exists()){ 
                
                // Primero leemos si no está vacío
                if(file.length() > 0){
                    FileInputStream fin = new FileInputStream(file);
                    ObjectInputStream oin = new ObjectInputStream(fin);
                    clientes = (ArrayList<Cliente>) oin.readObject(); // Creamos flujos y después leemos el array de clientes
                    
                    oin.close();
                    fin.close();
                }
                return false;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
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
        message = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tipoCuenta = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNcuenta = new javax.swing.JTextField();
        txtNtarjeta = new javax.swing.JTextField();
        fecha_label = new javax.swing.JLabel();
        txtCLABE = new javax.swing.JTextField();
        txtCVV = new javax.swing.JTextField();
        agregar_button = new javax.swing.JButton();
        txtClave = new javax.swing.JFormattedTextField();

        Error.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Error.setAlwaysOnTop(true);
        Error.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Error.setResizable(false);
        Error.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ErrorWindowClosing(evt);
            }
        });

        message.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        message.setForeground(new java.awt.Color(255, 0, 0));
        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ErrorLayout = new javax.swing.GroupLayout(Error.getContentPane());
        Error.getContentPane().setLayout(ErrorLayout);
        ErrorLayout.setHorizontalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        ErrorLayout.setVerticalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Agregar cuenta");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("No. Cuenta: ");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("No. Tarjeta:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Fecha actual:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Tipo de cuenta:");

        tipoCuenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Débito", "Crédito Bronce", "Crédito Plata", "Crédito Oro" }));
        tipoCuenta.setSelectedItem(null);
        tipoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoCuentaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Clabe interbancaria:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("CVV:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Clave(8 dígitos MAX.):");

        txtNcuenta.setEditable(false);
        txtNcuenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNcuentaActionPerformed(evt);
            }
        });

        txtNtarjeta.setEditable(false);
        txtNtarjeta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        fecha_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fecha_label.setText("Fecha");

        txtCLABE.setEditable(false);
        txtCLABE.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCLABE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCLABEActionPerformed(evt);
            }
        });

        txtCVV.setEditable(false);
        txtCVV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        agregar_button.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        agregar_button.setText("AGREGAR");
        agregar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_buttonActionPerformed(evt);
            }
        });

        txtClave.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(agregar_button)
                                .addComponent(txtNtarjeta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2))
                                                    .addGap(54, 54, 54))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fecha_label)
                                                .addComponent(tipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(38, 38, 38))
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txtNcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7))
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCLABE, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNtarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fecha_label))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCLABE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(agregar_button)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoCuentaActionPerformed

    private void agregar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_buttonActionPerformed
        boolean errors = false; // Identifica si hubo algún error en la lectura de datos, si lo hubo, se vuelve true
        
        // Comprobando la clave
        if(txtClave.getText().equals("") || txtClave.getText().length()>8){
            errors = true;
            message.setText("Falta clave o está mal");            
        }
        // Comprobando el tipo de cuenta
        else if(tipoCuenta.getSelectedItem() == null){
            errors = true;
            message.setText("Escoja tipo de cuenta");
        }
        
        if(errors){ // Si hay algún error, mostrará la ventana con el error antes asignado
            Error.setVisible(true);
            Error.setSize(310, 90);
            Error.setLocation(ancho/2 - 160, alto/2 - 45);
        }
        else{
            int dato_clave = Integer.valueOf(txtClave.getText());
            int tipo = tipoCuenta.getSelectedIndex() + 1;
            
            // Creamos la cuenta
            Cliente.Cuenta cta = cliente.new Cuenta(dato_cuenta, dato_tarjeta, tipo, dato_clabe, fecha, cvv, dato_clave);
            
            if(cta == null){ // Si hubo error en la creación de la cuenta
                message.setText("No se creo la cuenta correctamente");
                Error.setVisible(true);
                Error.setSize(310, 90);
                Error.setLocation(ancho/2 - 160, alto/2 - 45);
            }
            else{ // Si se creó correctamente la cuenta
                if(invocador_cliente){ // Si fue invocada desde ClienteInt
                    ClienteInt clt = new ClienteInt(clte.idc);
                    clt.setVisible(true);
                    clt.agregarCuenta(cta);
                    this.setVisible(false);
                    this.dispose();
                }                
                else{ // Si fue invocada desde AgregarCliente
                    aclte.setVisible(true);
                    aclte.agregarCuenta(cta);
                    this.setVisible(false);
                    this.dispose();
                }
                      
            }         
        }
    }//GEN-LAST:event_agregar_buttonActionPerformed

    private void txtCLABEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCLABEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCLABEActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Si se cierra, abre la ventana de Agregar cliente
        if(invocador_cliente){ // si fue invocada por cliente
            clte.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }
        else{ // Si fue invocada por el agregador de clientes
            aclte.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }
        
    }//GEN-LAST:event_formWindowClosing

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
        Error.dispose();
    }//GEN-LAST:event_ErrorWindowClosing

    private void txtNcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNcuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNcuentaActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCuenta(new Cliente(), new AgregarCliente(), new ClienteInt(-1), true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Error;
    private javax.swing.JButton agregar_button;
    private javax.swing.JLabel fecha_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel message;
    private javax.swing.JComboBox<String> tipoCuenta;
    private javax.swing.JTextField txtCLABE;
    private javax.swing.JTextField txtCVV;
    private javax.swing.JFormattedTextField txtClave;
    private javax.swing.JTextField txtNcuenta;
    private javax.swing.JTextField txtNtarjeta;
    // End of variables declaration//GEN-END:variables
}
