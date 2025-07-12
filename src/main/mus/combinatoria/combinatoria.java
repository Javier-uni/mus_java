package main.mus.combinatoria;


import java.util.ArrayList;
import main.mus.model.Carta;
import main.mus.model.Baraja;
import main.mus.auxiliar.matriz;


public class combinatoria {

    public int combinaciones(int m){
        if (m < 1){
            return 200; // Code error
        }
        
        return (int) matriz.combinatoria(m,4);
    }


    




    public double combinatoriadeX(ArrayList<Carta> cartas) {
        if(cartas.size() > 4){
            throw new IllegalArgumentException("Esta Función no esta pensada para pasarle mas de 4 cartas");
        }

        int cantidad = 40-cartas.size();
        int numerador = 1;
        Baraja baraja = new Baraja();
        baraja.iniciarBaraja();
        baraja.normalizarBaraja();
        
        for(Carta c: cartas){
            int num = 0;
            
            c.normalizarCarta();
            num = baraja.numCartasIgual(c);
            baraja.removeCarta(c);

            int combinacionesCarta = (int) matriz.combinatoria(num, 1);
            
            numerador = numerador * combinacionesCarta;
        }

        int jugadasT = combinaciones(cantidad);
        

        return numerador/jugadasT;
    }



}


    



