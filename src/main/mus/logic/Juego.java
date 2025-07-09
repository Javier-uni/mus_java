package main.mus.logic;

public class Juego {

    public int conteo(int numero){
        switch (numero) {
            case 11:
                return 10;
                
            case 12:
                return 10;
                
            case 2:
                return 1;
        
            default:
                return numero;
        }
    }

}
