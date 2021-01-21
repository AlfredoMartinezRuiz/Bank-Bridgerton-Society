
package bridgerton.bank.society.GUI_Cajero;

import bridgerton.bank.society.BridgertonBankSociety;
import static bridgerton.bank.society.BridgertonBankSociety.diccionario_errores;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;

public class DepCon extends javax.swing.JFrame {
    // herramientas para hacer el depósito
    private static int no_operacion;
    private static int no_cajero;
    private static String no_cuenta;
    private static float cantidad;
    private static String motivo;
    private static String titular;
    private static Deposito depo = null;
    
    // Variables de ayuda para la posición de las ventanas
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
    
    public DepCon(Deposito depto, String numero, float dato_cantidad, int no_operacion, String dato_motivo, int no_cajero) {
        // Declaracion de los datos anteriores
        depo = depto;
        this.no_operacion = no_operacion;
        this.no_cajero = no_cajero;
        this.no_cuenta = numero;
        this.cantidad = dato_cantidad;
        this.motivo = dato_motivo;
        titular = BridgertonBankSociety.buscadorNombres(numero, 0);
        
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.WHITE);
        mostrarDatos();
    }
    private void mostrarDatos(){
        lblNo.setText(no_cuenta);
        lblTitular.setText(titular);
        lblMotivo.setText(motivo);
        lblMonto.setText(""+cantidad);
        lblNoT.setText(""+no_operacion);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Confirmacion = new javax.swing.JDialog();
        message = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        Error = new javax.swing.JDialog();
        messageE = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTitular = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMotivo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblNoT = new javax.swing.JLabel();
        btnConfi = new javax.swing.JButton();

        Confirmacion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Confirmacion.setMinimumSize(new java.awt.Dimension(0, 150));
        Confirmacion.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ConfirmacionWindowClosing(evt);
            }
        });

        message.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        message.setForeground(new java.awt.Color(51, 51, 255));
        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message.setText("!Operación exitosa!");

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
                .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
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
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSi)
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

        messageE.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        messageE.setForeground(new java.awt.Color(255, 0, 0));
        messageE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ErrorLayout = new javax.swing.GroupLayout(Error.getContentPane());
        Error.getContentPane().setLayout(ErrorLayout);
        ErrorLayout.setHorizontalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageE, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        ErrorLayout.setVerticalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(messageE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel3.setText("encabezado");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel1.setText("RESUMEN: DEPÓSITO A CUENTA O TARJETA ");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("Número de cuenta, clabe interbancaria, o No. de Cuenta:");

        lblNo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblNo.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("Titutlar de la cuenta:");

        lblTitular.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblTitular.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setText("Motivo:");

        lblMotivo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblMotivo.setText("jLabel8");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel11.setText("Monto:");

        lblMonto.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblMonto.setText("jLabel12");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel13.setText("No. de transacción:");

        lblNoT.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblNoT.setText("jLabel9");

        btnConfi.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnConfi.setText("CONFIRMAR");
        btnConfi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(190, 109, 246), 1, true));
        btnConfi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConfi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)
                        .addComponent(jLabel11)
                        .addComponent(jLabel13)
                        .addComponent(lblTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNoT, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNo, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(425, 425, 425))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(382, 382, 382))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNo)
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitular)
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMotivo)
                .addGap(31, 31, 31)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMonto)
                .addGap(32, 32, 32)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNoT)
                .addGap(18, 18, 18)
                .addComponent(btnConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiActionPerformed
        /* sokets por defatul pero probamos funcionalidades */
        int result = BridgertonBankSociety.hacerDeposito(no_cuenta, cantidad, no_operacion, motivo, no_cajero);        
            if(result >= 0){
                Confirmacion.setAlwaysOnTop(true);
                Confirmacion.setVisible(true);
                Confirmacion.setSize(310, 90);
                Confirmacion.setLocation(ancho/2 - 160, alto/2 - 45);
            }
            else{
                messageE.setText(""+diccionario_errores.get(Math.abs(result)));
                Error.setVisible(true);
                Error.setSize(310, 90);
                Error.setLocation(ancho/2 - 160, alto/2 - 45);
            }
    }//GEN-LAST:event_btnConfiActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        depo.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
        Error.dispose();        
    }//GEN-LAST:event_ErrorWindowClosing

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
            java.util.logging.Logger.getLogger(DepCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepCon(new Deposito(10), "100000000000", 10, 10, "porque sí", 15).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Confirmacion;
    private javax.swing.JDialog Error;
    private javax.swing.JButton btnConfi;
    private javax.swing.JButton btnSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblMotivo;
    private javax.swing.JLabel lblNo;
    private javax.swing.JLabel lblNoT;
    private javax.swing.JLabel lblTitular;
    private javax.swing.JLabel message;
    private javax.swing.JLabel messageE;
    // End of variables declaration//GEN-END:variables
}
