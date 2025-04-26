package com.biblioteca.libro.client;

import com.biblioteca.libro.dto.AutorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(name = "autor-service", path = "/autores")
public interface AutorClient {

    @GetMapping("/{id}")
    Mono<AutorDTO> obtenerAutor(@PathVariable String id);
}