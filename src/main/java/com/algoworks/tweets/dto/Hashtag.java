package com.algoworks.tweets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hashtag {

    private String text;
    private int[] indices;

}
