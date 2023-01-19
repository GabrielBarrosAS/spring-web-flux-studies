package com.example.webflux.repository;

import com.example.webflux.domain.Anime;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AnimeRepositoty extends ReactiveCrudRepository<Anime, Integer> {

    Mono<Anime> findById(int id);
    Flux<Anime> findBySource(String source);
}
