package exercicio3.strategy;
import java.math.*;

public interface metodoParaPagar {
    boolean pagar(BigDecimal quantidade);
    void obterMetodoPagamento();
}

