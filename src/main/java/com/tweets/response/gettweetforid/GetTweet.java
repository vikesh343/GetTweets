package com.tweets.response.gettweetforid;

import lombok.Data;

@Data
public class GetTweet {
	private String id;
	private String name;
	private String userName;
	private String text;
	private String createdAt;
	private String retweetCount;
}
