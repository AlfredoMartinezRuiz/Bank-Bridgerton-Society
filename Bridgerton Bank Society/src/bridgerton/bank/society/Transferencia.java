
package bridgerton.bank.society;

public class Transferencia extends Transaccion{
    private int noTransferencia;
    Transferencia(){
        super();
    }
    Transferencia(String cuenta_dest, String cuenta_emi, String motivo, int noCajero, float monto, int noTransferencia){
        super(noCajero, noTransferencia, monto, cuenta_dest, cuenta_emi, motivo, "Transferencia");
        this.noTransferencia = noTransferencia;
        
    }
}
