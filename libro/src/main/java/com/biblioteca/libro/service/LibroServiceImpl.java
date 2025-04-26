package com.biblioteca.libro.service;

import com.biblioteca.libro.client.AutorClient;
import com.biblioteca.libro.dto.AutorDTO;
import com.biblioteca.libro.dto.LibroConAutorDTO;
import com.biblioteca.libro.model.Libro;
import com.biblioteca.libro.repository.LibroRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final AutorClient autorClient;

    public LibroServiceImpl(LibroRepository libroRepository, AutorClient autorClient) {
        this.libroRepository = libroRepository;
        this.autorClient = autorClient;
    }

    @Override
    public Mono<Libro> crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Flux<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    @Override
    public Mono<Libro> obtenerPorId(String id) {
        return libroRepository.findById(id);
    }

    @Override
    public Mono<Libro> asignarAutor(String libroId, String autorId) {
        return libroRepository.findById(libroId)
                .flatMap(libro -> {
                    libro.setAutorId(autorId);
                    return libroRepository.save(libro);
                });
    }

    @Override
    public Mono<LibroConAutorDTO> obtenerLibroConAutor(String libroId) {
        return libroRepository.findById(libroId)
                .flatMap(libro -> {
                    if (libro.getAutorId() == null) {
                        return Mono.just(new LibroConAutorDTO(libro, null));
                    }

                    return autorClient.obtenerAutor(libro.getAutorId())
                            .map(autor -> new LibroConAutorDTO(libro, autor));
                });
    }
}