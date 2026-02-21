package com.nelio.workshopmongo.service;

import com.nelio.workshopmongo.domain.Post;
import com.nelio.workshopmongo.repository.PostRepository;
import com.nelio.workshopmongo.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public Post findByPost (String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitlePost (String text){
        return postRepository.findByTitleContainingIgnoreCase(text);

    }
}
