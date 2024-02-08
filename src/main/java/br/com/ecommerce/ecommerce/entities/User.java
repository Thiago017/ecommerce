package br.com.ecommerce.ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "users")
public class User implements Serializable {

    @Id
    private String id;

    @NotNull(message = "name must not be null")
    private String name;

    @Indexed(unique = true)
    @NotNull(message = "email must not be null")
    private String email;

    @NotNull(message = "password name must not be null")
    private String password;

    @Indexed(unique = true)
    @NotNull(message = "document name must not be null")
    private String document;

    @DBRef(lazy = true)
    @Setter(AccessLevel.NONE)
    private List<Order> orders = new ArrayList<>();

    // public void encodePassword() {
    //     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    //     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    //     password = encoder.encode(password);
    // }

}
