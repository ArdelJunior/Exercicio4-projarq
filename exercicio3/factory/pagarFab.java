package exercicio3.factory;
import exercicio3.exceçao.*;
import exercicio3.strategy.*;
public final class pagarFab {

    public static metodoParaPagar addPayMethod(String metodo) throws exceçaoNaoImplementado {
        switch (metodo){
            case "2":
                return new cartaoCreditoPagamento();
            case "1":
                return new dinheiroPagamento();
        }

        throw new exceçaoNaoImplementado(String.format("O método %s ainda não implementado", metodo));
    }
}


