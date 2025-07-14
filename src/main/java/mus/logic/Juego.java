package main.java.mus.logic;

import main.java.mus.model.Mano;

public class Juego {

    public int conteo(int numero){
        switch (numero) {
            case 11:
                return 10;
                
            case 12:
                return 10;
                
            case 2:
                return 1;

            case 3:
                return 10;
        
            default:
                return numero;
        }
    }

    public int sumajuego(Mano mano){
        int suma = 0;
        for (int i = 0; i < 4; i++){
            suma = conteo(mano.getCarta(i).getNumero()) + suma;
        }
        return suma;
    }

    public boolean punto(Mano mano) {
        if (sumajuego(mano) > 30) {
            return false;
        }

        else{
            return true;
        }  
    }

    public int comprobacion(Mano mano1, Mano mano2){
        int juego1 = sumajuego(mano1);
        int juego2 = sumajuego(mano2);

        if (juego1 > 30 && juego2 >30){
            //Los dos jugaron
            if( juego1 == 31 || juego1 == 32 ||
                juego2 == 31 || juego2 == 32){

                if(juego1 < juego2){
                    return 1;
                }

                if(juego1 > juego2){
                    return -1;
                }


            }   



                



            else{//NO hay jugadas especiales
                if(juego1 > juego2){
                    return 1;
                }

                if(juego1 < juego2){
                    return -1;
                }
            }

        }



        else if (juego1 <= 30 && juego2 <= 30) {
            //No jugaron
            if (juego1 > juego2) {
                return 1;//Gana la primera mano                
            }

            if (juego1 < juego2){
                return -1;
            } 
        }


        else if (juego1 > 30 ){
            return 1;
        }


        else if (juego2 > 30){
            return -1;
        }

        //Han tenido que empatar...
        return 0;
    }

}
