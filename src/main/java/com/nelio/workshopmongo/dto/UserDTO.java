package com.nelio.workshopmongo.dto;

import com.nelio.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String name;
    private String email;


    public UserDTO (User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();

    }



}
