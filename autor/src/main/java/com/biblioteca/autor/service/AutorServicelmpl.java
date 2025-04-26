package com.biblioteca.autor.service;

import com.biblioteca.autor.model.Autor;
import com.biblioteca.autor.repository.AutorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AutorServicelmpl implements AutorService {

    private final AutorRepository autorRepository;

    public AutorServicelmpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Mono<Autor> crearAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Flux<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    @Override
    public Mono<Autor> obtenerPorId(String id) {
        return autorRepository.findById(id);
    }
}