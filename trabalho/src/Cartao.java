public class Cartao {
    private String numero;
    private String nomeDoCliente;
    private double saldo;

    public Cartao(String numero, String nomeDoCliente, double saldo) {
        this.numero = numero;
        this.nomeDoCliente = nomeDoCliente;
        this.saldo = saldo;
    }


    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeDoCliente() {
        return this.nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public synchronized boolean performDebit(double value) {
        if (value <= saldo) {
            saldo -= value;
            return true;
        } else {
            return false;
        }
    }

}
