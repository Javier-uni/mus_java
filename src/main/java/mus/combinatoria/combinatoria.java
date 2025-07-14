package main.java.mus.combinatoria;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.java.mus.auxiliar.matriz;
import main.java.mus.logic.*;
import main.java.mus.model.Baraja;
import main.java.mus.model.Carta;
import main.java.mus.model.Mano;


public class combinatoria {

    public double combinaciones(int m){
        if (m < 1){
            return 200; // Code error
        }
        
        return  matriz.combinatoria(m,4);
    }


    
    /**
     * Función Decrepada
     * @param mano
     * @param esMano
     * @return
     */
    public double[] combinatoriadeMano(Mano mano, boolean esMano) {
        //Iniciamos variables 
        double[] porcentajes = {1,1,1,1};
        int[] conteo = {0,0,0,0}; 

        //Solución a los statics references
        Baraja baraja = new Baraja();
        Grande grande = new Grande();
        Chica chica = new Chica();
        Pares pares = new Pares();
        matriz matriz = new matriz();

        //
        baraja.iniciarBaraja();
        baraja.normalizarBaraja();
        mano.normalizacion();
        for(int i = 0; i < mano.getSize(); i++){
            baraja.removeCarta(mano.getCarta(i));
        }

        //Iniciamos la matriz de combinaciones 330
        matriz matrix = new matriz(null);
        matrix.llenar();

        
        for(int i = 0; i < 330; i++) {
            if(grande.comparacionGrande(mano, matrix.getMano(i)) == 1 ||
                (esMano && grande.comparacionGrande(mano, matrix.getMano(i)) == 0)) {
                    porcentajes[0] = porcentajes[0] + combinatoriaProbabilidad(matrix.getMano(i),baraja);
                    conteo[0]++;
            }

            if(chica.comparacion(mano, matrix.getMano(i)) == 1 ||
                (esMano && chica.comparacion(mano, matrix.getMano(i)) == 0)) {
                    porcentajes[1] = porcentajes[1] + combinatoriaProbabilidad(matrix.getMano(i),baraja);
                    conteo[1]++;
            }

            if (pares.comparacion(mano, matrix.getMano(i)) == 1 ||
            (esMano && chica.comparacion(mano, matrix.getMano(i)) == 0)){
                porcentajes[1] = porcentajes[1] + combinatoriaProbabilidad(matrix.getMano(i),baraja);
                conteo[2]++;
            }

            
        }
        
            

        

        

        return porcentajes;
    }

    
    public double combinatoriaProbabilidad(Mano mano, Baraja barajaoriginal){
        int numerador=1;
        double denominador =1;
        Baraja baraja = barajaoriginal.copia();
        baraja.normalizarBaraja();//Aunque deberia de estar hecho en la funcion anterior lo vuelvo a poner
        baraja.borrarPalos();

        Map<Carta, Integer> agrupadas = new HashMap<>();
        for (Carta c : mano.getCartas()) {
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

        
        if(mano.getSize()<4){//Aqui Nunca se deberia de entrar
            numerador *= matriz.combinatoria(40-mano.getSize(), 4-mano.getSize());     
        }
        denominador = matriz.combinatoria(40-mano.getSize(), mano.getSize());

        return numerador/denominador;

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


    



