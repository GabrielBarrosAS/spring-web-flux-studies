package com.example.webflux.service;

import com.example.webflux.domain.Anime;
import com.example.webflux.repository.AnimeRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class AnimeService {

    private final AnimeRepositoty animeRepositoty;

    public Flux<Anime> findAll(){
        return animeRepositoty.findAll();
    }

    public Mono<Anime> findById(int id){
        return animeRepositoty.findById(id);
    }

}
