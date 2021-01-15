
package bridgerton.bank.society;

public class Deposito extends Transaccion{
    private int noDeposito;
    Deposito(){
        super();
    }
    Deposito(String cuenta_dest, int noCajero, float monto, String motivo, int noDeposito){
        super(noCajero, noDeposito, monto, cuenta_dest, "-", motivo, "Deposito");
        this.noDeposito = noDeposito;
    }
}
