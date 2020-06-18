package exercicio3.fachada;
import exercicio3.factory.*;
import java.math.*;
import exercicio3.models.*;
import exercicio3.exceçao.*;

public class facCarrinho {
    private Carrinho carrinho;
    public facCarrinho() {
        this.carrinho = Carrinho.obterIntancia();
    }

    public boolean removeItem(Itens item) {
        return carrinho.removendoItem(item);
    }

    public boolean fechar() {
        return carrinho.fechado();
    }

    public void pagar(BigDecimal quantidade) throws exceçaoPagamentoDesautorizado {
        if(carrinho.precisaPagamento() == false) {
            throw new exceçaoPagamentoDesautorizado("Pagamento desautorizado");
        }
        carrinho.pagar(quantidade);
    }

    public boolean adicionarItem(String name, String price) {
        Itens item = itemFab.adicionar(name, price);
        return carrinho.adicionarItem(item);
    }

}



