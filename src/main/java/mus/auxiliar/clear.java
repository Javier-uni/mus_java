package main.java.mus.auxiliar;


public class clear {
    public static void main(String[] args) {
        initMethod();
    }

    public static void initMethod() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {

        }
        System.out.flush();
        System.out.println("Programa Iniciado");
    }
}
