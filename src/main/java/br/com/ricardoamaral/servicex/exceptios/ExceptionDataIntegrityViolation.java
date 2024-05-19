package br.com.ricardoamaral.servicex.exceptios;

public class ExceptionDataIntegrityViolation extends RuntimeException{

    public ExceptionDataIntegrityViolation(String message) {
        super(message);
    }

}
