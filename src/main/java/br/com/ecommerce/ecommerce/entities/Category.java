package br.com.ecommerce.ecommerce.entities;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Category implements Serializable {

    private String id;

    @NotNull(message = "name must not be null")
    private String name;

}
