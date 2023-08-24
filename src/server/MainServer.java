package server;

import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws IOException {
        Server serv = new Server(); //Se crea el servidor
        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
    }
}
