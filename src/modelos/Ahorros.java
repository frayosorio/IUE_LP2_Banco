package modelos;

public class Ahorros extends Cuenta {
    private double interes = 0.02; // 2% de interés

    public Ahorros(String titular, String numero, double saldo) {
        super(titular, numero, saldo);
    }

    @Override
    public boolean retirar(double cantidad) {
        if (getSaldo() >= cantidad) {
            setSaldo(getSaldo() - cantidad);
            System.out.println("Retiro exitoso. Nuevo saldo: " + getSaldo());
            return true;
        } else {
            System.out.println("Fondos insuficientes en la cuenta de ahorros.");
            return false;
        }
    }

    public void aplicarInteres() {
        setSaldo(getSaldo() * (1 + interes));
        System.out.println("Interés aplicado. Nuevo saldo: " + getSaldo());
    }
}
