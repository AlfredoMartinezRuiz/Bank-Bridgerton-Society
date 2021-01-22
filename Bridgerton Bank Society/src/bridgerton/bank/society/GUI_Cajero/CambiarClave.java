
package bridgerton.bank.society.GUI_Cajero;

import static bridgerton.bank.society.BridgertonBankSociety.diccionario_errores;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class CambiarClave extends javax.swing.JFrame {

    private static String no_cuenta;
    private static int clave;
    private static int cvv;
    private static ImageIcon header = null;
    
     private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    public CambiarClave() {
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
        message = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        btnConfi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCVV = new javax.swing.JTextField();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CambiarClave");

        jLabel3.setIcon(header);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("CAMBIAR CLAVE DE CUENTA.");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Ingrese el número de cuenta, clabe interbancaria, o No. de Cuenta:");

        txtCuenta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Ingrese la clave de seguridad:");

        txtClave.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtClave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        btnConfi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnConfi.setText("CONFIRMAR");
        btnConfi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));
        btnConfi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Ingrese el CVV (3 dígitos):");

        txtCVV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCVV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(502, 502, 502)
                        .addComponent(jLabel1)))
                .addContainerGap(387, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
    }//GEN-LAST:event_ErrorWindowClosing

    private void btnConfiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiActionPerformed
        boolean errors = false; // Variable para identificar los errores del algun dato
        float saldo=0;
        
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
        
        // Para el cvv
        if(txtCVV.getText().isBlank() == false){
            try{
                cvv = Integer.valueOf(txtCVV.getText());
            }catch(Exception e){
                message.setText("Falta CVV o está mal");
                errors = true;
            }
        }
        else{
            message.setText("Falta CVV o está mal");
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
            ClaveCon cc = new ClaveCon(no_cuenta, cvv, clave);
            cc.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_btnConfiActionPerformed

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
            java.util.logging.Logger.getLogger(CambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiarClave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Error;
    private javax.swing.JButton btnConfi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel message;
    private javax.swing.JTextField txtCVV;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCuenta;
    // End of variables declaration//GEN-END:variables
}
