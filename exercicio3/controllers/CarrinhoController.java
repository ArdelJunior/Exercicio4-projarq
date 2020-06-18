package exercicio3.controllers;
import exercicio3.fachada.*;
import exercicio3.exceçao.*;
import java.math.*;

public class CarrinhoController {
    private facCarrinho cart;
    public CarrinhoController() {
        this.cart = new facCarrinho();
    }

    public boolean fechar() {
        return cart.fechar();
    }

    public void pagar(BigDecimal quantidade) throws exceçaoPagamentoDesautorizado {
        cart.pagar(quantidade);
    }

    public boolean adicionarItem(String nome, String preco) {
        return cart.adicionarItem(nome, preco);
    }
}

