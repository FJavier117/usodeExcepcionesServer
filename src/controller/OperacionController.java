package controller;

import server.Server;
import service.OperacionImp;

public class OperacionController {
    private final OperacionImp operacionImp;
    private final Server.Service service;

    {
        this.operacionImp = new OperacionImp(this);
    }

    public OperacionController(Server.Service service) {
        this.service = service;
    }
    public void suma(float a, float b) {
        operacionImp.suma(a, b);
    }
    public void resta(float a, float b) {
        operacionImp.resta(a, b);
    }
    public void producto(float a, float b) {
        operacionImp.producto(a, b);
    }
    public void division(float a, float b) {
        operacionImp.division(a, b);
    }
    public void mostrarResultado(String resultado) {
        service.mostrarResultado(resultado);
    }

}
