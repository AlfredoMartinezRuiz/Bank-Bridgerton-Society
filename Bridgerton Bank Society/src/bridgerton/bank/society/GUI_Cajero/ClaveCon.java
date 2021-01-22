
package bridgerton.bank.society.GUI_Cajero;

import bridgerton.bank.society.BridgertonBankSociety;
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

public class ClaveCon extends javax.swing.JFrame {

    private static String no_cuenta;
    private static int clave;
    private static int claveN;
    private static int claveN2;
    private static int cvv;
    private static ImageIcon header = null;
    
    private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    ClaveCon(String no_cuenta, int cvv, int clave) {
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
        Confirmacion = new javax.swing.JDialog();
        message1 = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtClaveN = new javax.swing.JTextField();
        btnConfi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtClaveN2 = new javax.swing.JTextField();

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

        Confirmacion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Confirmacion.setMinimumSize(new java.awt.Dimension(0, 150));
        Confirmacion.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ConfirmacionWindowClosing(evt);
            }
        });

        message1.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        message1.setForeground(new java.awt.Color(51, 51, 255));
        message1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message1.setText("!Cambio de clave exitoso!");

        btnSi.setText("OK");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConfirmacionLayout = new javax.swing.GroupLayout(Confirmacion.getContentPane());
        Confirmacion.getContentPane().setLayout(ConfirmacionLayout);
        ConfirmacionLayout.setHorizontalGroup(
            ConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(message1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(ConfirmacionLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ConfirmacionLayout.setVerticalGroup(
            ConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmacionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(message1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSi)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CambiarClave");

        jLabel3.setIcon(header);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("CAMBIAR CLAVE DE CUENTA.");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Ingrese la nueva clave de seguridad:");

        txtClaveN.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtClaveN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

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
        jLabel7.setText("Repetir la nueva clave de seguridad:");

        txtClaveN2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtClaveN2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(txtClaveN)
                            .addComponent(txtClaveN2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(505, 505, 505))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(513, 513, 513))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(404, 404, 404))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClaveN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClaveN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(btnConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiActionPerformed
        boolean errors = false; // Variable para identificar los errores del algun dato
        float saldo=0;


        // Para la clave de seguridad
        if(txtClaveN.getText().isBlank() == false){
            try{
                claveN = Integer.valueOf(txtClaveN.getText());
            }catch(Exception e){
                message.setText("Falta clave o está mal.");
                errors = true;
            }
        }
        else{
            message.setText("Falta clave o está mal.");
            errors = true;
        }
        
        // Para la clave de seguridad
        if(txtClaveN2.getText().equals(txtClaveN.getText())){
            try{
                claveN2 = Integer.valueOf(txtClaveN.getText());
            }catch(Exception e){
                message.setText("Falta clave o está mal");
                errors = true;
            }
        }
        else{
            message.setText("Las claves no son iguales.");
            errors = true;
        }
        // Checamos si hubo algún error
        if(errors){
            Error.setVisible(true);
            Error.setSize(310, 90);
            Error.setLocation(ancho/2 - 160, alto/2 - 45);
        }
        else{
            //cambiarClave(String nocuenta, int cvv_atm, int clave_atm, int nclave)
            int result = BridgertonBankSociety.cambiarClave(no_cuenta, cvv, clave, claveN);
            
            if(result >= 0){
                Confirmacion.setAlwaysOnTop(true);
                Confirmacion.setVisible(true);
                Confirmacion.setSize(310, 90);
                Confirmacion.setLocation(ancho/2 - 160, alto/2 - 45);
            }
            else{
                message.setText(""+diccionario_errores.get(Math.abs(result)));
                Error.setVisible(true);
                Error.setSize(310, 90);
                Error.setLocation(ancho/2 - 160, alto/2 - 45);
            }
        }
    }//GEN-LAST:event_btnConfiActionPerformed

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
    }//GEN-LAST:event_ErrorWindowClosing

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        // Si se confirma, entonces se cerrará todo
        Cajero cj = new Cajero();
        cj.setVisible(true);
        Confirmacion.setVisible(false);
        Confirmacion.dispose();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSiActionPerformed

    private void ConfirmacionWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ConfirmacionWindowClosing
        // Si se confirma, entonces se cerrará todo
        Cajero cj = new Cajero();
        cj.setVisible(true);
        Confirmacion.setVisible(false);
        Confirmacion.dispose();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_ConfirmacionWindowClosing

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
            java.util.logging.Logger.getLogger(ClaveCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClaveCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClaveCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClaveCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClaveCon("100000",10,101).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Confirmacion;
    private javax.swing.JDialog Error;
    private javax.swing.JButton btnConfi;
    private javax.swing.JButton btnSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel message;
    private javax.swing.JLabel message1;
    private javax.swing.JTextField txtClaveN;
    private javax.swing.JTextField txtClaveN2;
    // End of variables declaration//GEN-END:variables
}
