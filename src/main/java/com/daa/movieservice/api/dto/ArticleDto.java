package com.daa.movieservice.api.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ArticleDto {
    private Long id;
    private String title;
    private Date date;
    private String content;
    private Integer positiveRatting;
    private Integer negativeRatting;
}
