package com.biblioteca.autor.repository;

import com.biblioteca.autor.model.Autor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AutorRepository extends ReactiveMongoRepository<Autor, String> {
    Mono<Autor> findByNombre(String nombre);
}