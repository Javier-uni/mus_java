package main.java.mus.model;

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

        public Carta getCarta(int index) {
            if (index < 0 || index >= cartas.size()) {
                throw new IndexOutOfBoundsException("Index out of bounds for cartas list");
            }
            return cartas.get(index);
        }

        public Carta removeCarta(Carta c) {
            if (c == null) {
                throw new IllegalArgumentException("Carta cannot be null");
            }
            if (!cartas.contains(c)) {
                throw new IllegalArgumentException("Carta not found in mano");
            }
            cartas.remove(c);
            return c;
        }
    
        public Carta getCartaAlta() {
            if (cartas.isEmpty()) {
                throw new IllegalStateException("No hay cartas en la mano");
            }
            Carta cartaAlta = cartas.get(0);
            for (Carta c : cartas) {
                if (c.getNumero() != 3 && cartaAlta.getNumero() != 3) {
                    if (c.getNumero() > cartaAlta.getNumero()) {
                        cartaAlta = c;
                    }
                } else if (c.getNumero() == 3 && cartaAlta.getNumero() != 3) {
                    cartaAlta = c;

                }
            }
            return cartaAlta;
        }


        public Carta getCartaBaja() {
            if (cartas.isEmpty()) {
                throw new IllegalStateException("No hay cartas en la mano");
            }
            Carta cartaBaja = cartas.get(0);
            for (Carta c : cartas) {
                if (c.getNumero() < cartaBaja.getNumero()) {
                    cartaBaja = c;
                }
            }
            return cartaBaja;
        }

        public Mano ordenar() {
            Mano manoOrdenada = new Mano();
            List<Carta> cartasOrdenadas = new ArrayList<>(cartas);
            cartasOrdenadas.sort((c2, c1) -> Integer.compare(c1.getNumero(), c2.getNumero()));
            for (Carta c : cartasOrdenadas) {
                manoOrdenada.addCarta(c);
            }
            return manoOrdenada;
        }



        /**
         * Función que devuelve una mano nueva normalizada (Transformación reyes y pitos).
         * Si se busca el metodo que normaliza una mano dada (void) se llama normalizar()
         * 
         * @return manoNormalizada  
         */
        public Mano normalizacion() {

            Mano manoNormalizada = new Mano();
            for (Carta c : cartas) {
                if (c.getNumero() == 3) {
                    c.setNumero(12); // Convertir 3 (reyes) a 12
                } else if (c.getNumero() == 2) {
                    c.setNumero(1); // Convertir pitos a 1
                }
                manoNormalizada.addCarta(c);
            }
            return manoNormalizada;
        }


        /**
         * Se normaliza una mano haciendo transformación de reyes y ases
         */
        public void normalizada(){
            for(Carta c: cartas){
                if (c.getNumero() == 3) {
                    c.setNumero(12); // Convertir 3 (reyes) a 12
                } else if (c.getNumero() == 2) {
                    c.setNumero(1); // Convertir pitos a 1
                }
            }
        }


        /**
         * Calcula el tamaño dada una mano, deberia de ser 4
         * @return mano.size();
         */
        public int getSize(){
            return cartas.size();
        }

        public Mano copia() {
            Mano copia = new Mano();
            for (Carta c : cartas) {
                copia.addCarta(new Carta(c.getCartaString(),c.getNumero(), c.getPalo()));
            }
            return copia;
        }

        
    }


