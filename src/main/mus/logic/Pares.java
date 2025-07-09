package main.mus.logic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import main.mus.model.Mano;


public class Pares {



    public int comparacion(Mano mano1, Mano mano2) {
        if (mano1 == null || mano2 == null) {
            throw new IllegalArgumentException("Las manos no pueden ser nulas");
        }
        if (mano1.getCartas().size() != 4 || mano2.getCartas().size() != 4) {
            throw new IllegalArgumentException("Cada mano debe tener exactamente 4 cartas");
        }


        //Creamos dos ArrayList para guardar los numeros de las cartas de cada mano
        ArrayList<Integer> mano1Numeros = new ArrayList<>();
        ArrayList<Integer> mano2Numeros = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            mano1Numeros.add(mano1.getCartas().get(i).getNumero());
            mano2Numeros.add(mano2.getCartas().get(i).getNumero());
        }


        //Transforma los reyes en 12 y los pitos en 1
        for (int i = 0; i < 4; i++) {
            if (mano1Numeros.get(i) == 3) {
                mano1Numeros.set(i, 12);
            }

            if (mano1Numeros.get(i) == 2) {
                mano1Numeros.set(i, 1);
            }

            if (mano2Numeros.get(i) == 2) {
                mano2Numeros.set(i, 1);
            }
            if (mano2Numeros.get(i) == 3) {
                mano2Numeros.set(i, 12);
            }
        }
        boolean par1 = true;
        boolean par2 = true;



        //Quitamos las cartas que no forman parejas
        for (int i = 0; i<3; i++) {
            for (int j = i; j< 4-i; j++) {
                if (mano1Numeros.get(i) == mano1Numeros.get(j) && i != j) {
                    par1 = false;
                }
                if (mano2Numeros.get(i) == mano2Numeros.get(j) && i != j) {
                    par2 = false;
                }
            }
            if (par1) {
                mano1Numeros.remove(i);
                par1 = true;
            }

            if (par2) {
                mano2Numeros.remove(i);
                par2 = true;
            }
        }


        //Comparamos las parejas
        if (mano1Numeros.size() == 0 && mano2Numeros.size() == 0) {
            return 0; // Empate, no hay parejas
        } else if (mano1Numeros.size() == 0) {
            return -1; // mano2 gana, mano1 no tiene pareja
        } else if (mano2Numeros.size() == 0) {
            return 1; // mano1 gana, mano2 no tiene pareja
        } 
        
        
        
        
        else {
            if (mano1Numeros.size() > mano2Numeros.size()) {
                return 1; // mano1 gana, tiene más parejas
            } else if (mano1Numeros.size() < mano2Numeros.size()) {
                return -1; // mano2 gana, tiene más parejas
            } 
            
            else {
                //Si los dos llevan parejas, se comparan los numeros de las parejas
                if (mano1Numeros.size() == 2){
                    if (mano1Numeros.get(0) > mano2Numeros.get(0)) {
                        return 1; // mano1 gana, pareja más alta
                    } else if (mano1Numeros.get(0) < mano2Numeros.get(0)) {
                        return -1; // mano2 gana, pareja más alta
                    } 
                    
                }


                else if (mano1Numeros.size() == 4) {
                    //Ordenamos las parejas de cada mano
                    mano1Numeros.sort(Integer::compareTo);
                    mano2Numeros.sort(Integer::compareTo);


                    //Comparamos las parejas de cada mano
                    if (mano1Numeros.get(0) > mano2Numeros.get(0)) {
                        return 1; // mano1 gana, pareja más alta
                    } else if (mano1Numeros.get(0) < mano2Numeros.get(0)) {
                        return -1; // mano2 gana, pareja más alta
                    } else {
                        //Si las parejas son iguales, se compara la segunda pareja
                        if (mano1Numeros.get(3) > mano2Numeros.get(3)) {
                            return 1; // mano1 gana, segunda pareja más alta
                        } else if (mano1Numeros.get(3) < mano2Numeros.get(3)) {
                            return -1; // mano2 gana, segunda pareja más alta
                        }
                    }
                }

            }
        }


        return 0;
    }

}
