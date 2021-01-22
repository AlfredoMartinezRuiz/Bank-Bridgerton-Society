
package bridgerton.bank.society.GUI_Cajero;

import bridgerton.bank.society.BridgertonBankSociety;
import static bridgerton.bank.society.BridgertonBankSociety.diccionario_errores;
import static bridgerton.bank.society.BridgertonBankSociety.diccionario_nombres;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class ChecarMovimientos extends javax.swing.JFrame {
    private static String no_cuenta;
    private static int clave;
    private static ImageIcon header = null;
    
    private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    static{diccionario_errores.add(""); // 0
        diccionario_errores.add("Clave de seguridad incorrecta"); // 1
        diccionario_errores.add("CVV incorrecto"); // 2
        diccionario_errores.add("Saldo insuficiente"); // 3
        diccionario_errores.add("Crédito agotado");// 4
        diccionario_errores.add("Longitud de la cuenta incorrecta"); // 5
        diccionario_errores.add("Clave de seguridad incorrecta");// 6
        diccionario_errores.add("Cuenta emisora no encontrada"); // 7
        
    }
    
    public ChecarMovimientos() {
        toRelative("Header.jpg"); // lectura del header
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.WHITE);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Error = new javax.swing.JDialog();
        messageError = new javax.swing.JLabel();
        Confirmacion = new javax.swing.JDialog();
        message = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        btnConfi = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Movimientos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel5.setIcon(header);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("CHECAR MOVIMIENTOS DE CUENTA.");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Ingrese el número de cuenta, clabe interbancaria, o No. de Cuenta:");

        txtCuenta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Ingrese la clave de seguridad:");

        txtClave.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtClave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        btnConfi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnConfi.setText("CONFIRMAR");
        btnConfi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));
        btnConfi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(461, 461, 461)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 383, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(383, 383, 383))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
    }//GEN-LAST:event_ErrorWindowClosing

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
     
    }//GEN-LAST:event_btnSiActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
     
    }//GEN-LAST:event_btnNoActionPerformed

    private void ConfirmacionWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ConfirmacionWindowClosing
  
    }//GEN-LAST:event_ConfirmacionWindowClosing

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cajero cj = new Cajero();
        cj.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnConfiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiActionPerformed
        boolean errors = false; // Variable para identificar los errores del algun dato
        // Para el no de cuenta
        if(txtCuenta.getText().isBlank() == false){
            try{
                no_cuenta = Long.toString(Long.valueOf(txtCuenta.getText()));
            }catch(Exception e){
                message.setText("Falta no. cuenta o está mal");
                errors = true;
            }
        }
        else{
            message.setText("Falta no. cuenta o está mal");
            errors = true;
        }

        // Para la clave de seguridad
        if(txtClave.getText().isBlank() == false){
            try{
                clave = Integer.valueOf(txtClave.getText());
            }catch(Exception e){
                message.setText("Falta clave o está mal");
                errors = true;
            }
        }
        else{
            message.setText("Falta clave o está mal");
            errors = true;
        }
        // Checamos si hubo algún error
        if(errors){
            Error.setVisible(true);
            Error.setSize(310, 90);
            Error.setLocation(ancho/2 - 160, alto/2 - 45);
        }
        else{
            int result = BridgertonBankSociety.checarMovs(no_cuenta, clave, clave, clave);
            if(result >= 0){
                ClienteTrans cT = new ClienteTrans(result);
                cT.setVisible(true);
                this.setVisible(false);
                this.dispose();
            }
            else{
                messageError.setText(""+diccionario_errores.get(Math.abs(result)));
                Error.setVisible(true);
                Error.setSize(310, 90);
                Error.setLocation(ancho/2 - 160, alto/2 - 45);
            }   
        }

    }//GEN-LAST:event_btnConfiActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

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
            java.util.logging.Logger.getLogger(ChecarMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChecarMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChecarMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChecarMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChecarMovimientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Confirmacion;
    private javax.swing.JDialog Error;
    private javax.swing.JButton btnConfi;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel message;
    private javax.swing.JLabel messageError;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCuenta;
    // End of variables declaration//GEN-END:variables
}
