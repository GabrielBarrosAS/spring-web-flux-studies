package com.example.webflux.controller;

import com.example.webflux.domain.Anime;
import com.example.webflux.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("animes")
@Slf4j
public class AnimeController {
    private final AnimeService animeService;

    @GetMapping
    public Flux<Anime> listAll(){
        return animeService.findAll();
    }

    @GetMapping("{id}")
    public Mono<Anime> findById(@PathVariable int id){
        return animeService.findById(id);
    }
}
