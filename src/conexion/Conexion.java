package conexion;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
    private static final int PUERTO = 8081; //Puerto para la conexión
    private static final String HOST = "localhost"; //Host para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket serverSocket; //Socket del servidor
    protected Socket socket; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida

    public Conexion(String tipo) throws IOException //Constructor
    {
        if (tipo.equalsIgnoreCase("servidor")) {
            serverSocket = new ServerSocket(PUERTO);//Se crea el socket para el
            // servidor en puerto
            socket = new Socket(); //Socket para el cliente
        } else {
            socket = new Socket(HOST, PUERTO); //Socket para el cliente
            // en localhost en puerto
        }
    }
}
