package exercicio3.factory;
import exercicio3.models.*;
public final class itemFab {

    public static Itens adicionar(String name, String price) {
        return new Itens(name, price);
    }
}

