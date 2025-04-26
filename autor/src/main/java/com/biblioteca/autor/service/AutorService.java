package com.biblioteca.autor.service;

import com.biblioteca.autor.model.Autor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AutorService {
    Mono<Autor> crearAutor(Autor autor);
    Flux<Autor> listarTodos();
    Mono<Autor> obtenerPorId(String id);
}