package main.mus.model;

import java.util.ArrayList;
import java.util.List;


public class Mano {

  
    private List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
        }

        public void addCarta(Carta c) {
            if (c == null) {
                throw new IllegalArgumentException("Carta cannot be null");
            }
            if (cartas.size() >= 4) {
                throw new IllegalStateException("Cannot add more than 4 cartas to a mano");
            }
            cartas.add(c);
        }

        public List<Carta> getCartas() {
            return cartas;
        }

        public void clear() {
            cartas.clear();
        }
    

}
