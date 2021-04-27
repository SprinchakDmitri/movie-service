package com.daa.movieservice.api.dto;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ShortPersonDto {
    private String name;
    private String birthDate;
    private Set<String> roles;
}
