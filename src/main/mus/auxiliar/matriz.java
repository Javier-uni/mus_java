package main.mus.auxiliar;


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
}
