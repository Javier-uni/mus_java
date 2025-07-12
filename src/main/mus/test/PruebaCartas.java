package main.mus.test;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

import main.mus.model.Baraja;
import main.mus.model.Carta;
import main.mus.model.Mano;
import main.mus.auxiliar.clear;
import main.mus.logic.Grande;

public class PruebaCartas {

    public static void main(String[] args) {
        Mano manoseg = new Mano();
        Carta carta1 = new Carta("Rey",12,"Bastos");
        Carta carta2 = new Carta("AS", 1, "Copas");
        manoseg.addCarta(carta1);
        manoseg.addCarta(carta1);
        manoseg.addCarta(carta2);
        manoseg.addCarta(carta2);

        clear.initMethod();
        int contador= 0;
        Grande grande = new Grande();
        int check = 0;
        double porcentaje = 0;
        for (int i = 0; i < 100000; i++) {
            contador++;
            System.out.println(contador);
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
            
            int resultado = grande.comparacion(mano, manoseg);

            if (resultado == 1 || resultado == 0){
                check++;
            }
            mano.clear();
            
            
        }
        porcentaje = (((double)check / (double)contador) * 100);
        
        System.out.println(porcentaje + "%");
    }
}


