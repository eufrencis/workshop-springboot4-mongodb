package com.nelio.workshopmongo.resources;

import com.nelio.workshopmongo.domain.Post;
import com.nelio.workshopmongo.service.PostService;
import com.nelio.workshopmongo.util.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value ="/posts")
@RequiredArgsConstructor
public class PostResource {

    private final PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findByPost(id);
        return ResponseEntity.ok().body(post);
    }

    /**
     * Endpoint para busca de posts por título.
     *
     * @RequestParam: Captura o parâmetro 'text' da URL (ex: /titlesearch?text=viagem).
     * defaultValue: Se o parâmetro não for enviado, assume uma string vazia.
     */
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        // 1. Limpa o texto vindo da URL (decodifica espaços e acentos)
        text = URL.decodeParam(text);

        // 2. Chama o serviço para buscar os posts no banco
        List<Post> list = postService.searchTitle(text);

        // 3. Retorna a lista encontrada com o código HTTP 200 (OK)
        return ResponseEntity.ok().body(list);
    }

}
