package main.mus.model;

public class Carta {
    private String cartaString;
        private int numero;
        private String palo;

        public Carta(String cartaString, int numero, String palo) {
            this.cartaString = cartaString;
            this.numero = numero;
            this.palo = palo;
        }

        public String getCartaString() {
            return cartaString;
        }

        public int getNumero() {
            return numero;
        }
        public String getPalo() {
            return palo;
        }

        public void setCartaString(String cartaString) {
            this.cartaString = cartaString;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public void setPalo(String palo) {
            this.palo = palo;
        }

}
