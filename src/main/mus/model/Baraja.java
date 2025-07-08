package main.mus.model;
import java.util.ArrayList;
import java.util.List;


    public class Baraja {
        private List<Carta> cartas;

        public Baraja() {
            cartas = new ArrayList<>();
        }

        public void addCarta(Carta c) {
            cartas.add(c);
        }

        public List<Carta> getCartas() {
            return cartas;
        }

        public void clear() {
            cartas.clear();
        }

        public void iniciarBaraja() {
            String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
            for (String palo : palos) {
                for (int i = 1; i <= 10; i++) {
                    String cartaString = i == 8 ? "Sota" : (i == 9 ? "Caballo" : (i == 10 ? "Rey" : String.valueOf(i)));
                    Carta c = new Carta(cartaString, i, palo);
                    addCarta(c);
                }
            }
        }

        public void barajar() {
            List<Carta> barajada = new ArrayList<>();
            while (!cartas.isEmpty()) {
                int index = (int) (Math.random() * cartas.size());
                barajada.add(cartas.remove(index));
            }
            cartas = barajada;
        }

        public Carta robarCarta() {
            if (cartas.isEmpty()) {
                throw new IllegalStateException("No hay cartas en la baraja para robar");
            }
            return cartas.remove(cartas.size() - 1);
        }

        public Baraja cartasRestantes() {
            Baraja barajaRestante = new Baraja();
            for (Carta c : cartas) {
                barajaRestante.addCarta(c);
            }
            return barajaRestante;
        }
    }

