package br.com.ecommerce.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.ecommerce.entities.Product;
import br.com.ecommerce.ecommerce.exceptions.EntityNotFoundException;
import br.com.ecommerce.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product create(Product productData) {
        return repository.save(productData);
    }

    public Product findById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

}
