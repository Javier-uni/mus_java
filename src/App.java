import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initMethod();
        andamio();
    }

    public static void initMethod() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            
        }
        System.out.flush(); 
        System.out.println("Programa Inicido");
    }







    public static void andamio() {}

}