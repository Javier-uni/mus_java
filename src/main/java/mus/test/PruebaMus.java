package main.java.mus.test;
import main.java.mus.model.Baraja;
import main.java.mus.model.Carta;



public class PruebaMus {
    public static void main(String[] args) {
        // Crear la baraja
        Baraja baraja = new Baraja();

        baraja.iniciarBaraja();
        
        // Mezclar la baraja
        baraja.barajar();

        // Comprobar el tamaño de la baraja
        System.out.println("Cartas en la baraja: " + baraja.getCartas().size());

        // Sacar una carta
        Carta carta = baraja.robarCarta();
        
        // Mostrar la carta sacada
        System.out.println("Carta robada: " + carta.getCartaString() + " de " + carta.getPalo());

        // Comprobar el tamaño de la baraja después de robar
        System.out.println("Cartas restantes en la baraja: " + baraja.cartasRestantes().getCartas().size());
    }
}
