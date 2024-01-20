package br.com.ecommerce.ecommerce.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecommerce.ecommerce.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

}
