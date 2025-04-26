package com.biblioteca.libro.controller;

import com.biblioteca.libro.model.Libro;
import com.biblioteca.libro.service.LibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebFluxTest(LibroController.class)
class LibroControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private LibroService libroService;

    @Test
    void obtenerLibro_deberiaRetornar200() {
        when(libroService.obtenerPorId(anyString()))
                .thenReturn(Mono.just(new Libro("Cien años...", "123", "Novela", 1967)));

        webTestClient.get()
                .uri("/libros/1")
                .exchange()
                .expectStatus().isOk();
    }
}