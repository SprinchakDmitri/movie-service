package com.daa.movieservice.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ScoreDto {
    private Integer numOfVotes;
    private Double score;

    public ScoreDto(List<Integer> list) {
        int temp = 0;
        for (Integer val : list) {
            temp += val;
        }
        this.numOfVotes = list.size();
        this.score = (double) temp / list.size();
    }
}
