package carteraTest;

public class Cuenta {

    double saldo;
    double K_IngresoMax = 6000;
    double K_RetiradaMax = 6000;
    double K_TransfMax = 3000;

    public Cuenta(){
        this.saldo = 0;
    }


    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0 && cantidad <= K_IngresoMax){
        saldo += cantidad;
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= K_RetiradaMax) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
            }
        }
    }

    public void transferencia(Cuenta destino, double cantidad){
        if (cantidad > 0 && cantidad <= K_TransfMax) {
            retirar(cantidad);
            destino.ingresar(cantidad);
        }
    }
}

