package br.com.ricardoamaral.servicex.exceptios;

public class ObjectNotFoundException  extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }

}