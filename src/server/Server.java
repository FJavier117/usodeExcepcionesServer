package server;

import conexion.Conexion;
import controller.OperacionController;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.Scanner;

public class Server extends Conexion {
    public Server() throws IOException {
        super("servidor");
    } //Se usa el constructor para establecer al conexión con el servidor

    public void startServer()//Método para iniciar el servidor
    {
        try {
            System.out.println("Esperando..."); //Esperando conexión

            socket = serverSocket.accept(); //Accept comienza el socket y espera una conexión desde un cliente
            System.out.println("Cliente en línea"); //Imprime mendaje si el cliente ya se conectó
            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaS = new DataOutputStream(socket.getOutputStream());
            //Se le envía un mensaje al cliente usando su flujo de salida
          //  salidaS.writeUTF("Petición recibida y aceptada");

            //Se obtiene el flujo entrante desde el cliente
            entradaS = new DataInputStream(socket.getInputStream());
            //System.out.println(entradaS.readUTF());
            salidaS.writeUTF(opData(entradaS));

            System.out.println("Fin de la conexión");
            serverSocket.close();//Se finaliza la conexión con el cliente

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String opData(DataInputStream dataInputStream){
        Service service = new Service();
        try{
            int op = dataInputStream.readInt();
            float a = dataInputStream.readFloat();
            float b = dataInputStream.readFloat();
            switch (op) {
                case 1 -> {
                    service.suma(a, b);
                    return service.getResultado();
                }
                case 2 -> {
                    service.resta(a, b);
                    return  service.getResultado();
                }
                case 3 -> {
                    service.producto(a, b);
                    return service.getResultado();
                }
                case 4 -> {service.division(a, b);
                    return service.getResultado();}
                default -> {
                    return "Error no es posible procesar tu solicitud";
                }
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());;
        }
        return "";
    }

    public static class Service {
        private OperacionController operacionController;
        private  String resultado;
        public Service(OperacionController operacionController) {
            this.operacionController = operacionController;
        }

        public Service() {

        }

        public void suma(float a, float b) {operacionController.suma(a, b);}
        public void resta(float a, float b) {
            operacionController.resta(a, b);
        }

        public void producto(float a, float b) {
            operacionController.producto(a, b);
        }

        public void division(float a, float b) {
            operacionController.division(a, b);
        }
        public void mostrarResultado(String resultado) {
            this.resultado = resultado;
        }
        public String getResultado() {
            return resultado;
        }
    }

}



