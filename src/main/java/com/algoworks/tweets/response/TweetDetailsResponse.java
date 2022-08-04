package com.algoworks.tweets.response;

import lombok.Data;

@Data
public class TweetDetailsResponse {
	private ApplicationError applicationError;
	private TweetsDetailResponse tweetDetails;
}
