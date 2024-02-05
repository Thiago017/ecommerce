package br.com.ecommerce.ecommerce.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecommerce.ecommerce.entities.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
