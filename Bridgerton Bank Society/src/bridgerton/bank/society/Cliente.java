package bridgerton.bank.society;

import java.util.ArrayList;
import java.util.Date;
enum TipoTarjeta{
            DEBITO, CREDITO_BRONCE, CREDITO_PLATA, CREDITO_ORO
        }
public class Cliente {
    private String nombre;
    private int idc;
    private String curp;
    private String fecha_nac;
    private String direc;
    private Date fecha_inc;
    private int telefono;
    private int celular;
    private String foto_cliente; /*temporal*/
    private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
    private ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    
    Cliente(int idc,String nombre, String curp, Date fecha_nac, String direc, int telefono, int celular, String foto_cliente ){
        
    }
    public Cuenta agregarCuenta(){
        
        return null;
    }
    public void eliminarCuenta(){
        
    }
    public String getNombre(){
        return null;
    }
    public String getFotoCliente(){
        return null;
    }
    public int getIDC(){
        return 0;
    }
    public Cuenta buscadorCuenta(String nocuenta){
        return null;
    }
    public Cuenta buscadorTarjeta(String notarjeta){
        return null;
    }
    public Cuenta buscadorClabe(String noclabe){
        return null;
    }
    public int realizarTransferencia(String numero, String emisor, float cantidad, int numerotransferencia, String motivo, int noCajero, Date fecha){
        
        return 0;
    }
    public String recibirTransferencia(String numero, String emisor, float cantidad, int numerotransferencia, String motivo, int noCajero, Date fecha){
        
        return this.nombre; 
    }
    public int realizarRetiro(float cantidad, int numeroretiro, Date fecha){
        
        return 0;
    }
    public String recibirDeposito(float cantidad, int numerodeposito, String motivo, Date fecha_emision, int noCajero, Date fecha){
    
        return this.nombre;
    }
    public float saldo(String numero){
        return 0;
    }
    public int cambiarClave(int cvv_atm, int clave_atm, int nclave){
        return 0;
    }
    
    private class Cuenta{
        private String nocuenta;
        private String notarjeta;
        private TipoTarjeta tipotarjeta;
        private String clabe;
        private Date fecha_apertura;
        private float saldopositivo;
        private int cvv;
        private int claveseg;
        
        Cuenta(int tipotar){
        }
        private String getCuenta(){
            return null;
        }
        private String getTarjeta(){
            return null;
        }
        private String getTipo(){
            return null;
        }
        private String getClabe(){
            return null;
        }
        private Date getApertura(){
            return null;
        }
        private float getSaldo(){
            return 0;
        }
        private int getCVV(){
            return 0;
        }
        private int getClaveseg(){
            return 0;
        }
    }
}
