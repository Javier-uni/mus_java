package main.mus.combinatoria;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.mus.model.Carta;
import main.mus.model.Mano;
import main.mus.model.Baraja;
import main.mus.auxiliar.matriz;
import main.mus.logic.*;


public class combinatoria {

    public double combinaciones(int m){
        if (m < 1){
            return 200; // Code error
        }
        
        return  matriz.combinatoria(m,4);
    }


    
    
    public double[] combinatoriadeMano(Mano mano, boolean esMano) {
        double[] porcentajes = {1,1,1,1};
        int[] conteo = {0,0,0,0}; 
        Baraja baraja = new Baraja();
        Grande grande = new Grande();
        baraja.iniciarBaraja();
        baraja.normalizarBaraja();

        matriz matrix = new matriz(null);
        matrix.llenar();

        
        for(int i = 0; i < 330; i++) {
            if(grande.comparacionGrande(mano, matrix.getMano(i)) == 1) {
                conteo[1]++;
            }
        }
        
            

        

        

        return porcentajes;
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
        
        Map<Carta, Integer> agrupadas = new HashMap<>();
        for (Carta c : cartas) {
            c.normalizarCarta();
            agrupadas.put(c, agrupadas.getOrDefault(c, 0) + 1);
            }

        for (Map.Entry<Carta, Integer> entry : agrupadas.entrySet()) {
            Carta carta = entry.getKey();
            int cantidades = entry.getValue();
            int disponibles = baraja.numCartasIgual(carta);  // Cuántas quedan de ese tipo
            baraja.removeCarta(carta);  // Evitar contar duplicados

            numerador *= matriz.combinatoria(disponibles, cantidades);
                    }
        if(cartas.size()<4){
            numerador *= matriz.combinatoria(cantidad, 4-cartas.size());     
        }

        double jugadasT = matriz.combinatoria(40, 4 );
        

        return numerador/jugadasT;
    }



}


    



