package com.daa.movieservice.api.dto;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ShortPersonDto {
    private Long id;
    private String name;
    private String birthDate;
    private String image;
    private Set<String> roles;
}
