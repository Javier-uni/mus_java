package main.mus.auxiliar;


// import main.mus.combinatoria.combinatoria;
import main.mus.model.Baraja;
// import main.mus.model.Mano;
import main.mus.model.Carta;;



public class matriz {
    private int[][] matriz = new int[330][4]; // 330 combinaciones posibles de 4 cartas

    public int[][] getMatriz() {
        return matriz;
    }
    
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }


    public matriz(int[][] matriz) {
        this.matriz = matriz;
    }

    
    

    public void rellenar(int[][] matriz){
        int contador = 0;
        for(int i = 0; i<8; i++){
            for(int j = i; j<8; j++){
                for(int x = j; x<8; x++){
                    for(int z = x; z<8;z++){
                        int[] nummano = {transforAuxiliar(i),
                                        transforAuxiliar(j),
                                        transforAuxiliar(x),
                                        transforAuxiliar(z)};
                        //sort(nummano);
                        matriz[contador] = nummano;
                        contador++;
                    }
                }
            }
        }
    }


    public int transforAuxiliar(int numero) {
        switch (numero) {
            case 0:
                return 12;
            case 2:
                return 11;
            case 3:
                return 10;
            default:
                return numero;
        }
    }

    public static double combinatoria(int m, int n) {
        double resultado = factorial(m)/(factorial(n)*factorial(m-n));
        return resultado;
    }


    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public int numeroRestante(Baraja baraja, Carta c ){
        int x = 0;
        
        
        for (int i =0; i < baraja.numCartas(); i++ ){
            if(baraja.getCarta(i).getNumero() == c.getNumero()){
                x++;
            }
        }
        return x;
    }
}
