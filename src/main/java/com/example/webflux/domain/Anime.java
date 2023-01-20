package com.example.webflux.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("anime")
public class Anime {
    @Id
    private Integer id;
    @NotEmpty(message="The name of this anime cannot be empty")
    @NotNull(message="The name of this anime cannot be null")
    private String name;
    private String source;
}
