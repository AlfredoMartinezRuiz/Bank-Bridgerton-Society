
package bridgerton.bank.society.GUI_Cajero;

import java.awt.Color;

public class Cajero extends javax.swing.JFrame {

    /**
     * Creates new form Cajero
     */
    public Cajero() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnDeposito = new javax.swing.JButton();
        btnTransferencia = new javax.swing.JButton();
        btnRetiro = new javax.swing.JButton();
        lblUNAM = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("encabezado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 125));

        btnDeposito.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnDeposito.setText("REALIZAR DEPÓSITO");
        btnDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 201, 273, 60));

        btnTransferencia.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnTransferencia.setText("REALIZAR TRANSFERENCIA");
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 432, -1, 60));

        btnRetiro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnRetiro.setText("REALIZAR RETIRO");
        btnRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 602, 273, 60));

        lblUNAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/unam.jpg"))); // NOI18N
        lblUNAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUNAMMouseClicked(evt);
            }
        });
        getContentPane().add(lblUNAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 226, -1, 213));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/teleton.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 452, -1, 220));

        lblBecalos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/becalos.jpg"))); // NOI18N
        lblBecalos.setText("becalos");
        getContentPane().add(lblBecalos, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 219, 282, 210));

        lblAsif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/asif.png"))); // NOI18N
        getContentPane().add(lblAsif, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 463, -1, 209));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("¡APOYA UNA CAUSA!");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 139, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Puedes apoyar a diferentes causas y poder sumarte al tren de la solidaridad:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 179, -1, -1));

        btnSaldo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSaldo.setText("CHECAR SALDO");
        btnSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1104, 201, 266, 60));

        btnMov.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnMov.setText("CHECAR MOVIMIENTOS");
        btnMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovActionPerformed(evt);
            }
        });
        getContentPane().add(btnMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(1104, 432, 266, 60));

        btnClave.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnClave.setText("CAMBIAR CLAVE");
        btnClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1104, 602, 266, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ipn.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 219, -1, 217));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositoActionPerformed
        Deposito dep = new Deposito();
        dep.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnDepositoActionPerformed

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        Transferencia tr = new Transferencia();
        tr.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void btnRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroActionPerformed
        Retiro ret = new Retiro();
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAsif;
    private javax.swing.JLabel lblBecalos;
    private javax.swing.JLabel lblUNAM;
    // End of variables declaration//GEN-END:variables
}
