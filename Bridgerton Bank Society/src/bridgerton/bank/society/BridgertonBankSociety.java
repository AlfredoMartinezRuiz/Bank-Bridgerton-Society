
package bridgerton.bank.society;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class BridgertonBankSociety {
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    public static ArrayList<String>diccionario_errores = new ArrayList<String>();
    public static ArrayList<String> diccionario_nombres = new ArrayList<String>();
    
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
    }
    
    public static void main(String[] args) {
        
    }
    
    public static Cliente crearCliente(int idc, String nombre, String curp, Date fecha_nac, String direc, int telefono, int celular, String foto_cliente){
        Cliente nuevo = new Cliente(idc, nombre, curp, fecha_nac, direc, telefono, celular, foto_cliente);
        clientes.add(nuevo);        
        return null;        
    }
    
    public static String hacerDeposito(String nocuenta, float cantidad, int numerodeposito, String motivo, Date fecha_emision, int noCajero){
        // Obteniendo fecha
        Date fecha = new Date();
        
        // Buscando cuenta
        boolean cliente_nuestro = false;
        String nombre = "";
        
        if(nocuenta.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(nocuenta) != null){
                    nombre = c.recibirDeposito(cantidad, numerodeposito, motivo, fecha_emision, noCajero, fecha);
                    cliente_nuestro = true;                    
                }
            }
        }
        
        if(nocuenta.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(nocuenta) != null){
                    nombre = c.recibirDeposito(cantidad, numerodeposito, motivo, fecha_emision, noCajero, fecha);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(nocuenta.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(nocuenta) != null){
                    nombre = c.recibirDeposito(cantidad, numerodeposito, motivo, fecha_emision, noCajero, fecha);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(cliente_nuestro == false){
            Random rand = new Random();
            nombre = diccionario_nombres.get(rand.nextInt(10));
        }
        
        return nombre;        
    }
    
    public static String realizarTrans(String numero, String emisor, float cantidad, int numerotransferencia, String motivo, int noCajero){
        // Obteniendo fecha
        Date fecha = new Date();
        
        // Buscando cuenta emisora
        boolean cliente_nuestro = false;
        String nombre = "";
        
        if(emisor.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(emisor) != null){
                    c.realizarTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, fecha);
                    cliente_nuestro = true;                    
                }
            }
        }
        
        if(emisor.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(emisor) != null){
                    c.realizarTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, fecha);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(emisor.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(emisor) != null){
                    c.realizarTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, fecha);
                    cliente_nuestro = true;
                }
            }
        }
        
        // Buscando cuenta destino
        cliente_nuestro = false;
        
        if(numero.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(numero) != null){
                    nombre = c.recibirTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, fecha);
                    cliente_nuestro = true;                    
                }
            }
        }
        
        if(numero.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(numero) != null){
                    nombre = c.recibirTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, fecha);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(numero.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(numero) != null){
                    nombre = c.recibirTransferencia(numero, emisor, cantidad, numerotransferencia, motivo, noCajero, fecha);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(cliente_nuestro == false){
            Random rand = new Random();
            nombre = diccionario_nombres.get(rand.nextInt(10));
        }
        
        return nombre;  
    }
    
    public static int hacerRetiro(){
        boolean cliente_nuestro = false;
        String nombre = "";
        
        if(nocuenta.length() == 16){ // Si es no. de tarjeta bancaria
            for(Cliente c: clientes){
                if(c.buscadorTarjeta(nocuenta) != null){
                    nombre = c.recibirDeposito(cantidad, numerodeposito, motivo, fecha_emision, noCajero);
                    cliente_nuestro = true;                    
                }
            }
        }
        
        if(nocuenta.length() == 18){ // Si es clabe interbancaria
            for(Cliente c: clientes){
                if(c.buscadorClabe(nocuenta) != null){
                    nombre = c.recibirDeposito(cantidad, numerodeposito, motivo, fecha_emision, noCajero);
                    cliente_nuestro = true;
                }
            }
        }
        
        if(nocuenta.length() == 12){ // Si es no. de cuenta bancaria
            for(Cliente c: clientes){
                if(c.buscadorCuenta(nocuenta) != null){
                    nombre = c.recibirDeposito(cantidad, numerodeposito, motivo, fecha_emision, noCajero);
                    cliente_nuestro = true;
                }
            }
        }
        return 0;        
    }
    public static int checarSaldo(){
        
        return 0;        
    }
    public static int cambiarClave(){
        
        return 0;        
    }
    public static int checarMovs(){
        
        return 0;        
    }
    public static void apoyarCausa(int causa){
        
    }
    public static void lolalatrailera(){
        System.out.println("prueba1");
    }
}
