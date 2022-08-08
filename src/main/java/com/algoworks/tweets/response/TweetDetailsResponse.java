package com.algoworks.tweets.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetDetailsResponse {
	private ApplicationError applicationError;
	private TweetsDetailResponse tweetDetails;
}
