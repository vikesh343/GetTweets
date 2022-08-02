package com.tweets.jsonmodel;

import java.util.List;

import lombok.Data;

@Data
public class Media {
	private String id;

	private String id_str;

	private List<String> indices;

	private String media_url;

	private String media_url_https;

	private String url;

	private String display_url;

	private String expanded_url;

	private String type;

	private Sizes sizes;
}
