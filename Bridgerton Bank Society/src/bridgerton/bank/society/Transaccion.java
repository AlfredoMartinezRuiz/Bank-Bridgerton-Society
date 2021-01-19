
package bridgerton.bank.society;

import static bridgerton.bank.society.BridgertonBankSociety.clientes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Transaccion implements Serializable{
    // Variable de ayuda para manejar transacciones
    ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    
    private int notrans;
    private Date fecha;
    private int noCajero;
    private float monto;
    private String cuentadestino;
    private String cuentaemoisora;
    private String motivo;
    private String tipo;
    protected Transaccion(){
        
    }
    protected Transaccion(int noCajero, int notrans, float monto, String cuentadestino, String cuentaemisora, String motivo, String tipo){
        Date fecha = new Date();
        this.notrans = notrans;
        this.fecha = fecha;
        this.noCajero = noCajero;
        this.cuentadestino = cuentadestino;
        this.cuentaemoisora = cuentaemisora;
        this.motivo = motivo;
        this.tipo = tipo;
        this.monto = monto;
        transWriter(this);
    }
    public int getTrans(){
        return this.notrans;
    }
    public Date getFecha(){
        return this.fecha;
    }
    public int getCajero(){
        return this.noCajero;
    }
    public float getMonto(){
        return this.monto;
    }
    public String getDestino(){
        return this.cuentadestino;
    }
    public String getEmisora(){
        return this.cuentaemoisora;
    }
    public String getMotivo(){
        return this.motivo;
    }
    public String getTipo(){
        return this.tipo;
    }
    public boolean transWriter(Transaccion t){
        System.out.println("Hola");
        File file = new File(".\\src\\Files\\Transacciones.txt"); // dirección del archivo
        try {
            if(file.exists()){ // Primero leemos
                
                // Creamos los flujos de lectura del archivo con tipo objeto
                if(file.length() > 0){                    
                    
                    FileInputStream fin = new FileInputStream(file);                
                    ObjectInputStream oin = new ObjectInputStream(fin);
                    transacciones = (ArrayList<Transaccion>) oin.readObject(); // Leemos el objeto del archivo y lo cargamos en clientes con su cast a ArrayList tipo clientes
                    // Cerramos flujos de lectura y devolvemos true porque fue exitoso
                    oin.close();
                    fin.close();
                }
                transacciones.add(t);

                // Después escribimos
                FileOutputStream fout = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fout);
                out.writeObject(transacciones);
                out.close();
                fout.close();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
    }

    public boolean compareTo(Transaccion t) {
        if(this.notrans == t.notrans) return true;        
        else return false;
    }
}
