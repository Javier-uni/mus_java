package main.mus.test;

import main.mus.auxiliar.clear;
import main.mus.model.Baraja;
import main.mus.model.Carta;
import main.mus.model.Mano;


public class PruebaManoRandom {
    public static void main(String[] args) {
        clear.initMethod();


        Baraja baraja = new Baraja();
        Mano mano = new Mano();
        baraja.iniciarBaraja();
        baraja.barajar();

        // Robar 4 cartas para la mano
        for (int i = 0; i < 4; i++) {
            Carta carta = baraja.robarCarta();
            mano.addCarta(carta);
        }


        // Mostrar las cartas de la mano
        for (Carta carta : mano.getCartas()) {
            System.out.println("Carta en la mano: " + carta.getCartaString() + " de " + carta.getPalo());
        }

        // Obtener la carta alta
        Carta cartaAlta = mano.getCartaAlta();
        System.out.println("Carta alta en la mano: " + cartaAlta.getCartaString() + " de " + cartaAlta.getPalo());

        // Obtener la carta baja
        Carta cartaBaja = mano.getCartaBaja();
        System.out.println("Carta baja en la mano: " + cartaBaja.getCartaString() + " de " + cartaBaja.getPalo());

        // Ordenar la mano
        Mano manoOrdenada = mano.ordenar();
        System.out.println("Mano ordenada:");
        for (Carta carta : manoOrdenada.getCartas()) {
            System.out.println("Carta: " + carta.getCartaString() + " de " + carta.getPalo());
        }
    }

}
