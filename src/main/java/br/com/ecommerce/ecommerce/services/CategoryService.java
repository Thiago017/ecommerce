package br.com.ecommerce.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.ecommerce.entities.Category;
import br.com.ecommerce.ecommerce.exceptions.EntityNotFoundException;
import br.com.ecommerce.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category create(Category data) {
        return repository.save(data);
    }

    public Category findById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public Category update(String id, Category categoryData) {
        findById(id);
        categoryData.setId(id);
        repository.save(categoryData);
        return categoryData;
    }

    public void delete(String id) {
        Category category = findById(id);
        repository.delete(category);
    }

}
