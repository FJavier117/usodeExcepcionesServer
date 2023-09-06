package server;

import java.io.IOException;
import java.util.Scanner;

public class MainServer {
    static int [] arr = new int[5];
    static int i = 0;
    public static void main(String[] args) throws IOException {
       Server serv = new Server(); //Se crea el servidor
        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor

    }


    public static void add(Scanner scanner){
        for (int j = 0; j < arr.length; j++) {
            System.out.println("Dame dato");
            arr[j] = scanner.nextInt();
        }
    }

    public static int [] getElemento(){
        return arr;
    }

    public static int suma(int [] data){
        int resultado = 0;
        for (int i= 0; i < data.length; i++){
                resultado  += data[i];
        }
        return  resultado;
    }




}
