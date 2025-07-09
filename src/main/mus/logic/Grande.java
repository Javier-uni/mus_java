package main.mus.logic;

import main.mus.model.Baraja;
import main.mus.model.Mano;

public class Grande {
    private Baraja baraja;

    public Grande() {
        baraja = new Baraja();
        baraja.iniciarBaraja();
        baraja.barajar();
    }



    public int comparacion(Mano mano1, Mano mano2) {
        if (mano1 == null || mano2 == null) {
            throw new IllegalArgumentException("Las manos no pueden ser nulas");
        }
        if (mano1.getCartas().size() != 4 || mano2.getCartas().size() != 4) {
            throw new IllegalArgumentException("Cada mano debe tener exactamente 4 cartas");
        }

        for (int i = 0; i < 4; i++) {
            //Si no hay reyes pues la siguiente
            if ((mano1.getCartaAlta().getNumero() != 3 || mano1.getCartaAlta().getNumero() != 12)
             && (mano2.getCartaAlta().getNumero() != 3 || mano2.getCartaAlta().getNumero() != 12)) {
                if (mano1.getCartaAlta().getNumero() > mano2.getCartaAlta().getNumero()) {
                    return 1; // mano1 gana
                }
                else if (mano1.getCartaAlta().getNumero() < mano2.getCartaAlta().getNumero()) {
                    return -1; // mano2 gana
                }
            }

            //Si hay reyes vemos en que mano o manos estan

            //Si SOLO estan en la mano1 gana.
            else if ((mano1.getCartaAlta().getNumero() == 3 || mano1.getCartaAlta().getNumero() == 12)
            && (mano2.getCartaAlta().getNumero() != 3 || mano2.getCartaAlta().getNumero() != 12)) {
                return 1; // mano1 gana


            //Si SOLO estan en la mano2 gana. 
            } else if ((mano1.getCartaAlta().getNumero() != 3 || mano1.getCartaAlta().getNumero() != 12)
            && (mano2.getCartaAlta().getNumero() == 3 || mano2.getCartaAlta().getNumero() == 12)) {
                return -1; // mano2 gana
            }
            
            //Si estan igualdos se pasa a la siguiente carta, removiendo la mas alta
            mano1.removeCarta(mano1.getCartaAlta());
            mano2.removeCarta(mano2.getCartaAlta());

        }
        return 0;
    }

}
