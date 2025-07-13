package main.mus.test;

import main.mus.auxiliar.*;
import main.mus.model.*;
import main.mus.combinatoria.combinatoria;

public class PuebaCombinatoriaX {
    public static void main(String[] args) {
        clear.initMethod();
        Mano mano = new Mano();
        Carta carta1 = new Carta("Rey",12,"Bastos");
        Carta carta2 = new Carta("Rey",12,"Copas");
        mano.addCarta(carta1);
        mano.addCarta(carta2);


        matriz matrizObj = new matriz();
        combinatoria combinatoriaObj = new combinatoria();
        double probabilidad = combinatoriaObj.combinatoriadeX(matrizObj.ManoToArray(mano));
        System.out.println("Probabilidad: " + probabilidad*100 + "% ");

    }
}
