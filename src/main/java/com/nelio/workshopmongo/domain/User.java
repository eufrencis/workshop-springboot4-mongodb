package com.nelio.workshopmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Document(collection = "user") //Mostra que é uma coleção do mongoDb
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    private String id;

    private String name;
    private String email;

    /* * @Builder.Default:
     * Garante que o Lombok Builder respeite a inicialização 'new ArrayList<>()'.
     * Sem essa anotação, o Builder ignoraria o valor padrão e deixaria a lista como 'null',
     * o que causaria um NullPointerException ao tentar usar o método .getPosts().add().
     */
    @Builder.Default
    @DBRef(lazy = true) // simula uma chave estrangeira e o lazy e para nao carregar os posts diretamente ao buscar users
    private List<Post> posts = new ArrayList<>();


}
