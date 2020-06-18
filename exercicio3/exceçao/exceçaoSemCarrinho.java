package exercicio3.exceçao;
public class exceçaoSemCarrinho extends Exception {

    private static final long serialVersionUID = 1L;

    public exceçaoSemCarrinho() {
        super();
    }

    public exceçaoSemCarrinho(String zeroarg) {
        super(zeroarg);
    }

    public exceçaoSemCarrinho(String zeroarg, Throwable umarg) {
        super(zeroarg, umarg);
    }

}