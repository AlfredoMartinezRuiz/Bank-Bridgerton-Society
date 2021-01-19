package bridgerton.bank.society;

import static bridgerton.bank.society.BridgertonBankSociety.clientes;
import static bridgerton.bank.society.BridgertonBankSociety.diccionario_nombres;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

enum TipoTarjeta{
            DEBITO(0, 1), CREDITO_BRONCE(5000, 2), CREDITO_PLATA(20000, 3), CREDITO_ORO(70000, 4);
            private final float saldo;
            private final int tipo;
            
            private TipoTarjeta(float saldo, int tipo){
                this.saldo = saldo;
                this.tipo = tipo;
            }
            
            public float getSaldo(){
                return this.saldo;
            }
            
            public int getTipo(){
              return this.tipo;
            }
            
        }

public class Cliente implements Serializable{
    private String nombre;
    private int idc;
    private String curp;
    private Date fecha_nac;
    private String direc;
    private Date fecha_inc;
    private long telefono;
    private long celular;
    private File foto_cliente; /*temporal*/
    private static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
    private static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    
    Cliente(int idc,String nombre, String curp, Date fecha_nac, String direc, long telefono, long celular, File foto_cliente ){
        Date fecha = new Date();
        this.idc = idc;
        this.nombre = nombre;
        this.curp = curp;
        this.fecha_nac = fecha_nac;
        this.direc = direc;
        this.fecha_inc = fecha;
        this.telefono = telefono;
        this.celular = celular;
        this.foto_cliente = foto_cliente;
    }

    public Cliente() {
        
    }
   
    public Cuenta agregarCuenta(String nocuenta, String notarjeta, int tipo, String clabe, Date fecha, int cvv, int claveseg){
        Cuenta cuenta = new Cuenta(nocuenta, notarjeta, tipo, clabe, fecha, cvv, claveseg);
        cuentas.add(cuenta);        
        return cuenta;
    }
    public void asignarCuentas(ArrayList<Cuenta> n_cuentas){
        cuentas = n_cuentas;
    }
    public boolean eliminarCuenta(String nocuenta){
        // Buscando cuenta
        int size = cuentas.size();
        Cuenta aux = this.buscadorCuenta(nocuenta);       
        cuentas.remove(aux);
        
        if(size < cuentas.size()) return true;
        else return false;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public File getFotoCliente(){
        return this.foto_cliente;
    }
    
    public int getIDC(){
        return this.idc;
    }
    
    public String getCurp(){
        return this.curp;
    }
    
    public Date getFechaN(){
        return this.fecha_nac;
    }
    
    public String getDirec(){
        return this.direc;
    }
    
    public Date getFechaI(){
        return this.fecha_inc;
    }
    
    public long getTelefono(){
        return this.telefono;
    }
    
    public long getCelular(){
        return this.celular;
    }
    
    public Cuenta buscadorCuenta(String nocuenta){
        for(Cuenta c: cuentas){ // Recorre todas las cuentas en búsqueda de la coincidencia con el número de cuenta
            if(c.notarjeta.equals(nocuenta)) return c;               
        }
        return null;
    }
    
    public Cuenta buscadorTarjeta(String notarjeta){
        for(Cuenta c: cuentas){ // Recorre todas las cuentas en búsqueda de la coincidencia con el número de tarjeta
            if(c.notarjeta.equals(notarjeta)) return c;               
        }
        return null;
    }
    
    public Cuenta buscadorClabe(String noclabe){
        for(Cuenta c: cuentas){ // Recorre todas las cuentas en búsqueda de la coincidencia con el número de clabe
            if(c.notarjeta.equals(noclabe)) return c;               
        }
        return null;
    }
    
    public int realizarTransferencia(String numero, String emisor, float cantidad, int numerotransferencia, String motivo, int noCajero, int clave){
    // Trabajando con la cuenta
        // Buscando cuenta estando totalmente seguros que aquí está la cuenta
        Cuenta cuenta = new Cuenta();
        if(emisor.length() == 16){ // Si es no. de tarjeta bancaria
            cuenta = this.buscadorTarjeta(emisor);
        }
        if(emisor.length() == 12){ // Si es no. de cuenta
            cuenta = this.buscadorCuenta(emisor);
        }
        if(emisor.length() == 18){ // Si es no. de clabe
            cuenta = this.buscadorClabe(emisor);
        }
        
        if(cuenta.claveseg == clave){ // Comprobando clave correcta
            if(cuenta.compararSaldo(cantidad)){ // Comprobando el saldo
                cuenta.saldopositivo = cuenta.saldopositivo - cantidad;

            // Trabajando con la transaccion
                Transferencia transferencia = new Transferencia(numero, emisor, motivo, noCajero, cantidad, numerotransferencia);
                transacciones.add(transferencia);
                return 0;
            }
            else return -3;
        }
        else return -1;
    }
    
    public int recibirTransferencia(String numero, String emisor, float cantidad, int numerotransferencia, String motivo, int noCajero){
        
    // Trabajando con la cuenta
        // Buscando cuenta estando totalmente seguros que aquí está la cuenta
        Cuenta cuenta = new Cuenta();
        if(numero.length() == 16){ // Si es no. de tarjeta bancaria
            cuenta = this.buscadorTarjeta(numero);
        }
        if(numero.length() == 12){ // Si es no. de cuenta
            cuenta = this.buscadorCuenta(numero);
        }
        if(numero.length() == 18){ // Si es no. de clabe
            cuenta = this.buscadorClabe(numero);
        }
        cuenta.saldopositivo = cuenta.saldopositivo + cantidad;

        // Trabajando con la transaccion
        Transferencia transferencia = new Transferencia(numero, emisor, motivo, noCajero, cantidad, numerotransferencia);
        transacciones.add(transferencia);
        
        return 0;
    }
    
    public int realizarRetiro(String nocuenta, float cantidad, int numeroretiro, int noCajero, int clave){
        // Trabajando con la cuenta
        // Buscando cuenta estando totalmente seguros que aquí está la cuenta
        Cuenta cuenta = new Cuenta();
        if(nocuenta.length() == 16){ // Si es no. de tarjeta bancaria
            cuenta = this.buscadorTarjeta(nocuenta);
        }
        if(nocuenta.length() == 12){ // Si es no. de cuenta
            cuenta = this.buscadorCuenta(nocuenta);
        }
        if(nocuenta.length() == 18){ // Si es no. de clabe
            cuenta = this.buscadorClabe(nocuenta);
        }
        
        if(cuenta.claveseg == clave){ // Comprobando clave correcta
            if(cuenta.compararSaldo(cantidad)){ // Comprobando el saldo
                cuenta.saldopositivo = cuenta.saldopositivo - cantidad;

            // Trabajando con la transaccion
                Retiro retiro = new Retiro(nocuenta, noCajero, cantidad, numeroretiro);
                transacciones.add(retiro);
                return 0;
            }
            else return -3;
        }
        else return -1;
    }
    
    public int recibirDeposito(String nocuenta, float cantidad, int numerodeposito, String motivo, int noCajero){
         // Trabajando con la cuenta
        // Buscando cuenta estando totalmente seguros que aquí está la cuenta
        Cuenta cuenta = new Cuenta();
        if(nocuenta.length() == 16){ // Si es no. de tarjeta bancaria
            cuenta = this.buscadorTarjeta(nocuenta);
        }
        if(nocuenta.length() == 12){ // Si es no. de cuenta
            cuenta = this.buscadorCuenta(nocuenta);
        }
        if(nocuenta.length() == 18){ // Si es no. de clabe
            cuenta = this.buscadorClabe(nocuenta);
        }
        cuenta.saldopositivo = cuenta.saldopositivo + cantidad;

        // Trabajando con la transaccion
        Deposito deposito = new Deposito(nocuenta, noCajero, cantidad, motivo, numerodeposito);
        transacciones.add(deposito);
        
        return 0;
    }
    
    public float saldo(String nocuenta, int clave){
        // Trabajando con la cuenta
        // Buscando cuenta estando totalmente seguros que aquí está la cuenta
        Cuenta cuenta = new Cuenta();
        if(nocuenta.length() == 16){ // Si es no. de tarjeta bancaria
            cuenta = this.buscadorTarjeta(nocuenta);
        }
        if(nocuenta.length() == 12){ // Si es no. de cuenta
            cuenta = this.buscadorCuenta(nocuenta);
        }
        if(nocuenta.length() == 18){ // Si es no. de clabe
            cuenta = this.buscadorClabe(nocuenta);
        }
        
        if(cuenta.claveseg == clave){ // Comprobando clave correcta
            return cuenta.saldopositivo;
        }
        else return -1;
    }
    
    public int cambiarClave(String nocuenta, int cvv_atm, int clave_atm, int nclave){
        // Trabajando con la cuenta
        // Buscando cuenta estando totalmente seguros que aquí está la cuenta
        Cuenta cuenta = new Cuenta();
        if(nocuenta.length() == 16){ // Si es no. de tarjeta bancaria
            cuenta = this.buscadorTarjeta(nocuenta);
        }
        if(nocuenta.length() == 12){ // Si es no. de cuenta
            cuenta = this.buscadorCuenta(nocuenta);
        }
        if(nocuenta.length() == 18){ // Si es no. de clabe
            cuenta = this.buscadorClabe(nocuenta);
        }
        
        if(cuenta.claveseg == clave_atm){ // Comprobando clave correcta
            if(cuenta.cvv == cvv_atm){
                cuenta.claveseg = nclave;
                return 0;
            }
            return -2;
        }
        else return -1;
    }
    
    public class Cuenta{
        private String nocuenta;
        private String notarjeta;
        private TipoTarjeta tipotarjeta;
        private String clabe;
        private Date fecha_apertura;
        private float saldopositivo;
        private int cvv;
        private int claveseg;
        
        Cuenta(){
            
        }
        
        public Cuenta(String nocuenta, String notarjeta, int tipo, String clabe, Date fecha, int cvv, int claveseg){
            this.nocuenta = nocuenta;
            this.notarjeta = notarjeta;
            this.clabe = clabe;
            this.fecha_apertura = fecha;
            this.cvv = cvv;
            this.claveseg = claveseg;
            
            switch(tipo){
                case 1:
                    tipotarjeta = TipoTarjeta.DEBITO;
                    break;
                case 2:
                    tipotarjeta = TipoTarjeta.CREDITO_BRONCE;
                    break;
                case 3:
                    tipotarjeta = TipoTarjeta.CREDITO_PLATA;
                    break;
                case 4:
                    tipotarjeta = TipoTarjeta.CREDITO_ORO;
                    break;
            }
            this.saldopositivo = tipotarjeta.getSaldo();
        }
        public String getCuenta(){
            return this.nocuenta;
        }
        public String getTarjeta(){
            return this.notarjeta;
        }
        public int getTipo(){
            return this.tipotarjeta.getTipo();
        }
        public String getClabe(){
            return this.clabe;
        }
        public Date getApertura(){
            return this.fecha_apertura;
        }
        public float getSaldo(){
            return this.saldopositivo;
        }
        public int getCVV(){
            return this.cvv;
        }
        public int getClaveseg(){
            return this.claveseg;
        }
        private boolean compararSaldo(float costo){
            return this.saldopositivo > costo;
        }
    }
}
