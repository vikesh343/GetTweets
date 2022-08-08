package com.algoworks.tweets.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algoworks.tweets.businessservice.ITweetBusinessService;
import com.algoworks.tweets.exception.CustomApplicationException;
import com.algoworks.tweets.response.Links;
import com.algoworks.tweets.response.TweetDetailsResponse;
import com.algoworks.tweets.response.TweetsDetailResponse;
import com.algoworks.tweets.response.UsersDetailsResponse;
import com.algoworks.tweets.util.ApplicationConstants;
import com.algoworks.tweets.response.UserDetailsResponse;

@RestController
@RequestMapping("/algoworks/api/v1")
public class TweetsController {
	
	Logger log = Logger.getLogger(TweetsController.class.getName());

	@Autowired
	ITweetBusinessService businessService;

	@GetMapping("/healthcheck")
	public String healthCheck() {
		return "OK";
	}

	@GetMapping("/tweet")
	public List<TweetsDetailResponse> getAllTweets() {
		List<TweetsDetailResponse> response = new ArrayList<>();
		try {
			response = businessService.getAllTweetsDetails();
		} catch (Exception e) {
			log.info(e.toString());
			throw new CustomApplicationException(ApplicationConstants.ERR_IN_SERVICE);
		}
		return response;
	}

	@GetMapping("/user")
	public List<UsersDetailsResponse> getUsersDetails() {
		List<UsersDetailsResponse> response = new ArrayList<>();
		try {
			response = businessService.getAllUserDetails();
		} catch (Exception e) {
			log.info(e.toString());
			throw new CustomApplicationException(ApplicationConstants.ERR_IN_SERVICE);
		}
		return response;
	}

	@GetMapping("/urls")
	public Map<Long, Links> getAllUrls() {
		Map<Long, Links> response = new HashMap<>();
		try {
			response = businessService.getAllUrlsPresent();
		} catch (Exception e) {
			log.info(e.toString());
			throw new CustomApplicationException(ApplicationConstants.ERR_IN_SERVICE);
		}
		return response;
	}

	@GetMapping("/tweet/{id}")
	public TweetDetailsResponse getTweetByID(@PathVariable(value = "id", required = true) long id) {
		TweetDetailsResponse getTweet = new TweetDetailsResponse();
		if (id <= 0) {
			throw new CustomApplicationException(ApplicationConstants.TWEET_ID_GREATER_THAN_ZERO);
		}
		try {
			getTweet = businessService.getTweetDetailsByID(id);
		} catch (Exception e) {
			log.info(e.toString());
			throw new CustomApplicationException(ApplicationConstants.ERR_IN_SERVICE);
		}
		return getTweet;
	}

	@GetMapping("/user/{screenName}")
	public UserDetailsResponse getUserByScreenName(@PathVariable(value = "screenName", required = true) String screenName) {
		UserDetailsResponse getTweet = new UserDetailsResponse();
		if (screenName == null || screenName.isBlank()) {
			throw new CustomApplicationException(ApplicationConstants.SCREEN_NAME_NOT_NULL_OR_BLANK);
		}
		try {
			getTweet = businessService.getUserDetailsByScreenName(screenName);
		} catch (Exception e) {
			log.info(e.toString());
			throw new CustomApplicationException(ApplicationConstants.ERR_IN_SERVICE);
		}
		return getTweet;
	}
}
