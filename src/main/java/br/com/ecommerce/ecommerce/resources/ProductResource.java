package br.com.ecommerce.ecommerce.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.ecommerce.entities.Product;
import br.com.ecommerce.ecommerce.services.ProductService;

@RestController 
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Product productData) {
        Product product = service.create(productData);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) {
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

}
