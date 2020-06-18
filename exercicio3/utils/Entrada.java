package exercicio3.utils;
import java.util.*;
import java.io.*;

public final class Entrada {
    private static Scanner input = new Scanner(System.in);

    private Entrada() {

    }

    public static void fechar() {
        input.close();
    }

    public static void pause() {
        System.out.print("Caso você deseje continuar, pressione a tecla enter.");
        input.nextLine();
    }

    public static void limpar() {
        if(System.getProperty("os.name").contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException e) {

            } catch (IOException e) {

            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static String input() {
        System.out.print("> ");
        return input.nextLine();
    }
}