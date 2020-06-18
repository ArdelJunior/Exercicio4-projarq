package exercicio3.models;
import java.math.*;

public class Itens {
    private String nome;
    private BigDecimal preco;

    public Itens(String nome, String preco) {
        this.setarNome(nome);
        this.colocaPreço(preco);
    }

    public String pegaNome() {
        return this.nome;
    }

    public void setarNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco.toString();
    }

    private void colocaPreço(String preco) {
        this.preco = new BigDecimal(preco).setScale(2, RoundingMode.HALF_UP);
    }

    public String toString() {
        return String.format("%-20s %6s", this.nome, this.preco);
    }
}