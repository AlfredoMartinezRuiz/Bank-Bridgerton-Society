
package bridgerton.bank.society.GUI;

import static bridgerton.bank.society.BridgertonBankSociety.clientes;
import bridgerton.bank.society.BridgertonBankSociety;
import bridgerton.bank.society.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class BancoListaClientes extends javax.swing.JFrame {
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // Arraylist para manejar a nuestros clientes    
    // Variables de ayuda para la posición de las ventanas
    private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    // Herramienta de instancia
    private static BancoListaClientes blt = null;
    
    public BancoListaClientes() { // Sin ningún filtro
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH); 
        fecha_label.setText("Fecha: " + new Date()); // Pone la fecha y hora actual
        clienteReader(); // Lee los cientes del archivo y los almacena en el array de clientes
        tabla(); // Genera la tabla
        timer.start();
        blt = this;
        popupTabla();
    }
    
    public BancoListaClientes(int idc) { // Filtro por búsqueda de idc
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        fecha_label.setText("Fecha: " + new Date());
        clienteReader();
        tabla(idc);
        timer.start();
    }
    
    public BancoListaClientes(String curp) { // Filtro por búsqueda de curp
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        fecha_label.setText("Fecha: " + new Date());
        clienteReader();
        tabla(curp);
        timer.start();
    }
    
    public BancoListaClientes(String nombre, long celular) { // Filtro por búsqueda de nombre y número celular
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        fecha_label.setText("Fecha: " + new Date());
        clienteReader();
        tabla(nombre, celular);
        timer.start();
    }
    
    public void tabla(){ // Muestra la tabla normal con todos los clientes
        for(Cliente c: clientes){ // Recorre todos los clientes 
            DefaultTableModel model=(DefaultTableModel) clientesT.getModel(); // Crea el modelo de la tabla a partir del actual
            
            Object[] fila = new Object[5]; // Crea el objeto de celdas para agregar
            fila[0] = c.getIDC();
            fila[1] = c.getNombre();
            fila[2] = c.getCurp();
            fila[3] = Long.toString(c.getCelular());
            fila[4] = Long.toString(c.getTelefono());
            model.addRow(fila); // Agrega la fila al modelo de la tabla
            clientesT.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos
        }        
    }
    
    public void tabla(int idc){ // Muestra la tabla sólo donde coincide con el idc del fitro con todos los clientes
        for(Cliente c: clientes){
            if(c.getIDC() == idc){
                DefaultTableModel model=(DefaultTableModel) clientesT.getModel();// Crea el modelo de la tabla a partir del actual
            
                Object[] fila = new Object[5];// Crea el objeto de celdas para agregar
                fila[0] = c.getIDC();
                fila[1] = c.getNombre();
                fila[2] = c.getCurp();
                fila[3] = Long.toString(c.getCelular());
                fila[4] = Long.toString(c.getTelefono());
                model.addRow(fila); // Agrega la fila al modelo de la tabla
                clientesT.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos
            }
        }        
    }
    
    public void tabla(String curp){ // Muestra la tabla sólo donde coincide con el curp del fitro con todos los clientes
        for(Cliente c: clientes){
            if(c.getCurp() == curp){
                DefaultTableModel model=(DefaultTableModel) clientesT.getModel();// Crea el modelo de la tabla a partir del actual
            
                Object[] fila = new Object[5];// Crea el objeto de celdas para agregar
                fila[0] = c.getIDC();
                fila[1] = c.getNombre();
                fila[2] = c.getCurp();
                fila[3] = Long.toString(c.getCelular());
                fila[4] = Long.toString(c.getTelefono());
                model.addRow(fila); // Agrega la fila al modelo de la tabla
                clientesT.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos
            }
        }        
    }
    
    public void tabla(String nombre, long numero){ // Muestra la tabla sólo donde coincide con el nombre y número del fitro con todos los clientes
        for(Cliente c: clientes){
            if(c.getNombre().equals(nombre)){
                if(c.getCelular() == numero){
                     DefaultTableModel model=(DefaultTableModel) clientesT.getModel();// Crea el modelo de la tabla a partir del actual

                    Object[] fila = new Object[5]; // Crea el objeto de celdas para agregar
                    fila[0] = c.getIDC();
                    fila[1] = c.getNombre();
                    fila[2] = c.getCurp();
                    fila[3] = Long.toString(c.getCelular());
                    fila[4] = Long.toString(c.getTelefono());
                    model.addRow(fila); // Agrega la fila al modelo de la tabla
                    clientesT.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos
                }
            }
        }        
    }
    
    public boolean clienteReader(){ // Se encarga de leer los clientes del arhivo y cargarlos en memoria
        File file = new File(".\\src\\Files\\Clientes.txt"); // dirección del archivo
        
        try {
            if(file.exists()){ // Primero leemos
                // Creamos los flujos de lectura del archivo con tipo objeto
                if(file.length() > 0){
                    FileInputStream fin = new FileInputStream(file);                
                    ObjectInputStream oin = new ObjectInputStream(fin);
                    clientes = (ArrayList<Cliente>) oin.readObject(); // Leemos el objeto del archivo y lo cargamos en clientes con su cast a ArrayList tipo clientes
                    // Cerramos flujos de lectura y devolvemos true porque fue exitoso
                    oin.close();
                    fin.close();
                    return true;
                }
                else{
                    return false;
                }
                
            }
            else{
                return false;
            }
            
        } catch (Exception e) { // Manejo de la excepción de la lectura
            e.printStackTrace(); 
            return false;
        }
    }
    // Timer encargado de actualizar la fecha y hora cada segudo
    Timer timer = new Timer (1000, new ActionListener (){
            public void actionPerformed(ActionEvent e) {
               fecha_label.setText("Fecha: " + new Date());
            }           
    });
    
    public void popupTabla(){
        JPopupMenu pM = new JPopupMenu(); //se crea el contenedor
        JMenuItem jmi1 = new JMenuItem("Ver"); //las opciones
        JMenuItem jmi2 = new JMenuItem("Eliminar");
        
        jmi1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //int ift = clientesT.getSelectedRow();
                String ideC = String.valueOf(clientesT.getValueAt(clientesT.getSelectedRow(), 0));   
                int idc = Integer.valueOf(ideC);   
                if(idc != -1){ // Busqueda por IDC, checamos que no esté vacío              
                    ClienteInt clr = new ClienteInt(idc);
                    clr.setVisible(true);
                    timer.stop();
                    blt.setVisible(false);
                    blt.dispose();
                }    
            }
        });
        jmi2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar.setVisible(true);
                Eliminar.setSize(310, 170);
                Eliminar.setLocation(ancho/2 - 160, alto/2 - 45);
                
            }
        });
        pM.add(jmi1);// se agregan las opciones al contenedor
        pM.add(jmi2);
        
        clientesT.setComponentPopupMenu(pM);//se agrega el menú a la tabla con su respectivo evento
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Confirmacion = new javax.swing.JDialog();
        message = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        Eliminar = new javax.swing.JDialog();
        message1 = new javax.swing.JLabel();
        btnSi1 = new javax.swing.JButton();
        btnNo1 = new javax.swing.JButton();
        btnLClientes = new javax.swing.JButton();
        lTransacciones = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fecha_label = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesT = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

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

        message1.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        message1.setForeground(new java.awt.Color(255, 0, 0));
        message1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message1.setText("¿Está seguro?");

        btnSi1.setText("SÍ");
        btnSi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSi1ActionPerformed(evt);
            }
        });

        btnNo1.setText("NO");
        btnNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EliminarLayout = new javax.swing.GroupLayout(Eliminar.getContentPane());
        Eliminar.getContentPane().setLayout(EliminarLayout);
        EliminarLayout.setHorizontalGroup(
            EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(message1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(EliminarLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnSi1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        EliminarLayout.setVerticalGroup(
            EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(message1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSi1)
                    .addComponent(btnNo1)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BancoListaClientes");
        setBackground(new java.awt.Color(206, 147, 216));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnLClientes.setBackground(new java.awt.Color(77, 182, 172));
        btnLClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLClientes.setText("Listado de clientes");
        btnLClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLClientesActionPerformed(evt);
            }
        });

        lTransacciones.setBackground(new java.awt.Color(77, 182, 172));
        lTransacciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lTransacciones.setText("Listado de transacciones en tiempo real");
        lTransacciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lTransaccionesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Listado de clientes");

        fecha_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fecha_label.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(548, 548, 548))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fecha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(fecha_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAgregar.setText("Agregar cliente");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        clientesT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clientesT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDE", "Nombre", "CURP", "Celular", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clientesT.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                clientesTComponentAdded(evt);
            }
        });
        clientesT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesTMouseClicked(evt);
            }
        });
        clientesT.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                clientesTPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(clientesT);
        if (clientesT.getColumnModel().getColumnCount() > 0) {
            clientesT.getColumnModel().getColumn(0).setResizable(false);
            clientesT.getColumnModel().getColumn(1).setResizable(false);
            clientesT.getColumnModel().getColumn(2).setResizable(false);
            clientesT.getColumnModel().getColumn(3).setResizable(false);
            clientesT.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel3.setText("encabezado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lTransacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lTransacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnBuscar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void btnLClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLClientesActionPerformed
        // Botón para recargar la lista de clientes
        BancoListaClientes bcts= new BancoListaClientes();
        bcts.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnLClientesActionPerformed

    private void lTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lTransaccionesActionPerformed
        // Botón para abrir la lista de transacciones
        BancoListaTransacciones blts= new BancoListaTransacciones();
        blts.setVisible(true);
        timer.stop();
        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_lTransaccionesActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // Botón para buscar algún cliente en específico
        BusquedaCliente bc = new BusquedaCliente();
        bc.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // Botón para agregar algún cliente
        AgregarCliente ac = new AgregarCliente();
        ac.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void clientesTComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_clientesTComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_clientesTComponentAdded

    private void clientesTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTMouseClicked
//        if (evt.getClickCount() == 2) {
//           // Si se presiona sobre algún cliente entonces aparecerá la descripción del mismo
//            BusquedaCliente bc = new BusquedaCliente();
//            bc.setVisible(true);
//            this.setVisible(false);
//            this.dispose(); 
//        } 
          
    
    }//GEN-LAST:event_clientesTMouseClicked
   
    private void clientesTPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_clientesTPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_clientesTPropertyChange

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        // Si se confirma, entonces se cerrará todo
        Confirmacion.setVisible(false);
        Confirmacion.dispose();
        timer.stop();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSiActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        // Si se aprieta que no, ventana de confirmación entonces reaparecerá ListaClientes
        this.setVisible(true);
        Confirmacion.setVisible(false);
        Confirmacion.dispose();
    }//GEN-LAST:event_btnNoActionPerformed

    private void ConfirmacionWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ConfirmacionWindowClosing
        // Si se cierra la ventana de confirmación entonces reaparecerá ListaClientes
        this.setVisible(true);
        Confirmacion.setVisible(false);
        Confirmacion.dispose();
    }//GEN-LAST:event_ConfirmacionWindowClosing

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Si se cierra mostrará el mensaje de confirmación
        Confirmacion.setVisible(true);
        Confirmacion.setSize(310, 90);
        Confirmacion.setLocation(ancho/2 - 160, alto/2 - 45);
    }//GEN-LAST:event_formWindowClosing

    private void btnSi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSi1ActionPerformed
        String ideC = String.valueOf(clientesT.getValueAt(clientesT.getSelectedRow(), 0));
        if(ideC.equals("") == false){ // Busqueda por IDC, checamos que no esté vacío              
            int idc = Integer.valueOf(ideC);  
            if(idc != -1){
                BridgertonBankSociety.eliminarCliente(idc);  
                BancoListaClientes bcts= new BancoListaClientes();
                bcts.setVisible(true);
                timer.stop();
                this.setVisible(false);
                this.dispose();
                Eliminar.setVisible(false);
                Eliminar.dispose();
            }
        }
        
    }//GEN-LAST:event_btnSi1ActionPerformed

    private void btnNo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNo1ActionPerformed
        this.setVisible(true);
        Confirmacion.setVisible(false);
        Confirmacion.dispose();
    }//GEN-LAST:event_btnNo1ActionPerformed

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
            java.util.logging.Logger.getLogger(BancoListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BancoListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BancoListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BancoListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BancoListaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Confirmacion;
    private javax.swing.JDialog Eliminar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLClientes;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnNo1;
    private javax.swing.JButton btnSi;
    private javax.swing.JButton btnSi1;
    private javax.swing.JTable clientesT;
    private javax.swing.JLabel fecha_label;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lTransacciones;
    private javax.swing.JLabel message;
    private javax.swing.JLabel message1;
    // End of variables declaration//GEN-END:variables
}
