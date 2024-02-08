package br.com.ecommerce.ecommerce.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "orders")
public class Order {

    private String id;
    private User user;
    private List<Product> products = new ArrayList<>();
    private Instant date;

}
