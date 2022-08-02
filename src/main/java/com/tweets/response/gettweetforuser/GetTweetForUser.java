package com.tweets.response.gettweetforuser;

import com.tweets.util.ApplicationError;

import lombok.Data;
@Data
public class GetTweetForUser {
	private ApplicationError applicationError;
	private GetTweetDetails getTweetDeatils;
}
