package com.biblioteca.libro.controller;

import com.biblioteca.libro.dto.LibroConAutorDTO;
import com.biblioteca.libro.model.Libro;
import com.biblioteca.libro.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Libro> crearLibro(@Valid @RequestBody Libro libro) {
        return libroService.crearLibro(libro);
    }

    @GetMapping
    public Flux<Libro> listarLibros() {
        return libroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Mono<Libro> obtenerLibro(@PathVariable String id) {
        return libroService.obtenerPorId(id);
    }

    @GetMapping("/{id}/completo")
    public Mono<LibroConAutorDTO> obtenerLibroCompleto(@PathVariable String id) {
        return libroService.obtenerLibroConAutor(id);
    }

    @PutMapping("/{id}/autor")
    public Mono<Libro> asignarAutor(@PathVariable String id, @RequestBody String autorId) {
        return libroService.asignarAutor(id, autorId);
    }
}
