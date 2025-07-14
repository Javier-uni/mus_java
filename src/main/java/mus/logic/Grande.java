package main.java.mus.logic;

import main.java.mus.model.Baraja;
import main.java.mus.model.Mano;

public class Grande {
    private Baraja baraja;

    public Grande() {
        baraja = new Baraja();
        baraja.iniciarBaraja();
        baraja.barajar();
    }



    public int comparacion(Mano manoprimera, Mano manosegunda) {
        //SE PUEDE REHACER CON NORMALIZAR MANO
        if (manoprimera == null || manosegunda == null) {
            throw new IllegalArgumentException("Las manos no pueden ser nulas");
        }

        Mano mano1 = manoprimera.copia();
        Mano mano2 = manosegunda.copia();


        //Revisar porque puede que lo cambie en un futuro
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
                else {//No hay reyes y tienen la misma carta
                    if(mano1.getCartas().size() >1){
                    mano1.removeCarta(mano1.getCartaAlta());
                    mano2.removeCarta(mano2.getCartaAlta());
                    }
                    else {
                        return 0;
                    }
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


    public int comparacionGrande(Mano manoprimera, Mano manosegunda){
        if (manoprimera == null || manosegunda == null) {
            throw new IllegalArgumentException("Las manos no pueden ser nulas");
        }

        Mano mano1 = manoprimera.copia();
        Mano mano2 = manosegunda.copia();


       
        if (mano1.getCartas().size() != 4 || mano2.getCartas().size() != 4) {
            throw new IllegalArgumentException("Cada mano debe tener exactamente 4 cartas");
        }

        for(int i = 0; i<4;i++){

        if (mano1.getCartaAlta().getNumero() > mano2.getCartaAlta().getNumero()){
            return 1;
        }
        
        else if (mano1.getCartaAlta().getNumero() < mano2.getCartaAlta().getNumero()){
            return -1;
        }
        

        else {
            if(mano1.getCartas().size() >1){
                mano1.removeCarta(mano1.getCartaAlta());
                mano2.removeCarta(mano2.getCartaAlta());
                }
             else {
             return 0;
                }
            }

        }
        return 0;
    }

}
