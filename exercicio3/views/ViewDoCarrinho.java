package exercicio3.views;
import exercicio3.strategy.*;
import exercicio3.utils.*;
import java.math.*;
import exercicio3.controllers.CarrinhoController;
import exercicio3.exceçao.*;
import exercicio3.factory.*;
import exercicio3.models.*;

public class ViewDoCarrinho {
    private CarrinhoController controller;
    private Carrinho carrinho;

    public ViewDoCarrinho() {
        this.controller = new CarrinhoController();
        this.carrinho = Carrinho.obterIntancia();
        this.command();
    }

    public void mostrarComandos() {
        System.out.println("Como funciona:\n0: Sair\n1: Colocar item no cart\n2: Fechar cart\n");
    }

    public void monstrarMeiosDePagamento() {
        System.out.println("Como você irá realizar o pagamento?\n1: Cash\n2: Cartão (de crédito)\n");
    }

    public void command() {
        boolean rodando = true;

        while (rodando && this.carrinho.precisaPagamento()) {
            rodando = administraPagamento();
        }

        while (rodando && this.carrinho.taAberto()) {
            rodando = administraCarrinho();
        }

        Entrada.fechar();
        System.out.println("Agradeçemos que nos escolher");
    }

    public boolean administraCarrinho() {
        this.mostrarCarrinho();
        this.mostrarComandos();

        String in = Entrada.input();
        if (in == "0"){
            return false;
        }else if (in == "1"){
            this.adicionaItem();
        }else if (in == "2"){
            this.controller.fechar();
        }else{
            System.out.println("O comando que foi digitado não existe.");
            Entrada.pause();
        }

        Entrada.limpar();

        return true;
    }

    public void mostrarCarrinho() {
        if (this.carrinho.taVazio() == false) {
            System.out.println("Segue o carrinho:" + this.carrinho.toString() + "\n");
        }
    }

    public boolean administraPagamento() {
        metodoParaPagar payMethod;
        BigDecimal quantidade;

        System.out.format("Valor total para ser pago: %s", this.carrinho.obterParaPagar() + "\n");

        while (true) {
            try {
                System.out.println("Você pode parcelar. Deseja pagar quanto?");
                quantidade = new BigDecimal(Entrada.input()).setScale(2);
                if (quantidade.compareTo(this.carrinho.obterParaPagar()) == 1) {
                    throw new exceçaoMuitoVolume("Muito dinheiro");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digito inválido");
            } catch (exceçaoMuitoVolume e) {
                System.out.println(e.getMessage());
            }
        }

        this.monstrarMeiosDePagamento();
        while(true) {
            try {
                String metodo = Entrada.input();
                payMethod = pagarFab.addPayMethod(metodo);
                break;
            } catch (exceçaoNaoImplementado e) {
                System.out.println(e.getMessage());
                Entrada.pause();
            }
        }
        payMethod.obterMetodoPagamento();
        if(payMethod.pagar(quantidade)) {
            try {
                this.controller.pagar(quantidade);
            } catch (exceçaoPagamentoDesautorizado e) {
                System.out.println(e.getMessage());
                Entrada.pause();
            }
        };

        Entrada.limpar();

        return true;
    }

    public void adicionaItem() {
        System.out.println("Coloque o nome:");
        String nome = Entrada.input();

        while (true) {
            try {
                System.out.println("Coloque o preço");
                String preco = Entrada.input();

                controller.adicionarItem(nome, preco);
                break;
            } catch (NumberFormatException e) {
                System.out.println("O preço está com uma formatação errada.");
            }
        }
    }
}