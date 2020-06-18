package exercicio3.exceçao;
public class exceçaoNaoImplementado extends Exception {
    

    private static final long serialVersionUID = 1L;
    public exceçaoNaoImplementado() {
        super();
    }

    public exceçaoNaoImplementado(String zeroarg) {
        super(zeroarg);
    }

    public exceçaoNaoImplementado(String zeroarg, Throwable umarg) {
        super(zeroarg, umarg);
    }
}