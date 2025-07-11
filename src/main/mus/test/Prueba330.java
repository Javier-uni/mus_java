package main.mus.test;

public class Prueba330 {
    public static void main(String[] args) {
        int[][] matriz = new int[4096][4];
        rellenar(matriz);
    }

    public static void rellenar(int[][] matriz){
        int contador = 0;
        for(int i = 0; i<8; i++){
            for(int j = i; j<8; j++){
                for(int x = j; x<8; x++){
                    for(int z = x; z<8;z++){
                        int[] nummano = {i,j,x,z};
                        //sort(nummano);
                        matriz[contador] = nummano;
                        contador++;
                        System.out.println("Combinación " + contador + ": " + nummano[0] + ", " + nummano[1] + ", " + nummano[2] + ", " + nummano[3]);
                    }
                }
            }
        }
        System.out.println("Matriz rellenada con " + contador + " combinaciones.");
    }
}
