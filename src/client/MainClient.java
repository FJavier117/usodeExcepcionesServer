package client;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException {
        Cliente cli = new Cliente(); //Se crea el cliente
        System.out.println("Iniciando cliente\n");
        cli.startClient(); //Se inicia el cliente
    }
}
