package com.elviejomolino.gestorarticulos.exception;

public class ArticuloNotFoundException extends Exception { // INICIO CLASE ARTICULONOTFOUNDEXCEPTION;

    // ESTADO: ATRIBUTOS;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;
    public ArticuloNotFoundException() {

    }

    // CONSTRUCTOR PARAMETRIZADO;
    public ArticuloNotFoundException(String mensaje) {
        super(mensaje);
    }

} // FINAL CLASE ARTICULONOTFOUNDEXCEPTION;
