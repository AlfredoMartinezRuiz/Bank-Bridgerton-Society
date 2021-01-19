/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgerton.bank.society.GUI;

import bridgerton.bank.society.Cliente;
import bridgerton.bank.society.Cliente.Cuenta;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Aurora
 */
public class AgregarCuenta extends javax.swing.JFrame {
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // Lista de clientes para verificar que no haya curp
    // o idc repetidosprivate static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // Arraylist para manejar a nuestros clientes    
    private static ArrayList<Cliente.Cuenta> cuentas = new ArrayList<Cuenta>(); // Arraylist para manejar a sus cuentas
    private static String dato_cuenta = "";
    private static String dato_tarjeta = "";
    private static String dato_clabe = "";
    /**
     * Creates new form AgregarCuenta
     */
    public AgregarCuenta() {
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
        txtClave = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        jLabel8.setText("Clave:");

        txtNcuenta.setEditable(false);
        txtNcuenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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

        txtCVV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtClave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                        .addComponent(txtCLABE, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
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
                                        .addComponent(txtClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txtNcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7))
                        .addGap(63, 63, 63))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoCuentaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void txtCLABEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCLABEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCLABEActionPerformed

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
                new AgregarCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fecha_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> tipoCuenta;
    private javax.swing.JTextField txtCLABE;
    private javax.swing.JTextField txtCVV;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtNcuenta;
    private javax.swing.JTextField txtNtarjeta;
    // End of variables declaration//GEN-END:variables
}
