package com.nelio.workshopmongo.resources;

import com.nelio.workshopmongo.domain.Post;
import com.nelio.workshopmongo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value ="/posts")
@RequiredArgsConstructor
public class PostResource {

    private final PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity <Post> findById(@PathVariable String id){
        Post post = postService.findByPost(id);
        return ResponseEntity.ok().body(post);
    }
}
