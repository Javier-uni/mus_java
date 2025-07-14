package main.java.mus.auxiliar;

public class usuarioasoftware {
    public int transformacion(String numero) {
        switch (numero) {
            case "R":
            case "r":
                return 12;
            case "2":
                return 1;
            case "3":
                return 12;
            case "S":
            case "s":
                return 10;
            case "C":
            case "c":
                return 11;
            case "A":
            case "a":
                return 10;
            default:
                return Integer.parseInt(numero);
        }
        
    }




}
