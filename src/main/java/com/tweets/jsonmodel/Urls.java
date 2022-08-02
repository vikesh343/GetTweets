package com.tweets.jsonmodel;

import java.util.List;

import lombok.Data;
@Data
public class Urls {
	 	private String url;

	    private String expanded_url;

	    private String display_url;

	    private List<String> indices;
}
