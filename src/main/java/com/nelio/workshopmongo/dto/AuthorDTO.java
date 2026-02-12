package com.nelio.workshopmongo.dto;

import com.nelio.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDTO (User obj){
        id = obj.getId();
        name = obj.getName();
    }

}
