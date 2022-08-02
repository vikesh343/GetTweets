package com.tweets.jsonmodel;

import java.util.List;

import lombok.Data;
@Data
public class Hashtags {
    private String text;

    private List<String> indices;

}
