package main.java.mus.model;

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

        public void setCartaStringPlus(String cartaString){
            switch (cartaString) {
                case "1":
                case "2":
                    this.cartaString = "As";
                
                case "3":
                case "12":
                    this.cartaString = "Rey";
                    
            
                default:
                    this.cartaString = cartaString;
            }
        }


        

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((cartaString == null) ? 0 : cartaString.hashCode());
            result = prime * result + numero;
            result = prime * result + ((palo == null) ? 0 : palo.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Carta other = (Carta) obj;
            if (cartaString == null) {
                if (other.cartaString != null)
                    return false;
            } else if (!cartaString.equals(other.cartaString))
                return false;
            if (numero != other.numero)
                return false;
            if (palo == null) {
                if (other.palo != null)
                    return false;
            } else if (!palo.equals(other.palo))
                return false;
            return true;
        }


        /**
         * Borra el String, el Palo y transforma reyes y pitos
         */
        public void normalizarCarta(){
            cartaString = null;
            palo = null;
            if(numero == 3){
                numero = 12;
            }

            if (numero == 2) {
                numero = 1;    
            }
        }





}
