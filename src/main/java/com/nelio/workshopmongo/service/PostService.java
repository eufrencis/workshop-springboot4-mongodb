package com.nelio.workshopmongo.service;

import com.nelio.workshopmongo.domain.Post;
import com.nelio.workshopmongo.repository.PostRepository;
import com.nelio.workshopmongo.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public Post findByPost(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    /**
     * Método de serviço que serve como ponte entre o controlador e o repositório.
     * Recebe o texto de busca e solicita ao repositório a busca no banco de dados.
     */

    public List<Post> searchTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);

    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        // Adiciona 1 dia à data máxima para garantir que a busca pegue
        // tudo até o final do dia selecionado (23:59:59).
        if (maxDate != null) {
            maxDate = maxDate.plusDays(1);
        }
        return postRepository.fullSearch(text, minDate, maxDate);
    }

}

