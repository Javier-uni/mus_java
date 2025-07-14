package main.java.mus.logic;

import main.java.mus.model.Mano;

public class Chica {






    public int comparacion(Mano mano1, Mano mano2) {
        if (mano1 == null || mano2 == null) {
            throw new IllegalArgumentException("Las manos no pueden ser nulas");
        }
        if (mano1.getCartas().size() != 4 || mano2.getCartas().size() != 4) {
            throw new IllegalArgumentException("Cada mano debe tener exactamente 4 cartas");
        }

        for (int i = 0; i < 4; i++) {
            //Si no hay pitos pues la siguiente
            if ((mano1.getCartaBaja().getNumero() != 2 || mano1.getCartaBaja().getNumero() != 1)
             && (mano2.getCartaBaja().getNumero() != 2 || mano2.getCartaBaja().getNumero() != 1)) {
                if (mano1.getCartaBaja().getNumero() < mano2.getCartaBaja().getNumero()) {
                    return 1; // mano1 gana
                }
                else if (mano1.getCartaBaja().getNumero() > mano2.getCartaBaja().getNumero()) {
                    return -1; // mano2 gana
                }
            }

            
            //Si hay pitos vemos en que mano o manos estan

            //Si SOLO estan en la mano1 gana.
            else if ((mano1.getCartaBaja().getNumero() == 2 || mano1.getCartaBaja().getNumero() == 1)
            && (mano2.getCartaBaja().getNumero() != 2 || mano2.getCartaBaja().getNumero() != 1)) {
                return 1; // mano1 gana


            //Si SOLO estan en la mano2 gana. 
            } else if ((mano1.getCartaBaja().getNumero() != 2 || mano1.getCartaBaja().getNumero() != 1)
            && (mano2.getCartaBaja().getNumero() == 2 || mano2.getCartaBaja().getNumero() == 1)) {
                return -1; // mano2 gana
            }
            
            //Si estan igualdos se pasa a la siguiente carta, removiendo la mas Baja
            mano1.removeCarta(mano1.getCartaBaja());
            mano2.removeCarta(mano2.getCartaBaja());

        }
        return 0;
    }
}
