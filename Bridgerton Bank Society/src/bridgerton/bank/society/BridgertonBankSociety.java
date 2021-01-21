
package bridgerton.bank.society;

import bridgerton.bank.society.GUI.BancoListaClientes;
import bridgerton.bank.society.Cliente.Cuenta;
import bridgerton.bank.society.Cliente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BridgertonBankSociety {
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    public static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    public static ArrayList<String>diccionario_errores = new ArrayList<String>();
    public static ArrayList<String> diccionario_nombres = new ArrayList<String>();
    private static File file = new File(".\\src\\Files\\Clientes.txt"); // Direccion del archivo de los clientes
    private static File filec = new File(".\\src\\Files\\Cuentas.txt"); // Direccion del archivo de los clientes
    
    static{
        diccionario_nombres.add("Javier Santaolalla");
        diccionario_nombres.add("Juan Peres");
        diccionario_nombres.add("Ricardo Montaner");
        diccionario_nombres.add("Alejandro Fernandez");
        diccionario_nombres.add("Vicente Fernandez");
        diccionario_nombres.add("Lupita Dalecia");
        diccionario_nombres.add("Frida Kaloh");
        diccionario_nombres.add("Predo Infante");
        diccionario_nombres.add("Cristian Nodal");
        diccionario_nombres.add("Lele Pons");
        
        
        diccionario_errores.add(""); // 0
        diccionario_errores.add("Clave de seguridad incorrecta"); // 1
        diccionario_errores.add("CVV incorrecto"); // 2
        diccionario_errores.add("Saldo insuficiente"); // 3
        diccionario_errores.add("Crédito agotado");// 4
        diccionario_errores.add("Longitud de la cuenta incorrecta"); // 5
        diccionario_errores.add("Clave de seguridad incorrecta");// 6
        diccionario_errores.add("Cuenta emisora no encontrada"); // 7
        
    }
    
    public static void main(String[] args) {
    }
    
    public static Cliente crearCliente(int idc, String nombre, String curp, Date fecha_nac, String direc, long telefono, long celular, File foto_cliente, ArrayList<Cuenta> cuentas){
        Cliente nuevo = new Cliente(idc, nombre, curp, fecha_nac, direc, telefono, celular, foto_cliente);
        nuevo.asignarCuentas(cuentas); // Mandamos a asignarle sus cuentas
        clienteWriter(nuevo);
        return nuevo; // Mandamos a escribir el cliente y regresamos el resultado
    }
    
    public static int hacerDeposito(String nocuenta, float cantidad, int numerodeposito, String motivo, int noCajero){
        // Buscando cuenta 
        if(nocuenta.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(nocuenta) != null){
                    return c.recibirDeposito(nocuenta, cantidad, numerodeposito, motivo, noCajero);
                }
            }
            Deposito depo = new Deposito(nocuenta, noCajero, cantidad, motivo, numerodeposito);
        }        
        if(nocuenta.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(nocuenta) != null){
                    return c.recibirDeposito(nocuenta, cantidad, numerodeposito, motivo, noCajero);
                }
            }
            Deposito depo = new Deposito(nocuenta, noCajero, cantidad, motivo, numerodeposito);
        }        
        if(nocuenta.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(nocuenta) != null){
                    return c.recibirDeposito(nocuenta, cantidad, numerodeposito, motivo, noCajero);
                }
            }
            Deposito depo = new Deposito(nocuenta, noCajero, cantidad, motivo, numerodeposito);
        }
        else{
            return -5;
        }
        
        return 0;       
    }
    
    public static int realizarTrans(String numero, String emisor, float cantidad, int numerotransferencia, String motivo, int noCajero, int clave){
        // Buscando cuenta emisora
        boolean cliente_nuestro = false;
        String nombre = "";
        int aux_error = 0;
        
        if(emisor.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(emisor) != null){
                    aux_error = c.realizarTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, clave);
                    cliente_nuestro = true;                    
                }
            }
        }
        
        if(emisor.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(emisor) != null){
                    aux_error = c.realizarTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, clave);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(emisor.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(emisor) != null){
                    aux_error = c.realizarTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, clave);
                    cliente_nuestro = true;
                }
            }
        }
        else{
            return -5;
        }
        
        if(cliente_nuestro == false){
            return -7;
        }
        
        else if(aux_error < 0){
            return aux_error;
        }
        
        // Buscando cuenta destino
        if(numero.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(numero) != null){
                    c.recibirTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero);   
                }
            }
        }
        
        if(numero.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(numero) != null){
                    c.recibirTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero);
                }
            }
        }
        
        if(numero.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(numero) != null){
                    c.recibirTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero);
                }
            }
        }
        else{
            return -5;
        }
        return 0;          
    }
    
    public static int realizarTrans(String emisor, float cantidad, int numerotransferencia, String motivo, int noCajero, int clave, int causa){
        
        //Obteniendo cuenta
        String numero="";
        switch(causa){
            case 1:
                numero = "125987546325";
            case 2:
                numero = "125988813582";
            case 3:
                numero = "154654146325";
            case 4:
                numero = "156479841354";
            case 5:
                numero = "546574513225";       
        }
        // Buscando cuenta emisora
        boolean cliente_nuestro = false;
        int aux_error = 0;
        
        if(emisor.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(emisor) != null){
                    aux_error = c.realizarTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, clave);
                    cliente_nuestro = true;                    
                }
            }
        }
        
        if(emisor.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(emisor) != null){
                    aux_error = c.realizarTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, clave);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(emisor.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(emisor) != null){
                    aux_error = c.realizarTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, clave);
                    cliente_nuestro = true;
                }
            }
        }
        else{
            return -5;
        }
        
        if(cliente_nuestro == false){
            return -7;
        }
        
        else if(aux_error < 0){
            return aux_error;
        }
        return 0;
    }
    
    public static int hacerRetiro(String nocuenta, float cantidad, int numeroretiro, int clave, int noCajero){
        
        //Buscando el cliente
        boolean cliente_nuestro = false;
        int aux_error = 0;
        
        if(nocuenta.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(nocuenta) != null){
                    aux_error = c.realizarRetiro(nocuenta, cantidad, numeroretiro, noCajero, clave);
                    cliente_nuestro = true;                    
                }
            }
        }
        
        if(nocuenta.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(nocuenta) != null){
                    aux_error = c.realizarRetiro(nocuenta, cantidad, numeroretiro, noCajero, clave);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(nocuenta.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(nocuenta) != null){
                    aux_error = c.realizarRetiro(nocuenta, cantidad, numeroretiro, noCajero, clave);
                    cliente_nuestro = true;
                }
            }
        }
        else{
            return -5;
        }
        
        if(cliente_nuestro == false){
            return -7;
        }
        else if(aux_error < 0){
            return aux_error;
        }
        
        return 0;        
    }
    
    public static float checarSaldo(String nocuenta, int clave){
        //Buscando el cliente
        boolean cliente_nuestro = false;
        float aux_error = 0;
        
        if(nocuenta.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(nocuenta) != null){
                    aux_error = c.saldo(nocuenta, clave);
                    cliente_nuestro = true;                    
                }
            }
        }
        
        if(nocuenta.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(nocuenta) != null){
                    aux_error = c.saldo(nocuenta, clave);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(nocuenta.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(nocuenta) != null){
                    aux_error = c.saldo(nocuenta, clave);
                    cliente_nuestro = true;
                }
            }
        }
        else{
            return -5;
        }
        
        if(cliente_nuestro == false){
            return -7;
        }
        else if(aux_error < 0){
            return aux_error;
        }
        
        return 0;       
    }
    
    public static int cambiarClave(String nocuenta, int cvv_atm, int clave_atm, int nclave){
        //Buscando el cliente
        boolean cliente_nuestro = false;
        int aux_error = 0;
        
        if(nocuenta.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(nocuenta) != null){
                    aux_error = c.cambiarClave(nocuenta, cvv_atm, clave_atm, nclave);
                    cliente_nuestro = true;                    
                }
            }
        }
        
        if(nocuenta.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(nocuenta) != null){
                    aux_error = c.cambiarClave(nocuenta, cvv_atm, clave_atm, nclave);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(nocuenta.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(nocuenta) != null){
                    aux_error = c.cambiarClave(nocuenta, cvv_atm, clave_atm, nclave);
                    cliente_nuestro = true;
                }
            }
        }
        else{
            return -5;
        }
        
        if(cliente_nuestro == false){
            return -7;
        }
        else if(aux_error < 0){
            return aux_error;
        }
        
        return 0;        
    }
    
    public static int checarMovs(){
        // Imprimir transacciones tiempo real
        return 0;        
    }
    
    public static int apoyarCausa(String emisor, float cantidad, int numerotransferencia, int noCajero, int clave, int causa){
        
        String motivo = "";
        int aux_error = 0;
        switch(causa){
            case 1:
                motivo = "Apoyo puma";
                aux_error = realizarTrans(emisor, cantidad, numerotransferencia, motivo, noCajero, clave, causa);
            case 2:
                motivo = "Apoyo guinda";
                aux_error = realizarTrans(emisor, cantidad, numerotransferencia, motivo, noCajero, clave, causa);
            case 3:
                motivo = "Bécalos y cambia a México";
                aux_error = realizarTrans(emisor, cantidad, numerotransferencia, motivo, noCajero, clave, causa);
            case 4:
                motivo = "Apoyo teletón";
                aux_error = realizarTrans(emisor, cantidad, numerotransferencia, motivo, noCajero, clave, causa);
            case 5:
                motivo = "Apoyo ASIF";
                aux_error = realizarTrans(emisor, cantidad, numerotransferencia, motivo, noCajero, clave, causa);         
        }
        return aux_error;
    }
    
    public static String buscadorNombres(String numero, int causa){
        clienteReader();
        clientes = (ArrayList<Cliente>) clientes;
        if(causa == 0){
            // Buscando cuenta destino
            if(numero.length() == 16){ // Si es no. de tarjeta bancaria
                for(Cliente c: clientes){
                    if(c.buscadorTarjeta(numero) != null){
                        return c.getNombre();                  
                    }
                }
            }

            if(numero.length() == 18){ // Si es clabe interbancaria
                for(Cliente c: clientes){
                    if(c.buscadorClabe(numero) != null){
                        return c.getNombre();
                    }
                }
            }

            if(numero.length() == 12){ // Si es no. de cuenta bancaria
                for(Cliente c: clientes){
                    if(c.buscadorCuenta(numero) != null){
                        return c.getNombre();
                    }
                }
            }
            else{
                return "-5";
            }

            Random rand = new Random();
            return diccionario_nombres.get(rand.nextInt(10));
        }
        else{
            switch(causa){
                case 1:
                    return "UNAM";
                case 2:
                    return "IPN";
                case 3:
                    return "Bécalos";
                case 4:
                    return "Teletón";
                case 5:
                    return "ASIF";  
                default:
                    return "";
            }
        }
    }
    
    private static boolean clienteWriter(Cliente c){
        try {
            if(file.exists()){ 
                
                // Primero leemos si no está vacío
                if(file.length() > 0){
                    FileInputStream fin = new FileInputStream(file);
                    ObjectInputStream oin = new ObjectInputStream(fin);
                    clientes = (ArrayList<Cliente>) oin.readObject();
                    oin.close();
                    fin.close();
                }
                clientes.add(c);  
                
                // Después escribimos
                FileOutputStream fout = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fout);
                out.writeObject(clientes);
                out.close();
                fout.close();
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
    }
    
    private static boolean clienteReader(){ // Solo lee las clientes
            try {
                if(file.exists()){ 

                    // Primero leemos si no está vacío
                    if(file.length() > 0){
                        FileInputStream fin = new FileInputStream(file);
                        ObjectInputStream oin = new ObjectInputStream(fin);
                        clientes = (ArrayList<Cliente>) oin.readObject();                        
                        oin.close();
                        fin.close();
                    }
                    return true;
                }
                else{
                    return false;
                }

            } catch (Exception e) {
                e.printStackTrace(); 
                return false;
            }
        }
    
    public static void limpiarClientes(){
        file.delete();
        try {
            
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(BridgertonBankSociety.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Limpieza hecha");
    }
    
    public static void limpiarCuentas(){
        filec.delete();
        try {            
            filec.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(BridgertonBankSociety.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Limpieza hecha");
    }
    
    public static boolean eliminarCliente(int idc){
        
        try {
            if(file.exists()){ 
                
                // Primero leemos si no está vacío
                if(file.length() > 0){
                    FileInputStream fin = new FileInputStream(file);
                    ObjectInputStream oin = new ObjectInputStream(fin);
                    clientes = (ArrayList<Cliente>) oin.readObject();
                    
                    for(Cliente c: clientes){
                        if(c.getIDC() == idc){
                            c.eliminarCuentas();
                            clientes.remove(c);
                            break;
                        }
                    }                    
                    oin.close();
                    fin.close();
                }
                // Limpieza de archivo
                BridgertonBankSociety.limpiarClientes();                   
                
                // Después escribimos
                FileOutputStream fout = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fout);
                out.writeObject(clientes);
                out.close();
                fout.close();
                
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
        
    }
}
