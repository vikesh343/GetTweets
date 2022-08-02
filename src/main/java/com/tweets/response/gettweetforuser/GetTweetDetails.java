package com.tweets.response.gettweetforuser;

import lombok.Data;

@Data
public class GetTweetDetails {
	private String id;
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
