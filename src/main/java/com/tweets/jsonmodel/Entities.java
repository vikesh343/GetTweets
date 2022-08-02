package com.tweets.jsonmodel;

import java.util.List;

import lombok.Data;

@Data
public class Entities {
	private List<Hashtags> hashtags;

    private List<Urls> urls;

    private List<UserMentions> user_mentions;

    private List<Media> media;

    private Url url;

    private Description description;

}
