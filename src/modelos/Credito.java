package modelos;

public class Credito extends Cuenta {

    public double getValorPrestado() {
        return valorPrestado;
    }

    public double getTasa() {
        return tasa;
    }

    public int getPlazo() {
        return plazo;
    }

    public double getValorRetirado() {
        return valorRetirado;
    }

    private double valorPrestado;
    private double tasa;
    private int plazo;
    private double valorRetirado;

    public Credito(String titular, String numero,
            double valorPrestado, double tasa, int plazo) {
        super(titular, numero, 0);
        this.valorPrestado = valorPrestado;
        this.tasa = tasa;
        this.plazo = plazo;
    }

    @Override
    public boolean retirar(double cantidad) {
        if (valorRetirado < valorPrestado) {
            valorRetirado += cantidad;
            return true;
        } else {
            System.out.println("Ya fue retirado todo el capital del préstamo");
            return false;
        }
    }

    public double getCuota() {
        return valorPrestado * Math.pow(1 + tasa, plazo) * tasa / (Math.pow(1 + tasa, plazo) - 1);
    }

    public void pagar(double cantidad) {
        if (getSaldo() < valorPrestado) {
            var intereses = tasa * (valorPrestado - getSaldo());
            var abonoCapital = cantidad - intereses;
            if (abonoCapital > 0) {
                setSaldo(getSaldo() + cantidad);
            }
        } else {
            System.out.println("Ya la deuda está pagada");
        }

    }

}
