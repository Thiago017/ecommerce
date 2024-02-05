package br.com.ecommerce.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.ecommerce.ecommerce.dto.UserDto;
import br.com.ecommerce.ecommerce.entities.User;
import br.com.ecommerce.ecommerce.exceptions.EntityNotFoundException;
import br.com.ecommerce.ecommerce.repositories.UserRepository;

@Service
@Validated
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDto create(User user) {
        User createdUser = repository.save(user);
        return new UserDto(createdUser);
    }

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
    
    public UserDto findByIdReturningDto(String id) {
        User user = findById(id);
        return new UserDto(user);
    }

    public UserDto update(String id, User user) {
        user.setId(id);
        repository.save(user);
        return new UserDto(user);
    }

    public void delete(String id) {
        User user = findById(id);
        repository.delete(user);
    }

}
