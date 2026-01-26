public class Produto {

    private int id;
    private String nome;
    private double valor;

    public Produto (String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public void setValor (double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
