package com.tweets.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweets.jsonmodel.TweetDetails;

@Component
public class Utility {
	public List<TweetDetails> tweetDetails() {
		List<TweetDetails> tweets = new ArrayList<>();
		TypeReference<List<TweetDetails>> typeReference = new TypeReference<List<TweetDetails>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream(ApplicationConstants.TWEET_PATH);
		try {
			tweets = new ObjectMapper().readValue(inputStream, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tweets;
	}
}
