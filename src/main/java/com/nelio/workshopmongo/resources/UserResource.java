package com.nelio.workshopmongo.resources;

import com.nelio.workshopmongo.domain.Post;
import com.nelio.workshopmongo.domain.User;
import com.nelio.workshopmongo.dto.UserDTO;
import com.nelio.workshopmongo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity <UserDTO> findById (@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    /*
     * 1. ServletUriComponentsBuilder -> Fábrica que constrói URLs.
     * 2. .fromCurrentRequest()       -> Captura o endereço atual (ex: localhost:8080/users).
     * 3. .path("/{id}")              -> Cria um "espaço vazio" para o ID no final da URL.
     * 4. .buildAndExpand(obj.getId())-> Preenche o "espaço vazio" com o ID real do objeto salvo.
     * 5. .toUri()                    -> Converte o texto montado em um objeto de endereço (URI).
     * RESULTADO: Se salvou o User 5, a URI vira "http://localhost:8080/users/5".
     * 6. URI cria uma variavel pra guardar endereço web completo gerado
     * created retorna o codigo 201 (resposta http de quando cria um novo recurso)
     */
    @PostMapping
    public ResponseEntity <UserDTO> insert (@RequestBody UserDTO objDto){
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //criar um cabeçalho com a url do novo recurso criado
        return ResponseEntity.created(uri).body(new UserDTO(obj)); // Retorna um novo user Dto ja com Id para o front
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable  String id){
        service.delete(id);
        return  ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity <Void> update (@RequestBody UserDTO objDto, @PathVariable String id){
        User obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return  ResponseEntity.noContent().build();


    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity <List<Post>> findPosts (@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body((obj.getPosts()));
    }





}
