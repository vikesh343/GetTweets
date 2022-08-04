package com.algoworks.tweets.response;

import lombok.Data;

@Data
public class TweetsDetailResponse {
	private long id;
	private String name;
	private String userName;
	private String text;
	private String createdAt;
	private String retweetCount;
	private int friendsCount;
	private int listedCount;
	private int followersCount;
	private int favouritesCount;

}
