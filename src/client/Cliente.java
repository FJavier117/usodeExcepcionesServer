package client;

import conexion.Conexion;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Cliente extends Conexion {

    String mensaje = null;

    public Cliente() throws IOException {
        super("cliente");
    } //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try {
            //Flujo de datos hacia el servidor
            salidaC = new DataOutputStream (socket.getOutputStream());
            //Se enviarán mensajes
            addMensaje();
            salidaC.writeUTF("Este es el mensaje número " + mensaje);
            entradaC = new DataInputStream(socket.getInputStream());
            System.out.println(entradaC.readUTF());
            socket.close();//Fin de la conexión

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addMensaje(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa mensaje a enviar: ");
        mensaje = scanner.next();
    }
}
