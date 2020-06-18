package exercicio3.exceçao;
public class exceçaoPagamentoDesautorizado extends Exception {
   
    private static final long serialVersionUID = 1L;
    public exceçaoPagamentoDesautorizado(String zeroarg) {
        super(zeroarg);
    }

    public exceçaoPagamentoDesautorizado() {
        super();
    }

    public exceçaoPagamentoDesautorizado(String zeroarg, Throwable umarg) {
        super(zeroarg, umarg);
    }

}
