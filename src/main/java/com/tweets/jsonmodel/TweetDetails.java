package com.tweets.jsonmodel;

import lombok.Data;

@Data
public class TweetDetails {
	private String created_at;

    private String id;

    private String id_str;

    private String text;

    private String source;

    private boolean truncated;

    private String in_reply_to_status_id;

    private String in_reply_to_status_id_str;

    private String in_reply_to_user_id;

    private String in_reply_to_user_id_str;

    private String in_reply_to_screen_name;

    private User user;

    private Geo geo;

    private Coordinates coordinates;

    private Place place;

    private String contributors;

    private String retweet_count;

    private Entities entities;

    private boolean favorited;

    private boolean retweeted;

    private boolean possibly_sensitive;

    private String lang;

	
    
    
    
}


