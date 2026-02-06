package com.nelio.workshopmongo.resources;

import com.nelio.workshopmongo.domain.User;
import com.nelio.workshopmongo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;


    @GetMapping
    public ResponseEntity <List<User>> findAll(){
        List <User> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
}
