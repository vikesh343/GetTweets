package com.tweets.jsonmodel;

import java.util.List;

import lombok.Data;
@Data
public class Geo {
    private String type;

    private List<String> coordinates;
}
