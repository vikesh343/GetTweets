package com.tweets.jsonmodel;

import java.util.List;

import lombok.Data;
@Data
public class Place {
	private String id;

    private String url;

    private String place_type;

    private String name;

    private String full_name;

    private String country_code;

    private String country;

    private List<String> polylines;

    private BoundingBox bounding_box;

    private Attributes attributes;
}
