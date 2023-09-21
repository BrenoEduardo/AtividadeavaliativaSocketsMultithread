public class Transacao {
    private double valor;
    private String data;
    private String hora;
    private String redeTransmissora;
    private int codigoResposta;
    private String nsu;
    private Cartao cartao;

    public Transacao(double valor, String data, String hora, String redeTransmissora, int codigoResposta, String nsu, Cartao cartao) {
        this.valor = valor;
        this.data = data;
        this.hora = hora;
        this.redeTransmissora = redeTransmissora;
        this.codigoResposta = codigoResposta;
        this.nsu = nsu;
        this.cartao = cartao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getRedeTransmissora() {
        return this.redeTransmissora;
    }

    public void setRedeTransmissora(String redeTransmissora) {
        this.redeTransmissora = redeTransmissora;
    }

    public int getCodigoResposta() {
        return this.codigoResposta;
    }

    public void setCodigoResposta(int codigoResposta) {
        this.codigoResposta = codigoResposta;
    }

    public String getNsu() {
        return this.nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public Cartao getCartao() {
        return this.cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

}
