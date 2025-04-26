package com.biblioteca.autor.controller;

import com.biblioteca.autor.model.Autor;
import com.biblioteca.autor.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Autor> crearAutor(@Valid @RequestBody Autor autor) {
        return autorService.crearAutor(autor);
    }

    @GetMapping
    public Flux<Autor> listarAutores() {
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Mono<Autor> obtenerAutor(@PathVariable String id) {
        return autorService.obtenerPorId(id);
    }
}