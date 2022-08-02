package com.tweets.response.getalltweets;

import java.util.List;

public class GetAllTweetsResposne {

	private List<AllTweetsDetails> getAllTweets;

	public List<AllTweetsDetails> getGetAllTweets() {
		return getAllTweets;
	}

	public void setGetAllTweets(List<AllTweetsDetails> getAllTweets) {
		this.getAllTweets = getAllTweets;
	}

	public GetAllTweetsResposne(List<AllTweetsDetails> getAllTweets) {
		super();
		this.getAllTweets = getAllTweets;
	}
	
	public GetAllTweetsResposne() {
		super();	
	}
	
	
}
