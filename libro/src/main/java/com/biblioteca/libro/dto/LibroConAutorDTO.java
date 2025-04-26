package com.biblioteca.libro.dto;

import com.biblioteca.libro.model.Libro;

public record LibroConAutorDTO(
        String id,
        String titulo,
        String isbn,
        String genero,
        Integer anioPublicacion,
        AutorDTO autor
) {
    public LibroConAutorDTO(Libro libro, AutorDTO autor) {
        this(
                libro.getId(),
                libro.getTitulo(),
                libro.getIsbn(),
                libro.getGenero(),
                libro.getAnioPublicacion(),
                autor
        );
    }
}