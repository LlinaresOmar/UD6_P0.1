package carteraTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class carteraTest {

    //Tests ingresos

    @Test
    void testAlCrearCuentaElSaldoEs0(){
        Cuenta c = new Cuenta();
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testIngreso100CuentaVaciaSaldoEs100(){
        Cuenta c = new Cuenta();
        c.ingresar(100);
        assertEquals(100, c.getSaldo());
    }

    @Test
    void testIngreso3000CuentaVaciaSaldoEs3000(){
        Cuenta c = new Cuenta();
        c.ingresar(3000);
        assertEquals(3000, c.getSaldo());
    }

    @Test
    void testIngreso3000CuentaCon100ElSaldoEs3100(){
        Cuenta c = new Cuenta();
        c.ingresar(100);
        c.ingresar(3000);
        assertEquals(3100, c.getSaldo());
    }

    @Test
    void testIngresoMenos100CuentaVaciaElSaldoEs0(){
        Cuenta c = new Cuenta();
        c.ingresar(-100);
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testMaximo2Decimales(){
        Cuenta c = new Cuenta();
        c.ingresar(100.45);
        assertEquals(100.45, c.getSaldo());
    }

    @Test
    void testIngrersoMaximo6000enVaciaEs6000(){
        Cuenta c = new Cuenta();
        c.ingresar(6000);
        assertEquals(6000, c.getSaldo());
    }


    @Test
    void testIngrersoMaximo600con01enVaciaEs0(){
        Cuenta c = new Cuenta();
        c.ingresar(6000.01);
        assertEquals(0, c.getSaldo());
    }

    //Test retiradas

    @Test
    void testRetirada100en500es400(){
        Cuenta c = new Cuenta();
        c.ingresar(500);
        c.retirar(100);
        assertEquals(400, c.getSaldo());
    }

    @Test
    void testRetiradaNoPuedeSerMayorqueSaldo(){
        Cuenta c = new Cuenta();
        c.ingresar(200);
        c.retirar(500);
        assertEquals(200, c.getSaldo());
    }

    @Test
    void testRetiradanoNoPuedeSerNegativo(){
        Cuenta c = new Cuenta();
        c.retirar(-100);
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testRetiradanoMaximo2decimales(){
        Cuenta c = new Cuenta();
        c.ingresar(500);
        c.retirar(100.45);
        assertEquals(399.55, c.getSaldo());
    }

    @Test
    void testRetiradanoMaximo6000(){
        Cuenta c = new Cuenta();
        c.ingresar(5000);
        c.ingresar(2000);
        c.retirar(6000);
        assertEquals(1000, c.getSaldo());
    }

    @Test
    void testRetiradanoMaximo600con001(){
        Cuenta c = new Cuenta();
        c.ingresar(5000);
        c.ingresar(2000);
        c.retirar(6000.001);
        assertEquals(7000, c.getSaldo());
    }

    //Tests de transferencias

    @Test
    void testTransferencia(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(500);
        c2.ingresar(50);
        c1.transferencia(c2, 100);
        assertEquals(400, c1.getSaldo());
        assertEquals(150, c2.getSaldo());
    }

    @Test
    void testTransferenciaNegativos(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(500);
        c2.ingresar(50);
        c1.transferencia(c2, -100);
        assertEquals(500, c1.getSaldo());
        assertEquals(50, c2.getSaldo());
    }

    @Test
    void testTransferenciaMax3000(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(3500);
        c2.ingresar(50);
        c1.transferencia(c2, 3000);
        assertEquals(500, c1.getSaldo());
        assertEquals(3050, c2.getSaldo());
    }

    @Test
    void testTransferenciaMax3000con01(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(3500);
        c2.ingresar(50);
        c1.transferencia(c2, 3000.01);
        assertEquals(3500, c1.getSaldo());
        assertEquals(50, c2.getSaldo());
    }

}
