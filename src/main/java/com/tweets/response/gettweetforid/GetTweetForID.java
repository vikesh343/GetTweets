package com.tweets.response.gettweetforid;

import com.tweets.util.ApplicationError;

import lombok.Data;

@Data
public class GetTweetForID {
	private ApplicationError applicationError;
	private GetTweet getTweet;
}
