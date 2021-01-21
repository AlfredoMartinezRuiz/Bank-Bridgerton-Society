
package bridgerton.bank.society.GUI_Cajero;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Cajero extends javax.swing.JFrame {
    private static int noCajero; 
    private ImageIcon[] icons = new ImageIcon[5];
    /**
     * Creates new form Cajero
     */
    public Cajero() {
        // Arreglamos el detalle de iconos
        iconos(".\\src\\Imagenes\\unam.jpg", 0); 
        iconos(".\\src\\Imagenes\\ipn.png", 1); 
        iconos(".\\src\\Imagenes\\becalos.jpg", 2); 
        iconos(".\\src\\Imagenes\\teleton.png", 3); 
        iconos(".\\src\\Imagenes\\asif.png", 4); 
        
        // Crear un nuevo número entero aleatorio
        Random r = new Random();
        noCajero = r.nextInt(100); // Creamos un número de cajero
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.WHITE);
    }
    private void iconos(String location, int index){ // Arregla el problema de can't invoke
        // path(String) -> abrimos file -> URI -> URL -> Usamos para construir una ImageIcon
        URI p1 = null; // Variable de apoyo
        
        // Obtenemos el archivo de la dirección
        File file = new File(location);
        p1 = file.toURI(); // Cambia a URI primero
        URL p2 = null;
        try {
            p2 = p1.toURL(); // Después cambia a URL
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
        }        
        icons[index] = new ImageIcon(p2);
                
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnDeposito = new javax.swing.JButton();
        btnTransferencia = new javax.swing.JButton();
        btnRetiro = new javax.swing.JButton();
        lblUNAM = new javax.swing.JLabel();
        lblTeleton = new javax.swing.JLabel();
        lblBecalos = new javax.swing.JLabel();
        lblAsif = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSaldo = new javax.swing.JButton();
        btnMov = new javax.swing.JButton();
        btnClave = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cajero");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("encabezado");

        btnDeposito.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnDeposito.setText("REALIZAR DEPÓSITO");
        btnDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositoActionPerformed(evt);
            }
        });

        btnTransferencia.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnTransferencia.setText("REALIZAR TRANSFERENCIA");
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });

        btnRetiro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnRetiro.setText("REALIZAR RETIRO");
        btnRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroActionPerformed(evt);
            }
        });

        lblUNAM.setIcon(icons[0]);
        lblUNAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUNAMMouseClicked(evt);
            }
        });

        lblTeleton.setIcon(icons[3]);

        lblBecalos.setIcon(icons[2]);

        lblAsif.setIcon(icons[4]);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("¡APOYA UNA CAUSA!");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Puedes apoyar a diferentes causas y poder sumarte al tren de la solidaridad:");

        btnSaldo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSaldo.setText("CHECAR SALDO");
        btnSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoActionPerformed(evt);
            }
        });

        btnMov.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnMov.setText("CHECAR MOVIMIENTOS");
        btnMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovActionPerformed(evt);
            }
        });

        btnClave.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnClave.setText("CAMBIAR CLAVE");
        btnClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaveActionPerformed(evt);
            }
        });

        jLabel8.setIcon(icons[1]);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRetiro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTransferencia, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                            .addComponent(lblTeleton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblAsif, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(109, 109, 109))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(lblUNAM, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(lblBecalos, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel6)
                        .addGap(101, 101, 101)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMov, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(btnClave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMov, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBecalos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(lblUNAM, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTeleton, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(lblAsif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositoActionPerformed
        Deposito dep = new Deposito(noCajero);
        dep.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnDepositoActionPerformed

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        Transferencia tr = new Transferencia(noCajero);
        tr.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void btnRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroActionPerformed
        Retiro ret = new Retiro(noCajero);
        ret.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnRetiroActionPerformed

    private void btnSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldoActionPerformed
        ChecarSaldo cs = new ChecarSaldo();
        cs.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSaldoActionPerformed

    private void btnMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovActionPerformed
        ChecarMovimientos cm = new ChecarMovimientos();
        cm.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnMovActionPerformed

    private void btnClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaveActionPerformed
        CambiarClave dep = new CambiarClave();
        dep.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnClaveActionPerformed

    private void lblUNAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUNAMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUNAMMouseClicked

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
            java.util.logging.Logger.getLogger(Cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClave;
    private javax.swing.JButton btnDeposito;
    private javax.swing.JButton btnMov;
    private javax.swing.JButton btnRetiro;
    private javax.swing.JButton btnSaldo;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAsif;
    private javax.swing.JLabel lblBecalos;
    private javax.swing.JLabel lblTeleton;
    private javax.swing.JLabel lblUNAM;
    // End of variables declaration//GEN-END:variables
}
