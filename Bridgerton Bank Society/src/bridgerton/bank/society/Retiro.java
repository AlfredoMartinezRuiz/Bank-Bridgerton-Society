
package bridgerton.bank.society;

public class Retiro extends Transaccion{
    private int noRetiro;
    Retiro(){
        super();
    }
    Retiro(String cuenta_emi, int noCajero, float monto, int numeroretiro){
        super(noCajero, numeroretiro, monto, "-", cuenta_emi, "-", "Retiro");
        this.noRetiro = noRetiro;
    }
}
