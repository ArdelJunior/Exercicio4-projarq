package exercicio3.strategy;
import exercicio3.utils.*;
import java.math.*;
import exercicio3.models.*;

public class cartaoCreditoPagamento implements metodoParaPagar {
    private CartaoCredito carrinho;

    @Override
    public void obterMetodoPagamento() {
        System.out.print("Nome que está no cartão: ");
        String nome = Entrada.input();
        System.out.print("N° do cartão: ");
        String numero = Entrada.input();

        carrinho = new CartaoCredito(numero, nome);
    }

    @Override
    public boolean pagar(BigDecimal quantidade) {
        if(carrinho == null) {
            return false;
        }
        return true;
    }
}

