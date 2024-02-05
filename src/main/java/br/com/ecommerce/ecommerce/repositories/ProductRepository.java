package br.com.ecommerce.ecommerce.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecommerce.ecommerce.entities.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
