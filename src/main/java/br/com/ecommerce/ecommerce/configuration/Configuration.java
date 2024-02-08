package br.com.ecommerce.ecommerce.configuration;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import br.com.ecommerce.ecommerce.entities.Category;
import br.com.ecommerce.ecommerce.entities.Order;
import br.com.ecommerce.ecommerce.entities.Product;
import br.com.ecommerce.ecommerce.entities.User;
import br.com.ecommerce.ecommerce.repositories.CategoryRepository;
import br.com.ecommerce.ecommerce.repositories.OrderRepository;
import br.com.ecommerce.ecommerce.repositories.ProductRepository;
import br.com.ecommerce.ecommerce.repositories.UserRepository;

@org.springframework.context.annotation.Configuration
public class Configuration implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

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
        userRepository.deleteAll();
        orderRepository.deleteAll();

        User user = new User();
        user.setDocument("175.934.447-83");
        user.setEmail("thiago7ps@outlook.com");
        user.setName("Thiago Pereira da Silva");
        user.setPassword("26062002");
        userRepository.save(user);

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

        Order order = new Order();
        order.getProducts().addAll(Arrays.asList(productMacBook, productBleach));
        order.setDate(Instant.now());
        order.setUser(user);
        orderRepository.save(order);

        user.getOrders().add(order);
        userRepository.save(user);        
    }
}