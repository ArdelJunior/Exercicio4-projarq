package exercicio3.strategy;
import java.math.*;

public class dinheiroPagamento implements metodoParaPagar {

    @Override
    public void obterMetodoPagamento() {
    }

    @Override
    public boolean pagar(BigDecimal quantidade) {
        return true;
    }
}

