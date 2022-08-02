package com.tweets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweets.businessservice.IGetTweetsBusinessService;
import com.tweets.response.getalltweets.AllTweetsDetails;
import com.tweets.response.getallurls.GetAllUrlsPresentResponse;
import com.tweets.response.gettweetforid.GetTweetForID;
import com.tweets.response.gettweetforuser.GetTweetForUser;
import com.tweets.response.getuserdetails.UserDetails;

@RestController
public class GetTweetsController {

	@Autowired
	IGetTweetsBusinessService businessService;

	@GetMapping(value = "/HealthCheck")
	public String healthCheck() {
		return "OK";
	}

	// Get all tweets (create time, id, and tweet text) available in the archive.
	@GetMapping(value = "/tweets/getalltweets", produces = "application/JSON")
	public List<AllTweetsDetails> getAllTweets() {
		List<AllTweetsDetails> response = businessService.getAllTweetsDetails();
		return response;
	}

	// Get all known Twitter users included in the archive.
	@GetMapping(value = "/tweets/getalluserdetails", produces = "application/JSON")
	public List<UserDetails> getAllUserDetails() {
		List<UserDetails> response = businessService.getAllUserDetails();
		return response;
	}

	// Get list of all the urls present in the json, grouped based on tweet id
	@GetMapping(value = "/tweets/getallurls", produces = "application/JSON")
	public List<GetAllUrlsPresentResponse> getAllUrls() {
		List<GetAllUrlsPresentResponse> response = businessService.getAllUrlsPresent();
		return response;
	}

	// Get the details about a given tweet for given the tweet’s id).
	@GetMapping(value = "/tweets/gettweetforid/{id}", produces = "application/JSON")
	public GetTweetForID getTweetForID(@PathVariable("id") String id) {
		GetTweetForID getTweet = new GetTweetForID();
		getTweet = businessService.getTweetDetailsForID(id);
		return getTweet;
	}

	// Get detailed profile information about a given Twitter user for given the
	// user’s screen name)
	@GetMapping(value = "/tweets/gettweetforuser/{user}", produces = "application/JSON")
	public GetTweetForUser getTweetForUser(@PathVariable("user") String user) {
		GetTweetForUser getTweet = new GetTweetForUser();
		getTweet = businessService.getTweetDetailsForUser(user);
		return getTweet;
	}
}
