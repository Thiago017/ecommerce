package br.com.ecommerce.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.ecommerce.ecommerce.dto.UserDto;
import br.com.ecommerce.ecommerce.entities.User;
import br.com.ecommerce.ecommerce.exceptions.UserNotFoundException;
import br.com.ecommerce.ecommerce.repositories.UserRepository;
import br.com.ecommerce.ecommerce.util.EntityUpdater;

@Service
@Validated
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDto create(User user) {
        User createdUser = repository.save(user);
        return convertToDto(createdUser);
    }

    public UserDto update(String id, User data) {
        User user = findById(id);
        if (data != null) {
            EntityUpdater.updateFields(user, data);
        }
        repository.save(user);
        return convertToDto(user);
    }

    public void delete(String id) {
        User user = findById(id);
        repository.delete(user);
    }

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public UserDto findByIdReturningDto(String id) {
        User user = findById(id);
        return convertToDto(user);
    }
    
    private UserDto convertToDto(User user) {
        return new UserDto(user);
    }
}
