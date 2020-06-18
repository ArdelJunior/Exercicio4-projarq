package exercicio3.exceçao;
public class exceçaoMuitoVolume extends Exception {
  
    private static final long serialVersionUID = 1L;
    public exceçaoMuitoVolume() {
        super();
    }

    public exceçaoMuitoVolume(String arg0) {
        super("Dinheiro em excesso");
    }
}