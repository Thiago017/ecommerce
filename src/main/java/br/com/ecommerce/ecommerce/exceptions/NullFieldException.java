package br.com.ecommerce.ecommerce.exceptions;

public class NullFieldException extends RuntimeException {
    public NullFieldException(String msg) {
        super(msg);
    }
}
