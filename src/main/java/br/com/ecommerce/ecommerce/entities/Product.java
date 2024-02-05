package br.com.ecommerce.ecommerce.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "products")
public class Product implements Serializable {

    private String id;
    
    @NotNull(message = "name must not be null")
    private String name;
    
    @DBRef
    @NotNull(message = "category must not be null")
    private Category category;
    
    @NotNull(message = "price must not be null")
    private Double price;
    
    @NotNull(message = "quantityInStock must not be null")
    private Integer quantityInStock;

}
