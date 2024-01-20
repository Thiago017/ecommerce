package br.com.ecommerce.ecommerce.dto;

import java.io.Serializable;

import br.com.ecommerce.ecommerce.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserDto implements Serializable {

    private String id;
    private String name;
    private String email;
    private String document;

    public UserDto (User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        document = user.getDocument();
    }

}
