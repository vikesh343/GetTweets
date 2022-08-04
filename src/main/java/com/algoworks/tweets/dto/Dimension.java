package com.algoworks.tweets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dimension {

    @JsonProperty("w")
    private int width;
    @JsonProperty("h")
    private int height;
    private int resize;

}
