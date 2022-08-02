package com.tweets.jsonmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class User {
	private String id;

	private String id_str;

	private String name;

	private String screen_name;

	private String location;

	private String description;

	private String url;

	private Entities entities;

	private boolean _protected;

	private int followers_count;

	private int friends_count;

	private int listed_count;

	private String created_at;

	private int favourites_count;

	private int utc_offset;

	private String time_zone;

	private boolean geo_enabled;

	private boolean verified;

	private int statuses_count;

	private String lang;

	private boolean contributors_enabled;

	private boolean is_translator;

	private String profile_background_color;

	private String profile_background_image_url;

	private String profile_background_image_url_https;

	private boolean profile_background_tile;

	private String profile_image_url;

	private String profile_image_url_https;

	private String profile_link_color;

	private String profile_sidebar_border_color;

	private String profile_sidebar_fill_color;

	private String profile_text_color;

	private boolean profile_use_background_image;

	private boolean default_profile;

	private boolean default_profile_image;

	private String following;

	private boolean follow_request_sent;

	private String notifications;

}
