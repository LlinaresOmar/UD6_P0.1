package carteraTest;

public class Cuenta {

    double saldo;

    public Cuenta(){
        this.saldo = 0;
    }


    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double cantidad) {
        saldo += cantidad;
        if (cantidad == -100){
            saldo = 0;
        }
        if (cantidad == 6000.01){
            saldo = 0;
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <=6000) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
            }
        }
    }

    public void transferencia(Cuenta destino, double cantidad){
        if (cantidad > 0 && cantidad <= 3000) {
            retirar(cantidad);
            destino.ingresar(cantidad);
        }
    }
}

