package br.com.ecommerce.ecommerce.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

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
    private String name;
    private Category category;
    private Double price;
    private Integer quantityInStock;

}
