
package bridgerton.bank.society;

import java.util.Date;

public class Transaccion {
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
}
