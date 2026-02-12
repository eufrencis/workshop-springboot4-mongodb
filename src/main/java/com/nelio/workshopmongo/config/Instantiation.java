package com.nelio.workshopmongo.config;

import com.nelio.workshopmongo.domain.Post;
import com.nelio.workshopmongo.domain.User;
import com.nelio.workshopmongo.dto.AuthorDTO;
import com.nelio.workshopmongo.repository.PostRepository;
import com.nelio.workshopmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    @Override
    public void run(String @NonNull ... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = User.builder()
                .name("Maria Brown")
                .email("Maria@gmail.com")
                .build();
        User alex = User.builder()
                .name("Alex Grenn")
                .email("alex@gmail.com")
                .build();
        User bob = User.builder()
                .name("Bob Grey")
                .email("bob@gmail.com")
                .build();

        userRepository.saveAll(Arrays.asList(maria, alex, bob));



        Post post1 = Post.builder().date(LocalDate.of(2018, 3, 21))
                .title("Partiu viagem").body("Vou viajar para São Paulo. Abraços!").author(new AuthorDTO(maria)).build();

        Post post2 = Post.builder().date(LocalDate.of(2018, 3,23))
                .title("Bom dia").body("Acordei feliz hj").author(new AuthorDTO(maria)).build();

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);







    }
}
