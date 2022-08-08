package com.algoworks.tweets.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetsDetailResponse {
	private String id;
	private String name;
	private String screenName;
	private String text;
	private String createdAt;
	private String retweetCount;
	private int friendsCount;
	private int listedCount;
	private int followersCount;
	private int favouritesCount;

}
