package com.example.webflux.service;

import com.example.webflux.domain.Anime;
import com.example.webflux.repository.AnimeRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class AnimeService {

    private final AnimeRepositoty animeRepositoty;

    @Value("${application.specifications.query_param}")
    private String SOURCE;

    public Flux<Anime> findAll(){
        return animeRepositoty.findAll();
    }

    public Mono<Anime> findById(int id){
        return animeRepositoty.findById(id)
                .switchIfEmpty(monoResponseNotFoundException());
    }

    public <T> Mono<T> monoResponseNotFoundException(){
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Anime not found"));
    }

    public Mono<Anime> save(Anime anime) {
        anime.setSource(SOURCE);
        return animeRepositoty.save(anime);
    }

    public Mono<Void> update(Anime anime){
        return findById(anime.getId())
                .map(animeFound -> anime.withId(animeFound.getId()))
                .flatMap(animeRepositoty::save)
                .thenEmpty(Mono.empty());
    }

    public Flux<Tuple2<Long, Anime>> findAllCreatedByThisSource(){
        Flux<Anime> animesBySource = animeRepositoty.findBySource(SOURCE);
        long time = 1;
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(time));
        return Flux.zip(interval, animesBySource);
    }
}
