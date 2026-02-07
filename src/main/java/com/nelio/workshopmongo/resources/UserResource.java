package com.nelio.workshopmongo.resources;

import com.nelio.workshopmongo.domain.User;
import com.nelio.workshopmongo.dto.UserDTO;
import com.nelio.workshopmongo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;


    @GetMapping
    public ResponseEntity <List<UserDTO>> findAll(){
        List <User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(UserDTO::new).collect(Collectors.toList()); // os dois pontos sao usados pra referenciar construtores ou métodos de uma classe
        return ResponseEntity.ok().body(listDTO);

    }
}
