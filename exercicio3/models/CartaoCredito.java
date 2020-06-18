package exercicio3.models;

public class CartaoCredito {
    private String numero;
    private String nome;

    public CartaoCredito(String numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public String obterNome() {
        return this.nome;
    }

    public String obterNumero() {
        return this.numero;
    }
}