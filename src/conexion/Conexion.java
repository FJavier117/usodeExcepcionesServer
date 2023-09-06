package conexion;

import java.io.DataInputStream;
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
    protected DataInputStream entradaS; //Flujo de salida servidor
    protected DataOutputStream salidaS; //Flujo de datos de salida servidor
    protected DataInputStream entradaC; //Flujo de datos de entrada cliente
    protected DataOutputStream salidaC; //Flujo de datos de salida cliente


    public Conexion(String tipo) throws IOException //Constructor
    {
        if (tipo.equalsIgnoreCase("servidor")) {
            serverSocket = new ServerSocket(PUERTO);//Se crea el socket para el servidor
            socket = new Socket(); //Socket para el cliente
        } else {
            socket = new Socket(HOST, PUERTO); //Socket para el cliente
        }
    }
}
