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
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aurora
 */
public class AgregarCliente extends javax.swing.JFrame {
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // Lista de clientes para verificar que no haya curp
    // o idc repetidos
    
    private static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>(); // Lista de cuentas para agregar al cliente
    private static File imagen = null;  // Imagen e idc para usarlos más fácilmente con el usuario 
    private static int dato_idc = 0; // idc creado aleatoriamente sin repetir
    
    // Herramientas para calcular la posición de la ventana
    private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    
    public AgregarCliente() {
        cuentas.removeAll(cuentas);
        System.out.println(cuentas.size());
        setLocation(ancho/2-375, 10);
        initComponents();
        generarIDC();// Generamos el IDC primero para poder mostrarlo en el formulario como dato no editable   
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // formateamos la fecha para que se ingrese en número
        Date fecha = new Date();
        fecha_label.setText(sdf.format(fecha));
    }
    
    private void generarIDC(){
        // Para IDC
        for(int i=0; i<200; i++){ // Genera idc del 0 al 199 y busca alguno vacío
            if(isInClientes(i) == false){                
                dato_idc = i;
                break;
            }
        }
        txtIdc.setText(""+dato_idc);
    }
            
    private boolean isInClientes(int idc){ // Función para identificar si el idc está registrado entre los clientes 
        File file = new File(".\\src\\Files\\Clientes.txt"); // Asignamos la ruta
        
        try {
            if(file.exists()){ 
                
                // Primero leemos si no está vacío
                if(file.length() > 0){ 
                    FileInputStream fin = new FileInputStream(file); // Creamos flujo de lectura del archivo 
                    ObjectInputStream oin = new ObjectInputStream(fin); // Creamos flujo de lectura tipo objetos
                    clientes = (ArrayList<Cliente>) oin.readObject(); // Leemos el único objeto de tipo arraylist de clientes del archivo con su cast para poderlo asignar
                    for(Cliente c:clientes){ // Recorremos el arraylist en busca de clientes que coincidan con el idc generado
                        if(c.getIDC() == idc){
                            return true;
                        }
                    }
                    oin.close(); // Cerramos flujos de lectura
                    fin.close();
                }
                // Si está vacío devolvemos falso
                return false;
            }
            else{
                return false;
            }
            
        } catch (Exception e) { // Manejo de la exceción
            e.printStackTrace(); 
            return false;
        }
    }
    
    private boolean isInClientes(String curp){ // Función para identificar si el idc está registrado entre los clientes 
        File file = new File(".\\src\\Files\\Clientes.txt"); // La tura del archivo de clientes
        
        try {
            if(file.exists()){ 
                
                // Primero leemos si no está vacío
                if(file.length() > 0){
                    FileInputStream fin = new FileInputStream(file);
                    ObjectInputStream oin = new ObjectInputStream(fin);
                    clientes = (ArrayList<Cliente>) oin.readObject(); // Creamos flujos y después leemos el array de clientes
                    for(Cliente c:clientes){ // Recorremos el array comprobando que no haya sido registrado antes del curp
                        if(c.getCurp().equals(curp)){
                            return true;
                        }
                    }
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
    
    public void tabla_cuentas(Cliente.Cuenta cuenta){ // Regenera las tablas a partir de las nuevas creadas
        String[] tipos = {"Débito", "Crédito Bronce", "Crédito plata", "Crédito oro"};
        // Para la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // formateamos la fecha para que se ingrese en número
        Date fecha = new Date();
        
        DefaultTableModel model=(DefaultTableModel) tcuentas.getModel(); // Crea el modelo de la tabla a partir del actual

        Object[] fila = new Object[6]; // Crea el objeto de celdas para agregar
        fila[0] = ""+cuenta.getCuenta(); // Número de cuenta
        fila[1] = ""+cuenta.getTarjeta(); // Número de tarjeta
        fila[2] = tipos[cuenta.getTipo()-1]; // Tipo de cuenta 
        fila[3] = ""+cuenta.getClabe(); // Clabe interbancaria
        fila[4] = ""+sdf.format(cuenta.getApertura()); // Fecha de apertura
        fila[5] = ""+cuenta.getSaldo(); // Saldo positivo de la cuenta

        model.addRow(fila); // Agrega la fila al modelo de la tabla
        tcuentas.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos        
    }
    
    public void agregarCuenta(Cliente.Cuenta cta) { // Para agregar a la lista las cuentas creadas 
        
        cuentas.add(cta);
        tabla_cuentas(cta);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        archivos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tcuentas = new javax.swing.JTable();
        agregar_cuenta = new javax.swing.JButton();
        agregar_cliente = new javax.swing.JButton();
        fecha_label = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JFormattedTextField();
        txtFechanac = new javax.swing.JFormattedTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        txtIdc = new javax.swing.JTextField();

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
        setTitle("AgregarCliente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("AGREGAR A NUEVO CLIENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel1)
                .addContainerGap(289, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Seleccionar foto: ");

        archivos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        archivos.setText("Seleccionar foto...");
        archivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("IDC:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Fecha de nacimiento (dd-mm-aa):");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Direccion:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Fecha de incorporación:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("CUENTAS");

        tcuentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tcuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Cuenta", "No. Tarjeta", "Tipo de cuenta", "CLABE", "Fecha de apertura", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(tcuentas);

        agregar_cuenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        agregar_cuenta.setText("AGREGAR CUENTA");
        agregar_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_cuentaActionPerformed(evt);
            }
        });

        agregar_cliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        agregar_cliente.setText("AGREGAR");
        agregar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_clienteActionPerformed(evt);
            }
        });

        fecha_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fecha_label.setText("Fecha");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("CURP");

        txtCurp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurpActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Teléfono");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Celular");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtFechanac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yy"))));
        txtFechanac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechanacActionPerformed(evt);
            }
        });

        txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));

        txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        txtIdc.setEditable(false);
        txtIdc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(archivos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel3)
                .addGap(297, 297, 297)
                .addComponent(jLabel6))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(txtIdc, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel5)
                .addGap(134, 134, 134)
                .addComponent(jLabel9))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(txtFechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel10)
                .addGap(273, 273, 273)
                .addComponent(jLabel11))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel8))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(571, 571, 571)
                .addComponent(agregar_cuenta))
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(agregar_cliente))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addComponent(archivos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(fecha_label)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(agregar_cuenta)
                .addGap(6, 6, 6)
                .addComponent(agregar_cliente)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void archivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivosActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg"); // Asignamos el nombre y el filtro de cada archivo a escoger (Sólo imágenes)
        chooser.setFileSelectionMode(0);
        chooser.setCurrentDirectory(new File(".\\src\\Files"));
        chooser.setFileFilter(filter);// Ponemos el filtro de arriba el JFileChooser
        
        chooser.showOpenDialog(null); // Abrimos la ventana para escoger
        imagen = chooser.getSelectedFile(); // Obtenemos el archivo recogido por el chooser y lo almacenamos en la variable imagen
        if(imagen != null) archivos.setText(imagen.getName()); // Si se escogió bien el archivo, mostramos el nombre del archivo en el botón
        
        //https://www.discoduroderoer.es/como-usar-el-componente-jfilechooser-en-una-aplicacion-grafica-en-java/
    }//GEN-LAST:event_archivosActionPerformed

    private void agregar_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_cuentaActionPerformed
        // Botón para saltar a la ventana de agregar cuenta
        Cliente cliente = new Cliente();
        AgregarCuenta ac = new AgregarCuenta(cliente, this, null, false);
        ac.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_agregar_cuentaActionPerformed

    private void agregar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_clienteActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy"); // formateamos la fecha para que se ingrese en número
        
        String dato_nombre = "";
        String dato_curp = "";
        Date fecha_nac = null;
        String dato_direc = "";
        long dato_telefono = 0;
        long dato_celular = 0;
        File foto = null;
        
        boolean errors = false; // Identifica si hubo algún error en la lectura de datos, si lo hubo, se vuelve true
        
        try{ // Nombre
            dato_nombre = txtNombre.getText();
            dato_nombre = dato_nombre.toUpperCase(); // Mayúsculas todas para no tener problemas con mayúsculas/minúsculas
            if(txtNombre.getText().equals("")){ // Comprueba que la casilla del nombre no esté vacío
                message.setText("Falta Nombre o está mal");
                errors = true;
            }
        }catch(Exception e){
            message.setText("Falta Nombre o está mal");
            errors = true;
        }
        
        try{ // CURP
            dato_curp = txtCurp.getText();
            dato_curp = dato_curp.toUpperCase();// Mayúsculas todas para no tener problemas con mayúsculas/minúsculas
            if(txtCurp.getText().equals("")){ // Comprueba que la casilla del curp no esté vacío
                message.setText("Falta CURP o está mal"); 
                errors = true;
            }
            else{
                if(isInClientes(dato_curp)){
                    message.setText("Falta CURP o está mal");
                    errors = true;
                }
            }
        }catch(Exception e){
            message.setText("Falta CURP o está mal");
            errors = true;
        }
      
        try { // FECHA
            if(txtFechanac.getText().equals("") == true){
                message.setText("Falta Fecha o está mal");
                errors = true;
            }
            else
            fecha_nac = sdf.parse(txtFechanac.getText()); // Convierte el String de la casilla a fecha simple 
            
        } catch (ParseException ex) {
            message.setText("Falta Fecha o está mal");
            errors = true;
            Logger.getLogger(AgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try { // Dirección
            dato_direc = txtDireccion.getText();
            if(txtDireccion.getText().equals("")){ // Comprueba que la casilla de la dirección no esté vacía
                message.setText("Falta Dirección o está mal");
                errors = true;
            }
            
        } catch (Exception e) {
            errors = true;
            message.setText("Falta Dirección o está mal");
        }
        
        try { // Telefono
            dato_telefono = Long.valueOf(txtTelefono.getText());
            if(txtTelefono.getText().equals("")){ // Comprueba que la casilla del teléfono no esté vacío
                message.setText("Falta Teléfono o está mal");
                errors = true;
            }
        } catch (Exception e) {
            errors = true;
            message.setText("Falta Teléfono o está mal");
        }
        
        try { // Celular
            dato_celular = Long.valueOf(txtCelular.getText());
            if(txtCelular.getText().equals("")){ // Comprueba que la casilla del celular no esté vacío
                message.setText("Falta Nombre o está mal");
                errors = true;
            }
        } catch (Exception e) {
            errors = true;
            message.setText("Falta celular o está mal");
        }
        
        if(imagen != null) // si existe la foto entonces la asigna a la variable local
            foto = imagen;                
        else{
            errors = true;
            message.setText("Falta imagen o está mal");
        }
        
        if(errors){ // Si hay algún error, mostrará la ventana con el error antes asignado
            Error.setVisible(true);
            Error.setSize(310, 90);
            Error.setLocation(ancho/2 - 160, alto/2 - 45);
        }
        else{ // Intentará crear el cliente, si algo falla, lo notificará también
            Cliente nuevo_cliente = BridgertonBankSociety.crearCliente(dato_idc, dato_nombre, dato_curp, fecha_nac, dato_direc, dato_telefono, dato_celular, foto, cuentas);
            if( nuevo_cliente != null){ // Si se creo el cliente correctamente
                BancoListaClientes bcts= new BancoListaClientes();
                bcts.setVisible(true);
                this.setVisible(false);
                this.dispose();
            }
            else{
                message.setText("No se creo cliente correctamente");
                Error.setVisible(true);
                Error.setSize(310, 90);
                Error.setLocation(ancho/2 - 160, alto/2 - 45);
            }
        }

        
    }//GEN-LAST:event_agregar_clienteActionPerformed

    private void txtFechanacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechanacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechanacActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Si se cierra, abre la ventana de ListaClientes
        BancoListaClientes bcts= new BancoListaClientes();
        bcts.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurpActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Error;
    private javax.swing.JButton agregar_cliente;
    private javax.swing.JButton agregar_cuenta;
    private javax.swing.JButton archivos;
    private javax.swing.JLabel fecha_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel message;
    private javax.swing.JTable tcuentas;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JFormattedTextField txtDireccion;
    private javax.swing.JFormattedTextField txtFechanac;
    private javax.swing.JTextField txtIdc;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    
}
