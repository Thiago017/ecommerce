package br.com.ecommerce.ecommerce.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import br.com.ecommerce.ecommerce.entities.Category;
import br.com.ecommerce.ecommerce.entities.Product;
import br.com.ecommerce.ecommerce.repositories.CategoryRepository;
import br.com.ecommerce.ecommerce.repositories.ProductRepository;

@org.springframework.context.annotation.Configuration
public class Configuration implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void run(String... args) throws Exception {

        productRepository.deleteAll();
        categoryRepository.deleteAll();
        
        Category categoryComputer = new Category();
        categoryComputer.setName("Computadores");
        
        Product productMacBook = new Product();
        productMacBook.setName("Macbook pro m3 18GB 2023");
        productMacBook.setCategory(categoryComputer);
        productMacBook.setPrice(16.843);
        productMacBook.setQuantityInStock(10);

        Category categoryCleaningProducts = new Category();
        categoryCleaningProducts.setName("Produtos de limpeza");

        Product productBleach = new Product();
        productBleach.setName("Alvejante");
        productBleach.setCategory(categoryCleaningProducts);
        productBleach.setPrice(10.00);
        productBleach.setQuantityInStock(3);


        categoryRepository.saveAll(Arrays.asList(categoryComputer, categoryCleaningProducts));
        productRepository.saveAll(Arrays.asList(productMacBook, productBleach));

    }
}