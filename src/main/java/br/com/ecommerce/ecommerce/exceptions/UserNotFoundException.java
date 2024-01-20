package br.com.ecommerce.ecommerce.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("User not found by id: " + id);
    }
}
