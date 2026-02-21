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
    public ResponseEntity <Post> findById(@PathVariable String id){
        Post post = postService.findByPost(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity <List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "")String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitlePost(text);
        return ResponseEntity.ok().body(list);
    }

}
