package br.com.ecommerce.ecommerce.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String id) {
        super("Object not found by id: " + id);
    }
}
