package exercicio3.models;
import java.math.*;
import java.util.*;
public final class Carrinho {
    private final static Carrinho instancia = new Carrinho();
    private boolean fechado = false;
    private ArrayList<Itens> items = new ArrayList<>();
    private BigDecimal aPagar;

    public static Carrinho obterIntancia() {
        return instancia;
    }

    public void pagar(BigDecimal quantia) {
        aPagar = aPagar.subtract(quantia);
    }

    public int tamanho() {
        return items.size();
    }

    public ArrayList<Itens> obterItem() {
        return items;
    }

    public boolean taAberto() {
        return !fechado;
    }

    public boolean adicionarItem(Itens item) {
        return items.add(item);
    }

    public boolean removendoItem(Itens item) {
        return items.remove(item);
    }

    public boolean precisaPagamento() {
        return obterParaPagar().compareTo(BigDecimal.ZERO) > 0;
    }


    public String toString() {
        StringBuilder stringConstrutor = new StringBuilder();
        for (Itens item : this.items) {
            stringConstrutor.append(item.toString()).append(System.lineSeparator());
        }
        stringConstrutor.append(String.format("%-20s %6s", "TOTAL", this.getTotal()));
        return stringConstrutor.toString();
    }

    public boolean fechado() {
        if(fechado) {
            return false;
        }
        fechado = true;
        aPagar = new BigDecimal(getTotal());
        return true;
    }

    public boolean taVazio() {
        return tamanho() == 0;
    }

    public String getTotal() {
        return this.items.stream().map(item -> new BigDecimal(item.getPreco()))
                .reduce(BigDecimal.ZERO, (total, item) -> item.add(total)).toString();
    }

    public BigDecimal obterParaPagar() {
        return this.aPagar;
    }
}