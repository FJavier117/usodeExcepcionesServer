package server;

import conexion.Conexion;

import java.io.*;

public class Server extends Conexion {
    public Server() throws IOException {
        super("servidor");
    } //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try {
            System.out.println("Esperando..."); //Esperando conexión

            socket = serverSocket.accept(); //Accept comienza el socket y
            // espera una conexión desde un cliente

            System.out.println("Cliente en línea");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(socket.getOutputStream());

            //Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada");

            //Se obtiene el flujo entrante desde el cliente

            InputStreamReader entradaCiente = new InputStreamReader(socket.getInputStream());
            BufferedReader entrada = new BufferedReader(entradaCiente);

            while ((mensajeServidor = entrada.readLine()) != null)
                //Mientras haya mensajes desde el cliente
            {
                //Se muestra por pantalla el mensaje recibido
                System.out.println(mensajeServidor);
            }

            System.out.println("Fin de la conexión");
            serverSocket.close();//Se finaliza la conexión con el cliente

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
