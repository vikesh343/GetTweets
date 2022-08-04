package com.algoworks.tweets.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.algoworks.tweets.dto.TweetDetails;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Utility {
	Logger log = Logger.getLogger(Utility.class.getName());
	
	@Value("${json.file.path}")
	private String jsonFilePath;
	
	public List<TweetDetails> jsonReader() {
		List<TweetDetails> tweets = new ArrayList<>();
		TypeReference<List<TweetDetails>> typeReference = new TypeReference<List<TweetDetails>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream(jsonFilePath);
		try {
			tweets = new ObjectMapper().readValue(inputStream, typeReference);
		} catch (Exception e) {
			log.info("Unable to read file : " + e.getMessage());
			throw new IllegalArgumentException();
		}
		return tweets;
	}
}
