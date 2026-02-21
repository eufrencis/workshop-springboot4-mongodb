package com.nelio.workshopmongo.repository;

import com.nelio.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    /**
     * Query Method: O Spring Data gera automaticamente a consulta ao MongoDB.
     * findByTitle: Busca pelo campo 'title'.
     * Containing: Filtra resultados que contenham o texto (similar ao LIKE do SQL).
     * IgnoreCase: Ignora a diferença entre maiúsculas e minúsculas.
     */

    List<Post> findByTitleContainingIgnoreCase(String text);



    /* Entre as aspas simples coloque o que vc quer procurar
    dentro da expressao regular (regex) eu coloco o valor texte que foi recebido como parametro o ?0 é o primeiro parametro o ?1 o segundo e assim por diante
    dentro de options tem uma lista que vc abre no site do pdf do professor que mostra no caso o i ignora maisculas e minusculas
     */



    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);






}
