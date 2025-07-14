package main.java.mus.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.mus.auxiliar.clear;
import main.java.mus.model.*;
public class PruebaTotal {
    public static void main(String[] args) {
        clear.initMethod();
        Set<String> combinacionesUnicas = new HashSet<>();
        for (int i = 0; i < 600000; i++) {
            Baraja baraja = new Baraja();
            Mano mano = new Mano();
            baraja.iniciarBaraja();
            baraja.barajar();

            // Robar 4 cartas para la mano
            for (int j = 0; j < 4; j++) {
                Carta carta = baraja.robarCarta();
                mano.addCarta(carta);
            }
            mano.normalizacion();
            mano.ordenar();

            List<Integer> numeros = new ArrayList<>();
            for (int j = 0; j < mano.getCartas().size(); j++) {
                numeros.add(mano.getCarta(j).getNumero());
            }
            Collections.sort(numeros);

            String clave = numeros.toString(); 
            combinacionesUnicas.add(clave);
            
    }
    System.out.println("Combinaciones únicas encontradas: " + combinacionesUnicas.size());
}
}
