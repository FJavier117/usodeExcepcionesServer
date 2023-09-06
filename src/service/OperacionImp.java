package service;

import controller.OperacionController;

public class OperacionImp implements IOperacion {
    private  final OperacionController operacionController;
    private String resultado;

    public OperacionImp(OperacionController operacionController){
        this.operacionController = operacionController;
    }

    @Override
    public void suma(float a, float b) {
        resultado = Float.toString(a + b);
        operacionController.mostrarResultado(resultado);
    }

    @Override
    public void resta(float a, float b) {
        resultado = Float.toString(a - b);
        operacionController.mostrarResultado(resultado);
    }

    @Override
    public void producto(float a, float b) {
        resultado = Float.toString(a * b);
        operacionController.mostrarResultado(resultado);
    }

    @Override
    public void division(float a, float b) {
        if (a == 0 && b == 0){
            resultado = "No es posible dividir elemento 0/0";
            operacionController.mostrarResultado(resultado);
        } else if (b== 0) {
            resultado = "No es posible dividir cuando el denominador es 0";
            operacionController.mostrarResultado(resultado);
        }else {
            float r = a / b;
            resultado = "Resultado de la operación: " + r;
            operacionController.mostrarResultado(resultado);
        }
    }
}
