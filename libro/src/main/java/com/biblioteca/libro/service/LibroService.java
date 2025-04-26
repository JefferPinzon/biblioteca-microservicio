package com.biblioteca.libro.service;

import com.biblioteca.libro.dto.LibroConAutorDTO;
import com.biblioteca.libro.model.Libro;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LibroService {
    Mono<Libro> crearLibro(Libro libro);
    Flux<Libro> listarTodos();
    Mono<Libro> obtenerPorId(String id);
    Mono<Libro> asignarAutor(String libroId, String autorId);
    Mono<LibroConAutorDTO> obtenerLibroConAutor(String libroId);
}