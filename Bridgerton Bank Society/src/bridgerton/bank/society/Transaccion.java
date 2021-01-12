
package bridgerton.bank.society;

import java.util.Date;

public class Transaccion {
    private int notrans;
    private Date fecha;
    private String noCajero;
    private float monto;
    private String cuentadestino;
    private String cuentaemoisora;
    private String motivo;
    private String tipo;
    protected Transaccion(){
        
    }
    protected Transaccion(int noCajero, float monto, String cuentadestino, String cuentaemisora, String motivo, String tipo){
        
    }
    public int getTrans(){
        return 0;
    }
    public Date getFecha(){
        return null;
    }
    public String getCajero(){
        return null;
    }
    public float getMonto(){
        return 0;
    }
    public String getDestino(){
        return null;
    }
    public String getEmisora(){
        return null;
    }
    public String getMotivo(){
        return null;
    }
    public String getTipo(){
        return null;
    }
}
