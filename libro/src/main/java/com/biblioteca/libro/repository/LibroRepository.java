package com.biblioteca.libro.repository;

import com.biblioteca.libro.model.Libro;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface LibroRepository extends ReactiveMongoRepository<Libro, String> {
    Flux<Libro> findByAutorId(String autorId);
    Flux<Libro> findByGenero(String genero);
}